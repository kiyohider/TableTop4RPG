package com.example.tabletopsupp.model;

public class ItensMaster {

    private  String itemName;
    private  String itemDescription;
    private String itemPhoto;
    private  int itemWeigth;

    public ItensMaster(){
    }

    public ItensMaster(String itemName, String itemDescription, String itemPhoto, int itemWeigth) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPhoto = itemPhoto;
        this.itemWeigth = itemWeigth;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemPhoto() {
        return itemPhoto;
    }

    public void setItemPhoto(String itemPhoto) {
        this.itemPhoto = itemPhoto;
    }

    public int getItemWeigth() {
        return itemWeigth;
    }

    public void setItemWeigth(int itemWeigth) {
        this.itemWeigth = itemWeigth;
    }
}