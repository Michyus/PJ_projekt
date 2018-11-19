package com.example.michyus.sokoban;

import android.app.Activity;

public class GameEngine {
    private final static int GRID_NUMBER = 10;

    private Activity gameActivity;

    private float gridSize = 0;

    private int[][] level = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 2, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 0, 0, 1},
            {1, 0, 2, 0, 1, 4, 4, 0, 0, 1},
            {1, 0, 2, 0, 1, 4, 4, 5, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 2, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    private int[][] levelBackup = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 2, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 0, 0, 1},
            {1, 0, 2, 0, 1, 4, 4, 0, 0, 1},
            {1, 0, 2, 0, 1, 4, 4, 5, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 2, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    int posX = 7;
    int posY = 5;


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

    public int tileAt(int x, int y){
        return level[x][y];
    }

    public boolean canMove(int dirX, int dirY) {
        int x = posX;
        int y = posY;

        if (level[y + dirY][x + dirX] == 0 || level[y + dirY][x + dirX] == 4) {
            if (levelBackup[y][x] == 0 || levelBackup[y][x] == 4) {
                level[y][x] = levelBackup[y][x];
            } else {
                level[y][x] = 0;
            }
            posX = posX + dirX;
            posY = posY + dirY;
            level[y + dirY][x + dirX] = 5;
            return true;
        } else if ((level[y + dirY][x + dirX] == 2 || level[y + dirY][x + dirX] == 3) && (level[y + dirY * 2][x + dirX * 2] == 0 || level[y + dirY * 2][x + dirX * 2] == 4)) {
            if (levelBackup[y][x] == 0 || levelBackup[y][x] == 4) {
                level[y][x] = levelBackup[y][x];
            } else {
                level[y][x] = 0;
            }
            posX = posX + dirX;
            posY = posY + dirY;
            level[y + dirY][x + dirX] = 5;
            if (levelBackup[y + dirY * 2][x + dirX * 2] == 4) {
                level[y + dirY * 2][x + dirX * 2] = 3;
            } else {
                level[y + dirY * 2][x + dirX * 2] = 2;
            }

            return true;
        }
        return false;
    }
}
