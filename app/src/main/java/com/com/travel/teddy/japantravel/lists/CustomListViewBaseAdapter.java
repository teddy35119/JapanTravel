package com.com.travel.teddy.japantravel.lists;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.travel.teddy.japantravel.R;

import java.util.ArrayList;

/**
 * Created by teddy on 2015/7/3.
 */
public class CustomListViewBaseAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    String [] WebTitle;
    String [] WebUrl;
    ArrayList<String> TestTitle;
    ArrayList<String> TestUrl;
    private Context FragmentContext;
    public CustomListViewBaseAdapter(Context context,String[] WebTitle, String [] WebUrl){
        inflater = LayoutInflater.from(context);
        this.WebTitle = WebTitle;
        this.WebUrl = WebUrl;
        this.FragmentContext = context;

    }
    public CustomListViewBaseAdapter(Context context,ArrayList<String> WebTitle,ArrayList<String> WebUrl){
        inflater = LayoutInflater.from(context);
        this.TestTitle = WebTitle;
        this.TestUrl = WebUrl;
        this.FragmentContext = context;

    }
    @Override
    public int getCount() {
        return WebTitle.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View Custom, ViewGroup viewGroup) {

        Custom = inflater.inflate(R.layout.custom_listview,viewGroup,false);
        TextView WebTitleText;
        WebTitleText = (TextView) Custom.findViewById(R.id.WebTitleText);
        WebTitleText.setText(WebTitle[i]);
        Custom.setOnClickListener(new OnClickListener(WebTitle[i],WebUrl[i]){});
        return Custom;
    }
    class OnClickListener implements View.OnClickListener{
        private String WebTitle;
        private String WebUrl;
        public OnClickListener(String WebTitle,String WebUrl){
            this.WebTitle = WebTitle;
            this.WebUrl = WebUrl;
        }
        @Override
        public void onClick(View view) {
            Uri uri = Uri.parse(WebUrl);
            Intent WebOn = new Intent(Intent.ACTION_VIEW, uri);
            FragmentContext.startActivity(WebOn);
        }
    }

}
