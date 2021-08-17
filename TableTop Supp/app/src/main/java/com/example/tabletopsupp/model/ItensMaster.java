package com.example.tabletopsupp.model;

import android.media.Image;

public class ItensMaster {

    private  String itenName;
    private  String itenDescription;
    private int itenPhoto;
    private  int itenWeigth;

    public ItensMaster(){

    }
    public ItensMaster(String itenName, String itenDescription, int itenPhoto, int itenWeigth) {
        this.itenName = itenName;
        this.itenDescription = itenDescription;
        this.itenPhoto = itenPhoto;
        this.itenWeigth = itenWeigth;
    }

    public String getItenName() {
        return itenName;
    }

    public void setItenName(String itenName) {
        this.itenName = itenName;
    }

    public String getItenDescription() {
        return itenDescription;
    }

    public void setItenDescription(String itenDescription) {
        this.itenDescription = itenDescription;
    }

    public int getItenPhoto() {
        return itenPhoto;
    }

    public void setItenPhoto(int itenPhoto) {
        this.itenPhoto = itenPhoto;
    }

    public int getItenWeigth() {
        return itenWeigth;
    }

    public void setItenWeigth(int itenWeigth) {
        this.itenWeigth = itenWeigth;
    }
}