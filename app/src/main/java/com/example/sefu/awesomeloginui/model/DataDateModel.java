package com.example.sefu.awesomeloginui.model;


public class DataDateModel {


    String day;
    String date;
    int id_;
//    int image;

    public DataDateModel(String day, String date, int id_) {
        this.day = day;
        this.date = date;
        this.id_ = id_;
//        this.image=image;
    }


    public String getName() {
        return day;
    }


    public String getVersion() {
        return date;
    }

//    public int getImage() {
//        return image;
//    }

    public int getId() {
        return id_;
    }
}