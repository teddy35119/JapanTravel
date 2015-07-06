package com.teddy.japantravel.fragment;


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
        String[] WebTitle = {
                            "心齋橋筋藥妝店 採買心得、退稅",
                            "bic camera 退稅",
                            "bic camera必買超便宜電器聖地",
                            "大阪伴手禮",
                            "梅田新建大型百貨Grand Osaka",
                            "國際牌Panadonic EH-CNA96吹風機",
                            "逛街小地圖，心齋橋、道頓崛、美國村",
                            "大阪必買藥妝。零食"
        };
        String[] WebUrl = {
                " http://lohas.pixnet.net/blog/post/41875834-%5b%e5%a4%a7%e9%98%aa%e5%bf%83%e9%bd%8b%e6%a9%8b%e5%bf%85%e8%b2%b7%e8%97%a5%e5%a6%9d%e5%bf%83%e5%be%97%2b%e9%80%80%e7%a8%85%5d-%e5%bf%83%e9%bd%8b%e6%a9%8b%e7%ad%8b%e8%97%a5#ixzz3ekH8G7Dw",
                "http://www.finduheart.com/2015/03/bic-camera.html",
                "http://abcfamily88.pixnet.net/blog/post/109750556-%E2%96%8C%E6%97%A5%E6%9C%AC%E5%A4%A7%E9%98%AA%E3%80%82%E8%B3%BC%E7%89%A9%E2%96%8C%E6%97%A5%E6%9C%AC%E5%BF%85%E8%B2%B7%E8%B6%85%E4%BE%BF%E5%AE%9C%E9%9B%BB%E5%99%A8%E8%81%96%E5%9C%B0",
                "https://www.tsunagujapan.com/zh-hant/10-souvenirs-you-must-buy-in-osaka/",
                "http://lohas.pixnet.net/blog/post/32061271-%5B%E5%A4%A7%E9%98%AA%E8%87%AA%E7%94%B1%E8%A1%8C%5D-%E6%A2%85%E7%94%B0%E6%96%B0%E5%90%8D%E6%89%80%E3%80%81%E6%96%B0%E5%9C%B0%E6%A8%99-grand-front-os",
                "http://meiko1101.pixnet.net/blog/post/30951547",
                "http://stellahyc.pixnet.net/blog/post/49431058-%E3%80%90%E5%A4%A7%E9%98%AA%E3%80%91%E9%80%9B%E8%A1%97%E5%B0%8F%E5%9C%B0%E5%9C%96%EF%BC%8C%E5%BF%83%E9%BD%8B%E6%A9%8B%E3%80%81%E9%81%93%E9%A0%93%E5%B4%9B%E3%80%81%E7%BE%8E%E5%9C%8B",
                "http://cline1413.pixnet.net/blog/post/401562604-%E2%96%8C%E6%97%A5%E6%9C%AC%E5%BF%85%E8%B2%B7%E2%96%8C%E6%9D%B1%E4%BA%AC%26%E5%A4%A7%E9%98%AA%E5%BF%85%E8%B2%B7%E8%97%A5%E5%A6%9D%E3%80%82%E9%9B%B6%E9%A3%9F%E3%80%82%E4%BC%B4"
        };
        FragmentListView  = (ListView) RootView.findViewById(R.id.ViewListView);
        FragmentListView.setAdapter(new CustomListViewBaseAdapter(getActivity(),WebTitle,WebUrl));
        // Inflate the layout for this fragment
        return RootView;
    }

}
