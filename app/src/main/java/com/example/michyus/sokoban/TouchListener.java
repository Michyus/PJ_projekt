package com.example.michyus.sokoban;

import android.view.MotionEvent;
import android.view.View;

public class TouchListener implements View.OnTouchListener {

    private GameEngine gameEngine;

    private float x;
    private float y;

    public TouchListener(GameEngine gameEngine){
        this.gameEngine = gameEngine;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();

                break;
            default:
                break;
        }

        return true;
    }
}