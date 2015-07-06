package com.com.travel.teddy.japantravel.lists;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.travel.teddy.japantravel.R;

/**
 * Created by teddy on 2015/7/5.
 */
public class GroupListViewBaseAdpater extends BaseAdapter{
    private LayoutInflater inflater;
    String [] Title;
    private Context FragmentContext;
    public GroupListViewBaseAdpater(Context c, String[] title){
        inflater = LayoutInflater.from(c);
        this.Title = title;
        this.FragmentContext = c;
    }
    @Override
    public int getCount() {
        return Title.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View Custom, ViewGroup viewGroup) {
        Custom = inflater.inflate(R.layout.group_expandablelistview,viewGroup,false);
        TextView GroupText;
        GroupText = (TextView) Custom.findViewById(R.id.GroupText);
        Typeface face=Typeface.createFromAsset(FragmentContext.getAssets(),"fonts/Roboto-Regular.ttf");
        GroupText.setTypeface(face);
        GroupText.setText(Title[i]);
        return Custom;
    }
}
