package com.example.sefu.awesomeloginui.model;

/**
 * Created by sefu on 7/25/2017.
 */

public class DataGroupActiveModel {
    String groupName;
    int groupImage;
    int id_;

    public DataGroupActiveModel(String groupName, int groupImage, int id_) {

        this.groupImage = groupImage;
        this.groupName = groupName;
        this.id_ = id_;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getImage() {
        return groupImage;
    }

    public int getId_() {
        return id_;
    }
}
