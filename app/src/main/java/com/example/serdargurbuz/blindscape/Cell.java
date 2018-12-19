package com.example.serdargurbuz.blindscape;

public class Cell {

    private int locationX;
    private int locationY;
    public int count;
    private Obj[] objects;
    private boolean isEdge;

    final private int MAX_OBJECT_SIZE = 2;

    public Cell () {
        this.locationY = 0;
        this.locationX = 0;
        this.isEdge = false;
        objects = new Obj[MAX_OBJECT_SIZE];
        this.count = 0;
    }

    public Cell (int locationX, int locationY, boolean isEdge){
        this.locationX = locationX;
        this.locationY = locationY;
        this.isEdge = isEdge;
        objects = new Obj[MAX_OBJECT_SIZE];
        this.count = 0;
    }
    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public Obj[] getObjects() {
        return objects;
    }

    public boolean addObject(Obj object, int index) {
        boolean done = false;
        if (isEdge){
            if (count < 2){
                objects[index] = object;
                count++;
                done = true;
            }
        }
        return done;
    }

    public boolean deleteObject(int index){
        boolean done = false;
        if (index < count){
            objects[index] = null;
            count--;
            done = true;
        }
        return done;
    }

    public boolean isEdge() {
        return isEdge;
    }

    public void setEdge(boolean edge) {
        isEdge = edge;
    }

}
