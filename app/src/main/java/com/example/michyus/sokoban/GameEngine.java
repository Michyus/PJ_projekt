package com.example.michyus.sokoban;

import android.app.Activity;

public class GameEngine {
    private final static int GRID_NUMBER = 10;

    private Activity gameActivity;

    private float gridSize = 0;




    public GameEngine(Activity gameActivity){
        this.gameActivity = gameActivity;

    }

    public int getGridNumber(){
        return GRID_NUMBER;
    }

    public float getGridSize() {
        return gridSize;
    }

    public void setGridSize(float gridSize) {
        this.gridSize = gridSize;
    }
}
