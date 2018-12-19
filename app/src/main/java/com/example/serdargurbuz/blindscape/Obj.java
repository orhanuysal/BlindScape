package com.example.serdargurbuz.blindscape;

public class Obj {

    private String name;
    private String audioPath;
    private boolean taken;
    private boolean portable;

    public Obj (){
        name = "";
        audioPath = "";
        taken = false;
        portable = false;
    }

    public Obj (String name, boolean portable){
        this.name = name;
        this.audioPath = "";
        this.taken = false;
        this.portable = portable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}
