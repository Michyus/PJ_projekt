package com.example.michyus.sokoban;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private GameEngine gameEngine;
    private FrameLayout gameFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameEngine = new GameEngine(this);

        gameFrame = findViewById(R.id.gameFrame);

        gameFrame.addView(new Graphics(this, gameEngine));
        gameFrame.setOnTouchListener(new TouchListener(gameEngine));
    }
}
