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
    private ArrayList<String> WebTitle = new ArrayList<String>();
    private ArrayList<String> WebUrl =  new ArrayList<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RootView = inflater.inflate(R.layout.fragment_basic, container, false);
        String[] aa = {"在大阪50件可以做的事情","大阪各區美食總覽"};
        String[] bb = {"https://www.tsunagujapan.com/zh-hant/50-things-to-do-in-osaka/",
                           "http://lohas.pixnet.net/blog/post/32293995"};
       // ArrayList<String> WebTitle = new ArrayList<String>();
        //ArrayList<String> WebUrl = new ArrayList<String>();
        FragmentListView  = (ListView) RootView.findViewById(R.id.BasicListView);
        setFooter(inflater);
        WebTitle.add("在大阪50件可以做的事情");
        WebUrl.add("https://www.tsunagujapan.com/zh-hant/50-things-to-do-in-osaka/");
        FragmentListView.setAdapter(new TestBaseAdapter(getActivity(),WebTitle,WebUrl));

        //FragmentListView.setAdapter(new CustomListViewBaseAdapter(getActivity(),WebTitle,WebUrl));




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
                addWebDialog();
            }
        });
    }
    private  EditText addWebText;
    private  EditText  addWebUrl;
    private void addWebDialog(){
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
    }
}
