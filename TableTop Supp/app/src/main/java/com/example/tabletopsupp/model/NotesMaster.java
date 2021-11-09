package com.example.tabletopsupp.model;

public class NotesMaster {
    private String noteName;
    private String noteText;

    public NotesMaster(){
    }

    public NotesMaster(String noteName) {
        this.noteName = noteName;
    }

    public NotesMaster(String noteName,String noteText) {
        this.noteName = noteName;
        this.noteText = noteText;
    }

    public String getnoteName() {
        return noteName;
    }

    public void setnoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getnoteText() {
        return noteText;
    }

    public void setnoteText(String noteText) {
        this.noteText = noteText;
    }


}

