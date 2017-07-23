package com.example.sefu.awesomeloginui.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sefu.awesomeloginui.R;
import com.example.sefu.awesomeloginui.model.DataMeetingModel;

import java.util.ArrayList;

/**
 * Created by sefu on 7/23/2017.
 */

public class CardHomeMeetingAdapter extends RecyclerView.Adapter<CardHomeMeetingAdapter.MyViewHolder> {

    private ArrayList<DataMeetingModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewMeetingType;
        TextView textViewTime;
        TextView textViewPlace;
        ImageView imageViewUserAvatar;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewMeetingType = (TextView) itemView.findViewById(R.id.tvMeetingType);
            this.textViewTime = (TextView) itemView.findViewById(R.id.tvTime);
            this.textViewPlace = (TextView) itemView.findViewById(R.id.tvPlace);
            this.imageViewUserAvatar = (ImageView) itemView.findViewById(R.id.ImageViewAvatar);
        }
    }

    public CardHomeMeetingAdapter(ArrayList<DataMeetingModel> data) {
        this.dataSet = data;
    }

    @Override
    public CardHomeMeetingAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                  int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_home_meeting, parent, false);

        CardHomeMeetingAdapter.MyViewHolder myViewHolder = new CardHomeMeetingAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final CardHomeMeetingAdapter.MyViewHolder holder, final int listPosition) {

        TextView textViewMeetingType = holder.textViewMeetingType;
        TextView textViewTime = holder.textViewTime;
        TextView textViewPlace = holder.textViewPlace;
        ImageView imageViewUserAvatar = holder.imageViewUserAvatar;

        textViewMeetingType.setText(dataSet.get(listPosition).getMeetingType());
        textViewTime.setText(dataSet.get(listPosition).getTime());
        textViewPlace.setText(dataSet.get(listPosition).getPlace());
        imageViewUserAvatar.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
