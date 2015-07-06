package com.teddy.japantravel.fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.com.travel.teddy.japantravel.lists.CustomListViewBaseAdapter;
import com.com.travel.teddy.japantravel.lists.TestBaseAdapter;
import com.travel.teddy.japantravel.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasicFragment extends Fragment {


    public BasicFragment() {
        // Required empty public constructor
    }

    private View RootView;
    private ListView FragmentListView;
    //private ArrayList<String> WebTitle = new ArrayList<String>();
    //private ArrayList<String> WebUrl =  new ArrayList<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RootView = inflater.inflate(R.layout.fragment_basic, container, false);
        String[] WebTitle = {
                        "在大阪50件可以做的事情",
                        "大阪各區美食總覽",
                        "大阪周遊卡 必玩11個熱門",
                        "去京都一定要做的20件事情",
                        "遊大阪來這就對了！10大基本景點",
                        "大阪必買藥妝50種商品"
                        };
        String[] WebUrl = {
                       "https://www.tsunagujapan.com/zh-hant/50-things-to-do-in-osaka/",
                       "http://lohas.pixnet.net/blog/post/32293995",
                       "http://cline1413.pixnet.net/blog/post/406128199-%E2%96%8C%E5%A4%A7%E9%98%AA%E8%87%AA%E7%94%B1%E8%A1%8C%E2%96%8C%E2%99%A5%E5%A4%A7%E9%98%AA%E5%91%A8%E9%81%8A%E5%8D%A1%E2%99%A5%E5%BF%85%E7%8E%A911%E5%80%8B%E7%86%B1%E9%96%80",
                       "http://maymay1231.pixnet.net/blog/post/194725689-%5B%E8%B3%87%E8%A8%8A%5D-%E5%A6%82%E6%9E%9C%E5%8E%BB%E4%BA%AC%E9%83%BD%E6%97%85%E8%A1%8C%EF%BC%8C%E4%B8%80%E5%AE%9A%E8%A6%81%E5%81%9A%E7%9A%84%E4%BA%8C%E5%8D%81%E4%BB%B6%E4%BA%8B",
                       "http://travel.ettoday.net/article/482393.htm",
                       "http://missrachelnina.pixnet.net/blog/post/255486520-%E3%80%902015%E6%97%A5%E6%9C%AC%E5%A4%A7%E9%98%AA%E4%BA%AC%E9%83%BD%E8%87%AA%E7%94%B1%E8%A1%8C%E3%80%91%E5%BF%85%E8%B2%B7%E8%97%A5%E5%A6%9D50%E7%A8%AE%E5%95%86%E5%93%81"
        };
       // ArrayList<String> WebTitle = new ArrayList<String>();
        //ArrayList<String> WebUrl = new ArrayList<String>();
        FragmentListView  = (ListView) RootView.findViewById(R.id.BasicListView);
        //---------------------可新增版本--------------------------------------
        //setFooter(inflater);
        //WebTitle.add("在大阪50件可以做的事情");
        //WebUrl.add("https://www.tsunagujapan.com/zh-hant/50-things-to-do-in-osaka/");
        //FragmentListView.setAdapter(new TestBaseAdapter(getActivity(),WebTitle,WebUrl));


        FragmentListView.setAdapter(new CustomListViewBaseAdapter(getActivity(),WebTitle,WebUrl));




        return RootView;
    }
    private void setFooter(LayoutInflater inflater){
        View footer = inflater.inflate(R.layout.listview_footer, FragmentListView, false);
        FragmentListView.addFooterView(footer,null, true);
        Button ClickAddButton = (Button) footer.findViewById(R.id.button);
        ClickAddButton.setText(getString(R.string.ClickAddWeb));
        ClickAddButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                //addWebDialog();
            }
        });
    }
    private  EditText addWebText;
    private  EditText  addWebUrl;
    /*private void addWebDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View DialogView = inflater.inflate(R.layout.inputweb_dialog, null);
       addWebText  = (EditText) DialogView.findViewById(R.id.addWebText);
       addWebUrl  = (EditText) DialogView.findViewById(R.id.addUrlText);

        builder.setView(DialogView)
                .setTitle(R.string.AddWeb)

                .setPositiveButton(R.string.Confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                        if(!addWebText.getText().toString().equals("") && !addWebUrl.getText().toString().equals("")){
                            WebTitle.add(addWebText.getText().toString());
                            WebUrl.add(addWebUrl.getText().toString());
                            addWebText.setText("");
                            addWebUrl.setText("");
                            FragmentListView.setAdapter(new TestBaseAdapter(getActivity(),WebTitle,WebUrl));

                        }else {
                            Toast.makeText(getActivity(),"內容不得為空",Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        AlertDialog AddWebDialog = builder.create();
        AddWebDialog.show();
    }*/
}
