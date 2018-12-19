package com.example.serdargurbuz.blindscape;

public class Level {
    private int levelNumber;
    private int mapSize;
    private Map theMap;

    public Level (int mapSize, int levelNumber){
        theMap = new Map(mapSize);
        this.mapSize = mapSize;
        this.levelNumber = levelNumber;
    }

    public boolean setGameObject(int x, int y, int index, String name, boolean portable, String audioPath){
        Obj o = new Obj(name, portable);
        o.setAudioPath(audioPath);
        Cell c = (theMap.getCells())[x][y];
        return c.addObject(o, index);
    }

    public Map getMap() {
        return theMap;
    }

    public int getMapSize(){
        return mapSize;
    }

}
