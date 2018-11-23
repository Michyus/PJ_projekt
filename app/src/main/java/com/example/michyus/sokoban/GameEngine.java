package com.example.michyus.sokoban;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class GameEngine {
    private final static int GRID_NUMBER = 10;

    private Activity gameActivity;

    private float gridSize = 0;

    private int[][] level = new int[10][10];

    private int[][] levelBackup = new int[10][10];

    int posX = 7;
    int posY = 5;


    public GameEngine(Activity gameActivity){
        this.gameActivity = gameActivity;
        parseLevel();
    }

    public void parseLevel(){
        char[][] arrChar = readFileToArray();

        for (int row = 0; row < 10; row++){
            for (int col = 0; col < 10; col++){
                this.levelBackup[row][col] = Character.getNumericValue(arrChar[row][col]);
                this.level[row][col] = Character.getNumericValue(arrChar[row][col]);
            }
        }
    }

    public char[][] readFileToArray(){
        int totalRow = 10;
        int totalColumn = 10;
        char[][] myArray = new char[totalRow][totalColumn];
        Scanner scanner = new Scanner(this.gameActivity.getResources().openRawResource(R.raw.lvl));


        for (int row = 0; scanner.hasNextLine() && row < totalRow; row++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int i = 0; i < totalColumn && i < chars.length; i++) {
                myArray[row][i] = chars[i];
            }
        }

        return myArray;
    }

    public String readFileToString() throws IOException
    {
        InputStream is = this.gameActivity.getResources().openRawResource(R.raw.level);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));

        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();

        while(line != null){
            sb.append(line).append("\n");
            line = buf.readLine();
        }

        return sb.toString();
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
