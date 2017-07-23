package com.example.sefu.awesomeloginui.model;

/**
 * Created by sefu on 7/23/2017.
 */

public class DataMeetingModel {

    String meetingType;
    String time;
    String place;
    int id_;
    int image;

    public DataMeetingModel(String meetingType, String time, String place, int id_, int image) {

        this.meetingType = meetingType;
        this.time = time;
        this.place = place;
        this.id_ = id_;
        this.image = image;
    }

    public String getMeetingType() {
        return meetingType;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public int getId_() {
        return id_;
    }

    public int getImage() {
        return image;
    }
}
