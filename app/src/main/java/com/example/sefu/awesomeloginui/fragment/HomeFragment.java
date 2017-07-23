package com.example.sefu.awesomeloginui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sefu.awesomeloginui.R;
import com.example.sefu.awesomeloginui.adapter.CardHomeDateAdapter;
import com.example.sefu.awesomeloginui.adapter.CardHomeMeetingAdapter;
import com.example.sefu.awesomeloginui.model.DataDateModel;
import com.example.sefu.awesomeloginui.model.DataMeetingModel;
import com.example.sefu.awesomeloginui.model.MyDaysData;
import com.example.sefu.awesomeloginui.model.MyMeetingData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private static RecyclerView.Adapter adapter, adapterTwo;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView, recyclerViewTwo;
    private static ArrayList<DataDateModel> data;

    private static ArrayList<DataMeetingModel> dataMeeting;

    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;

    RecyclerView.ItemDecoration itemDecoration;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataDateModel>();
        for (int i = 0; i < MyDaysData.dayArray.length; i++) {
            data.add(new DataDateModel(
                    MyDaysData.dayArray[i],
                    MyDaysData.dateArray[i],
                    MyDaysData.id_[i]
//                    MyDaysData.drawableArray[i]
            ));
        }

        removedItems = new ArrayList<Integer>();

        adapter = new CardHomeDateAdapter(data);
        recyclerView.setAdapter(adapter);


        recyclerViewTwo = (RecyclerView) v.findViewById(R.id.my_recycler_view_two);
        recyclerViewTwo.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewTwo.setLayoutManager(layoutManager);
        recyclerViewTwo.setItemAnimator(new DefaultItemAnimator());

        dataMeeting = new ArrayList<DataMeetingModel>();
        for (int i = 0; i < MyMeetingData.meetingTypeArray.length; i++) {
            dataMeeting.add(new DataMeetingModel(
                    MyMeetingData.meetingTypeArray[i],
                    MyMeetingData.timeArray[i],
                    MyMeetingData.placeArray[i],
                    MyMeetingData.id_[i],
                    MyMeetingData.drawableArray[i]
            ));
        }

        removedItems = new ArrayList<Integer>();
        itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerViewTwo.addItemDecoration(itemDecoration);

        adapterTwo = new CardHomeMeetingAdapter(dataMeeting);
        recyclerViewTwo.setAdapter(adapterTwo);


        return v;
    }


}
