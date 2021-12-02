package com.example.tabletopsupp.model;

public class PlayersMaster {
    private String playerName;
    private String playerRace;
    private String playerClass;
    private String playerLevel;
    private String uid;


    public PlayersMaster() {
    }

    public PlayersMaster(String playerName, String playerRace, String playerClass, String playerLevel, String uid) {
        this.playerName = playerName;
        this.playerRace = playerRace;
        this.playerClass = playerClass;
        this.playerLevel = playerLevel;
        this.uid = uid;
    }

    public PlayersMaster(String playerName, String playerRace, String playerClass, String playerLevel) {
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

    public String getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(String playerLevel) {
        this.playerLevel = playerLevel;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
