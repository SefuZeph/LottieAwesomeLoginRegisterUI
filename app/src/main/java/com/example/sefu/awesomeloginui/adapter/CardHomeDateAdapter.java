package com.example.sefu.awesomeloginui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sefu.awesomeloginui.R;
import com.example.sefu.awesomeloginui.model.DataDateModel;

import java.util.ArrayList;


public class CardHomeDateAdapter extends RecyclerView.Adapter<CardHomeDateAdapter.MyViewHolder> {

    private ArrayList<DataDateModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewDay;
        TextView textViewDate;
        //ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewDay = (TextView) itemView.findViewById(R.id.textViewDay);
            this.textViewDate = (TextView) itemView.findViewById(R.id.textViewDate);
            //this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public CardHomeDateAdapter(ArrayList<DataDateModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_home_date, parent, false);

//        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewDay = holder.textViewDay;
        TextView textViewDate = holder.textViewDate;
//        ImageView imageView = holder.imageViewIcon;

        textViewDay.setText(dataSet.get(listPosition).getName());
        textViewDate.setText(dataSet.get(listPosition).getVersion());
//        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
