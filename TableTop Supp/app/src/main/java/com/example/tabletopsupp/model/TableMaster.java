package com.example.tabletopsupp.model;

public class TableMaster {

    private  String masterName;
    private  String adventureName;
    private  String playNumber;

    public TableMaster(String masterName, String adventureName, String playNumber) {
        this.masterName = masterName;
        this.adventureName = adventureName;
        this.playNumber = playNumber;
    }

    public String getmasterName() {
        return masterName;
    }

    public void setmasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getAdventureName() {
        return adventureName;
    }

    public void setAdventureName(String adventureName) {
        this.adventureName = adventureName;
    }

    public String getPlayNumber() {
        return playNumber;
    }

    public void setPlayNumber(String playNumber) {
        this.playNumber = playNumber;
    }
}