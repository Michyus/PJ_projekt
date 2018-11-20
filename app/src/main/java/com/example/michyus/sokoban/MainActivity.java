package com.example.michyus.sokoban;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GameEngine gameEngine;
    private FrameLayout gameFrame;

    private Button btnUp;
    private Button btnDown;
    private Button btnRight;
    private Button btnLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameEngine = new GameEngine(this);

        gameFrame = findViewById(R.id.gameFrame);

        btnUp = findViewById(R.id.btnUp);
        btnDown = findViewById(R.id.btnDown);
        btnRight = findViewById(R.id.btnRight);
        btnLeft = findViewById(R.id.btnLeft);

        btnUp.setOnClickListener(listenerUp);
        btnDown.setOnClickListener(listenerDown);
        btnRight.setOnClickListener(listenerRight);
        btnLeft.setOnClickListener(listenerLeft);

        gameFrame.addView(new Graphics(this, gameEngine));
        gameFrame.setOnTouchListener(new TouchListener(gameEngine));
    }

    View.OnClickListener listenerUp = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            gameEngine.canMove(0,-1);
        }
    };
    View.OnClickListener listenerDown = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            gameEngine.canMove(0,1);
        }
    };
    View.OnClickListener listenerRight = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            gameEngine.canMove(1,0);
        }
    };
    View.OnClickListener listenerLeft = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            gameEngine.canMove(-1,0);
        }
    };
}
