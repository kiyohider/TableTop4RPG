package com.example.tabletopsupp.model;

public class TableMaster {

    private  String masterName;
    private  String adventureName;
    private  String playNumber;
    private  String systemName;
    private   String master;



    public TableMaster(String masterName, String adventureName, String playNumber, String systemName, String master) {
        this.masterName = masterName;
        this.adventureName = adventureName;
        this.playNumber = playNumber;
        this.systemName = systemName;
        this.master = master;

    }
    public TableMaster(String masterName, String adventureName, String playNumber, String systemName) {
        this.masterName = masterName;
        this.adventureName = adventureName;
        this.playNumber = playNumber;
        this.systemName = systemName;


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

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getmaster() {
        return master;
    }

    public void setmaster(String master) {
        this.master = master;
    }
}