package com.teddy.japantravel.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.com.travel.teddy.japantravel.lists.CustomListViewBaseAdapter;
import com.travel.teddy.japantravel.R;

public class TrafficFragment extends Fragment {



    public TrafficFragment() {
        // Required empty public constructor
    }

    private View RootView;
    private ListView FragmentListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RootView = inflater.inflate(R.layout.fragment_traffic, container, false);
        String[] WebTitle = {
                            "關西空港介紹",
                            "關西空港到難波",
                            "大阪地鐵地圖",
                            "大阪到奈良",
                            "大阪到京都"};

        String[] WebUrl = {
                "http://nicklee.tw/?p=754",
                "http://nicklee.tw/?p=494",
                "http://blueg1019.pixnet.net/blog/post/2770074-%5B%E9%81%8A%E8%A8%98%5D2011%E5%A4%A7%E9%98%AA%E8%A1%8C_%E5%A4%A7%E9%98%AA%E4%BA%A4%E9%80%9A%E4%B8%80%E9%BB%9E%E9%80%9A%EF%BC%81%E5%9C%B0%E9%90%B5%E9%9B%BB%E9%90%B5",
                "http://milktea721.pixnet.net/blog/post/30532996-%5B%E6%97%A5%E6%9C%AC%CB%99%E5%A5%88%E8%89%AF%5D%E5%BE%9E%E5%A4%A7%E9%98%AA%E5%87%BA%E7%99%BC%E7%9A%84%E5%A5%88%E8%89%AF%E5%8D%8A%E6%97%A5%E6%97%85%E8%A1%8C%3A%E6%9D%B1%E5%A4%A7",
                "http://nicklee.tw/?p=1018"};
        FragmentListView  = (ListView) RootView.findViewById(R.id.TrafficListView);
        FragmentListView.setAdapter(new CustomListViewBaseAdapter(getActivity(),WebTitle,WebUrl));
        // Inflate the layout for this fragment
        return RootView;
    }



}
