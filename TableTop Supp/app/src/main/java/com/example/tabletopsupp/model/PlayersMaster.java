package com.example.tabletopsupp.model;

public class PlayersMaster {
    private  String playerName;
    private  String playerRace;
    private String playerClass;
    private  int playerLevel;

    public PlayersMaster(){

    }
    public PlayersMaster(String playerName, String playerRace, String playerClass, int playerLevel) {
        this.playerName = playerName;
        this.playerRace = playerRace;
        this.playerClass = playerClass;
        this.playerLevel = playerLevel;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerRace() {
        return playerRace;
    }

    public void setPlayerRace(String playerRace) {
        this.playerRace = playerRace;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }
}
