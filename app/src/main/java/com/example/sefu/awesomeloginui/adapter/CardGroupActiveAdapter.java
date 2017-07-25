package com.example.sefu.awesomeloginui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sefu.awesomeloginui.R;
import com.example.sefu.awesomeloginui.model.DataGroupActiveModel;

import java.util.ArrayList;

/**
 * Created by sefu on 7/25/2017.
 */

public class CardGroupActiveAdapter extends RecyclerView.Adapter<CardGroupActiveAdapter.MyViewHolder> {

    private ArrayList<DataGroupActiveModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewGroupName;
        ImageView imageViewGroupImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.textViewGroupName = (TextView) itemView.findViewById(R.id.textViewGroupName);
            this.imageViewGroupImage = (ImageView) itemView.findViewById(R.id.textViewGroupImage);
        }
    }

    public CardGroupActiveAdapter(ArrayList<DataGroupActiveModel> data) {
        this.dataSet = data;
    }

    @Override
    public CardGroupActiveAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                  int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_single_content, parent, false);

        CardGroupActiveAdapter.MyViewHolder myViewHolder = new CardGroupActiveAdapter.MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(final CardGroupActiveAdapter.MyViewHolder holder, final int listPosition) {

        TextView textViewGroupName = holder.textViewGroupName;
        ImageView imageViewGroupImage = holder.imageViewGroupImage;

        textViewGroupName.setText(dataSet.get(listPosition).getGroupName());
        imageViewGroupImage.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}