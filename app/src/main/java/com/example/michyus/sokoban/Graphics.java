package com.example.michyus.sokoban;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Graphics extends View {
    private GameEngine gameEngine;
    private Paint mPaint;
    private Bitmap bitmapWall;
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
    }

    private void drawBitmaps(Canvas canvas){
        //TODO projit level/pole a vykreslit bitmapy
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
