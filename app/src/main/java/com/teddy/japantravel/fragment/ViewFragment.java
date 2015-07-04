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


public class ViewFragment extends Fragment {



    public ViewFragment() {
        // Required empty public constructor
    }

    private View RootView;
    private ListView FragmentListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RootView = inflater.inflate(R.layout.fragment_view, container, false);
        String[] WebTitle = {"心齋橋筋藥妝店 採買心得、退稅","bic camera 退稅","大阪伴手禮","梅田新建大型百貨Grand Osaka","國際牌Panadonic EH-CNA96吹風機"};
        String[] WebUrl = {
                " http://lohas.pixnet.net/blog/post/41875834-%5b%e5%a4%a7%e9%98%aa%e5%bf%83%e9%bd%8b%e6%a9%8b%e5%bf%85%e8%b2%b7%e8%97%a5%e5%a6%9d%e5%bf%83%e5%be%97%2b%e9%80%80%e7%a8%85%5d-%e5%bf%83%e9%bd%8b%e6%a9%8b%e7%ad%8b%e8%97%a5#ixzz3ekH8G7Dw",
                "http://www.finduheart.com/2015/03/bic-camera.html",
                "https://www.tsunagujapan.com/zh-hant/10-souvenirs-you-must-buy-in-osaka/",
                "http://lohas.pixnet.net/blog/post/32061271-%5B%E5%A4%A7%E9%98%AA%E8%87%AA%E7%94%B1%E8%A1%8C%5D-%E6%A2%85%E7%94%B0%E6%96%B0%E5%90%8D%E6%89%80%E3%80%81%E6%96%B0%E5%9C%B0%E6%A8%99-grand-front-os",
                "http://meiko1101.pixnet.net/blog/post/30951547"};
        FragmentListView  = (ListView) RootView.findViewById(R.id.ViewListView);
        FragmentListView.setAdapter(new CustomListViewBaseAdapter(getActivity(),WebTitle,WebUrl));
        // Inflate the layout for this fragment
        return RootView;
    }

}
