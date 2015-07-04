package com.com.travel.teddy.japantravel.lists;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.teddy.japantravel.fragment.BasicFragment;
import com.travel.teddy.japantravel.MainActivity;
import com.travel.teddy.japantravel.R;

import java.util.ArrayList;

/**
 * Created by teddy on 2015/7/4.
 */
public class TestBaseAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    ArrayList<String> WebTitle = null;
    ArrayList<String> WebUrl = null;
    private Context FragmentContext;

    public TestBaseAdapter(Context context,ArrayList<String> WebTitle,ArrayList<String> WebUrl){
        inflater = LayoutInflater.from(context);
        this.WebTitle = WebTitle;
        this.WebUrl = WebUrl;
        this.FragmentContext = context;

    }
    @Override
    public int getCount() {

        return WebTitle.size();
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
    public View getView(int position, View Custom, ViewGroup viewGroup) {

        Custom = inflater.inflate(R.layout.custom_listview,viewGroup,false);
        TextView WebTitleText;
        WebTitleText = (TextView) Custom.findViewById(R.id.WebTitleText);
        WebTitleText.setText(WebTitle.get(position));
        Custom.setOnClickListener(new OnClickListener(WebTitle.get(position),WebUrl.get(position)){});
        Custom.setOnLongClickListener(new OnLongClickListener(position){});
        return Custom;
    }
    class OnLongClickListener implements View.OnLongClickListener{
        private int RemovePosition;
        public OnLongClickListener(int position){
            this.RemovePosition = position;
        }

        @Override
        public boolean onLongClick(View view) {
            RemoveListViewDialog(RemovePosition);
            //WebTitle.remove(RemovePosition);
            //WebUrl.remove(RemovePosition);
            Log.v("TEST","in");
            return true;
        }
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
    private void RemoveListViewDialog(int RemovePosition){
        final int pos = RemovePosition;
        AlertDialog.Builder builder = new AlertDialog.Builder(FragmentContext);
        builder.setTitle(FragmentContext.getString(R.string.DeleteThisWeb))
                .setMessage(WebTitle.get(pos))
                .setPositiveButton(R.string.Confirm, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                try {
                                    WebTitle.remove(pos);
                                    WebUrl.remove(pos);
                                    Intent intent = new Intent(FragmentContext, MainActivity.class);
                                    FragmentContext.startActivity(intent);

                                } catch (Exception e) {
                                    e.printStackTrace();
                                    Log.v("TEST", "aa");
                                }
                            }
                        }

                ).setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }
        );
                AlertDialog RemoveDialog = builder.create();
                RemoveDialog.show();

        }//dialog end


    }//adapter end
