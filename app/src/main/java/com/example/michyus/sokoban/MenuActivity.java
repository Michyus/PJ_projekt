package com.example.michyus.sokoban;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(listenerPlay);
    }

    View.OnClickListener listenerPlay = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MenuActivity.this, LevelSelectActivity.class);
            startActivity(intent);
        }
    };
}
