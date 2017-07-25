package com.example.sefu.awesomeloginui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sefu.awesomeloginui.R;
import com.example.sefu.awesomeloginui.adapter.CardGroupActiveAdapter;
import com.example.sefu.awesomeloginui.model.DataGroupActiveModel;
import com.example.sefu.awesomeloginui.model.MyGroupActiveData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActiveFragment extends Fragment {

    private static RecyclerView.Adapter adapter;
    StaggeredGridLayoutManager gridLayoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataGroupActiveModel> data;

    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;


    public ActiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_active, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataGroupActiveModel>();
        for (int i = 0; i < MyGroupActiveData.groupNameArray.length; i++) {
            data.add(new DataGroupActiveModel(
                    MyGroupActiveData.groupNameArray[i],
                    MyGroupActiveData.drawableArray[i],
                    MyGroupActiveData.id_[i]
            ));
        }

        removedItems = new ArrayList<Integer>();

        adapter = new CardGroupActiveAdapter(data);
        recyclerView.setAdapter(adapter);

        return view;
    }

}
