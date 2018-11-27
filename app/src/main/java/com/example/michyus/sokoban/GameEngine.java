package com.example.michyus.sokoban;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameEngine {
    private final static int GRID_NUMBER = 10;

    private Activity gameActivity;

    private float gridSize = 0;

    private int[][] level = new int[10][10];

    private int[][] levelBackup = new int[10][10];

    List<int[][]> levels = new ArrayList<>();

    int posX = 5;
    int posY = 7;

    public GameEngine(Activity gameActivity, int levelIndex){
        this.gameActivity = gameActivity;
        parseLevel(levelIndex);
    }

    public void parseLevel(int index){
        readFileToArray();

        this.levelBackup = this.levels.get(index);
        System.arraycopy( this.levelBackup, 0, this.level, 0, this.levelBackup.length );

        for (int row = 0; row < 10; row++){
            for (int col = 0; col < 10; col++){
                if (level[row][col] == 5){
                    this.posX = col;
                    this.posY = row;
                }
            }
        }
    }

    private void readFileToArray(){
        Scanner scanner = new Scanner(this.gameActivity.getResources().openRawResource(R.raw.lvl));

        while (scanner.hasNextLine()){
            int totalRow = 10;
            int totalColumn = 10;
            int[][] myArray = new int[totalRow][totalColumn];

            for (int row = 0; scanner.hasNextLine() && row < totalRow; row++) {
                char[] chars = scanner.nextLine().toCharArray();
                for (int i = 0; i < totalColumn && i < chars.length; i++) {
                    myArray[row][i] = Character.getNumericValue(chars[i]);
                }
            }
            this.levels.add(myArray);
        }
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
