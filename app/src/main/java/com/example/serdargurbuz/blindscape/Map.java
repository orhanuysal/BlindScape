package com.example.serdargurbuz.blindscape;

public class Map {
    private int mapSize;
    private Cell[][] cells;

    public Map (int mapSize) {
        this.mapSize = mapSize;
        cells = new Cell[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++){
            for (int j = 0; j < mapSize; j++){
                if (i == 0 || j == 0 || i == mapSize - 1 || j == mapSize - 1){
                    cells[i][j] = new Cell(i, j, true);
                }
                else {
                    cells[i][j] = new Cell(i, j, false);
                }
            }
        }
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

}

