package com.example.michyus.sokoban;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Graphics extends View {
    private GameEngine gameEngine;
    private Paint mPaint;

    private Bitmap bitmapFloor;
    private Bitmap bitmapWall;
    private Bitmap bitmapCrate;
    private Bitmap bitmapCrateGoal;
    private Bitmap bitmapGoal;
    private Bitmap bitmapPlayer;

    private float sizeOfElement;


    public Graphics(Context context, GameEngine gameEngine) {
        super(context);

        this.gameEngine = gameEngine;
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        if (gameEngine.getGridSize() == 0){
            gameEngine.setGridSize(canvas.getWidth());

            sizeOfElement = gameEngine.getGridSize() / gameEngine.getGridNumber();

            loadAndCreateBitmaps();
        }

        drawGrid(canvas);
        drawBitmaps(canvas);

        invalidate();
    }

    private void loadAndCreateBitmaps(){
        //TODO nacist a zmensit/zvetsit bitmapy
        // Load bitmaps
        bitmapFloor = BitmapFactory.decodeResource(this.getResources(), R.drawable.floor);
        bitmapWall = BitmapFactory.decodeResource(this.getResources(), R.drawable.wall);
        bitmapCrate = BitmapFactory.decodeResource(this.getResources(), R.drawable.crate);
        bitmapCrateGoal = BitmapFactory.decodeResource(this.getResources(), R.drawable.crate_goal);
        bitmapGoal = BitmapFactory.decodeResource(this.getResources(), R.drawable.goal);
        bitmapPlayer = BitmapFactory.decodeResource(this.getResources(), R.drawable.player);

        // Resize bitmaps
        bitmapFloor = Bitmap.createScaledBitmap(bitmapFloor, (int)sizeOfElement, (int)sizeOfElement, true);
        bitmapWall = Bitmap.createScaledBitmap(bitmapWall, (int)sizeOfElement, (int)sizeOfElement, true);
        bitmapCrate = Bitmap.createScaledBitmap(bitmapCrate, (int)sizeOfElement, (int)sizeOfElement, true);
        bitmapCrateGoal = Bitmap.createScaledBitmap(bitmapCrateGoal, (int)sizeOfElement, (int)sizeOfElement, true);
        bitmapGoal = Bitmap.createScaledBitmap(bitmapGoal, (int)sizeOfElement, (int)sizeOfElement, true);
        bitmapPlayer = Bitmap.createScaledBitmap(bitmapPlayer, (int)sizeOfElement, (int)sizeOfElement, true);
    }

    private void drawBitmaps(Canvas canvas){
        //TODO projit level/pole a vykreslit bitmapy
        for (int x = 0; x < gameEngine.getGridNumber(); x++){
            for (int y = 0; y < gameEngine.getGridNumber(); y++){
                Bitmap tempBitmap = null;
                if (gameEngine.tileAt(y, x) == 0){
                    tempBitmap = bitmapFloor;
                }
                else if (gameEngine.tileAt(y, x) == 1){
                    tempBitmap = bitmapWall;
                }
                else if (gameEngine.tileAt(y, x) == 2){
                    tempBitmap = bitmapCrate;
                }
                else if (gameEngine.tileAt(y, x) == 3){
                    tempBitmap = bitmapCrateGoal;
                }
                else if (gameEngine.tileAt(y, x) == 4){
                    tempBitmap = bitmapGoal;
                }
                else if (gameEngine.tileAt(y, x) == 5){
                    tempBitmap = bitmapPlayer;
                }

                if(tempBitmap != null)
                    canvas.drawBitmap(tempBitmap,sizeOfElement * x,sizeOfElement * y, mPaint);
            }
        }
    }

    private void drawGrid(Canvas canvas) {
        for (int i = 0; i <= gameEngine.getGridNumber(); i++){
            // Horizontal line
            canvas.drawLine(0,sizeOfElement * i, gameEngine.getGridSize(),sizeOfElement * i, mPaint);

            // Vertical line
            canvas.drawLine(sizeOfElement * i,0,sizeOfElement * i, gameEngine.getGridSize(), mPaint);
        }
    }
}
