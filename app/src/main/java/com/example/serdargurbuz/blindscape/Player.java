package com.example.serdargurbuz.blindscape;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import static java.security.AccessController.getContext;

public class Player {
    private Obj inventory;
    private int locationX;
    private int locationY;
    private String direction;
    private Level lvl;

    public Player (Level lvl){
        locationX = 1;
        locationY = 1;
        direction = "down";
        inventory = null;
        this.lvl = lvl;
    }

    public boolean move(String direction){
        boolean done = false;
        Cell one = null;
        Cell two = null;
        if (direction.equals("up")){
            if (locationX - 1 != 0){
                setLocationX(locationX-1);
                done = true;
                one = lvl.getMap().getCells()[locationX][locationY+1];
                two = lvl.getMap().getCells()[locationX][locationY-1];
            }
        }
        else if (direction.equals("down")){
            if (locationX + 1 != lvl.getMapSize() - 1){
                setLocationX(locationX+1);
                done = true;
                one = lvl.getMap().getCells()[locationX][locationY+1];
                two = lvl.getMap().getCells()[locationX][locationY-1];
            }
        }
        else if (direction.equals("left")){
            if (locationY - 1 != 0){
                setLocationY(locationY-1);
                done = true;
                one = lvl.getMap().getCells()[locationX+1][locationY];
                two = lvl.getMap().getCells()[locationX-1][locationY];
            }

        }
        else if (direction.equals("right")){
            if (locationY + 1 != lvl.getMapSize() - 1){
                setLocationY(locationY+1);
                done = true;
                one = lvl.getMap().getCells()[locationX+1][locationY];
                two = lvl.getMap().getCells()[locationX-1][locationY];
            }
        }
        setDirection(direction);

        if (one != null && two != null){
            if (one.count > 0 || two.count > 0){
                vibration();
            }
        }
        return done;
    }

    public void look(){

        Cell c = null;
        if (getDirection().equals("up")){
            if (locationX-1 == 0){
                c = lvl.getMap().getCells()[locationX-1][locationY];
                if (c.count == 0){
                    // Ouch
                    MainActivity.currentText = "Ouch";
                }
                else {
                    // Read the first object
                    MainActivity.currentText = c.getObjects()[0].getName();
                }
            }
            else {
                MainActivity.currentText = "";
            }
        }
        else if (getDirection().equals("down")){
            if (locationX+1 == lvl.getMapSize()-1){
                c = lvl.getMap().getCells()[locationX+1][locationY];
                if (c.count == 0){
                    // Ouch
                    MainActivity.currentText = "Ouch";
                }
                else {
                    // Read the first object
                    MainActivity.currentText = c.getObjects()[0].getName();
                }
            }
            else {
                MainActivity.currentText = "";
            }
        }
        else if (getDirection().equals("left")){
            if (locationY-1 == 0){
                c = lvl.getMap().getCells()[locationX][locationY-1];
                if (c.count == 0){
                    // Ouch
                    MainActivity.currentText = "Ouch" ;
                }
                else {
                    // Read the first object
                    MainActivity.currentText = c.getObjects()[0].getName();
                }
            }
            else {
                MainActivity.currentText = "";
            }
        }
        else if (getDirection().equals("right")){
            if (locationY+1 == lvl.getMapSize()-1){
                c = lvl.getMap().getCells()[locationX][locationY+1];
                if (c.count == 0){
                    // Ouch
                    MainActivity.currentText = "Ouch";
                }
                else {
                    // Read the first object
                    MainActivity.currentText = c.getObjects()[0].getName();
                }
            }
            else {
                MainActivity.currentText = "";
            }
        }
    }

    public void vibration(){
// Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            MainActivity.v.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            MainActivity.v.vibrate(50);
        }
    }

    public Obj getInventory() {
        return inventory;
    }

    public void setInventory(Obj inventory) {
        this.inventory = inventory;
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
