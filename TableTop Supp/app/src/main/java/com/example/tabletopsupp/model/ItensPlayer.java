package com.example.tabletopsupp.model;

public class ItensPlayer {
    private  String itemName;
    private  String itemCont;
    private  String itemWeigth;

    public ItensPlayer(){
    }

    public ItensPlayer(String itemName, String itemCont, String itemWeigth) {
        this.itemName = itemName;
        this.itemCont = itemCont;
        this.itemWeigth = itemWeigth;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCont() {
        return itemCont;
    }

    public void setItemCont(String itemDescription) {
        this.itemCont = itemDescription;
    }

    public String getItemWeigth() {
        return itemWeigth;
    }

    public void setItemWeigth(String itemWeigth) {
        this.itemWeigth = itemWeigth;
    }

}
