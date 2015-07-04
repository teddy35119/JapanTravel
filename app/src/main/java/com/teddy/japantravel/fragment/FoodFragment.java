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

public class FoodFragment extends Fragment{



    public FoodFragment() {
        // Required empty public constructor
    }

    private View RootView;
    private ListView FragmentListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RootView = inflater.inflate(R.layout.fragment_food, container, false);
        String[] WebTitle = {"道敦窟&心齋橋 逛街美食","黑門市場 網友排名前10名美食","黑門市場  浜藤本店 河豚大餐"};
        String[] WebUrl = {"http://missrachelnina.pixnet.net/blog/post/251404228-%E3%80%90%E5%A4%A7%E9%98%AA%E8%87%AA%E7%94%B1%E8%A1%8C%E3%80%912015-%E5%BF%83%E9%BD%8B%E6%A9%8B%26%E9%81%93%E9%A0%93%E5%A0%80%E5%95%86%E5%BA%97%E8%A1%97-%E9%80%9B",
                                "http://qpjj.pixnet.net/blog/post/4584095-%E3%80%90%E5%A4%A7%E9%98%AA%E3%80%91%E6%88%91%E5%BF%83%E7%9B%AE%E4%B8%AD%E7%9A%84%E3%80%8C%E9%BB%91%E9%96%80%E5%B8%82%E5%A0%B4%E3%80%8D%E7%BE%8E%E9%A3%9F%E6%8E%A8%E8%96%A6%E6%8E%92",
                                "http://lohas.pixnet.net/blog/post/28217051-%5B%E6%97%A5%E6%9C%AC.%E5%A4%A7%E9%98%AA%5D-%E9%BB%91%E9%96%80%E5%B8%82%E5%A0%B4-%E6%B5%9C%E8%97%A4-%E6%9C%AC%E5%BA%97-@-%E5%A5%BD%E5%90%83%E6%B2%B3%E8%B1%9A%E3%80%81"};
        FragmentListView  = (ListView) RootView.findViewById(R.id.FoodListView);
        FragmentListView.setAdapter(new CustomListViewBaseAdapter(getActivity(),WebTitle,WebUrl));
        // Inflate the layout for this fragment
        return RootView;
    }

}
