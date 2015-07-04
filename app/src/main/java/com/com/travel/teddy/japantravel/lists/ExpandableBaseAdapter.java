package com.com.travel.teddy.japantravel.lists;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.travel.teddy.japantravel.R;

import java.util.List;

/**
 * Created by teddy on 2015/6/28.
 */


public class ExpandableBaseAdapter extends BaseExpandableListAdapter {
    private List<String> groupArray;
    private List<List<String>> childArray;
    private Context FragmentContext;
    private LayoutInflater inflater;
    public ExpandableBaseAdapter(Context context,List<String> groupArray,List<List<String>> childArray) {
        FragmentContext = context;
        inflater =  LayoutInflater.from(FragmentContext);
        this.groupArray = groupArray;
        this.childArray = childArray;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childArray.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupArray.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childArray.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View CustonGroupView, ViewGroup viewGroup) {
        String GroupText = groupArray.get(groupPosition);
        CustonGroupView = inflater.inflate(R.layout.group_expandablelistview,viewGroup,false);
        TextView GroupTitle = (TextView)CustonGroupView.findViewById(R.id.GroupText);
        GroupTitle.setText(GroupText);
        return CustonGroupView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View CustonChildView, ViewGroup viewGroup) {
        String ChildText = childArray.get(groupPosition).get(childPosition);
        CustonChildView = inflater.inflate(R.layout.child_expandablelistview,viewGroup,false);
        TextView ChildTitle = (TextView)CustonChildView.findViewById(R.id.ChildText);
        ChildTitle.setText(ChildText);
        return CustonChildView;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override
    public int getGroupCount() {
        return groupArray.size();
    }


}
