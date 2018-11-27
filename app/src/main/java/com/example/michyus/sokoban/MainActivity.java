package com.example.michyus.sokoban;

import android.content.Intent;
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

    private int id = 0;
    private String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        name = intent.getStringExtra("name");

        gameEngine = new GameEngine(this, id);

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
