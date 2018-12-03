package com.example.michyus.sokoban;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button btnPlay;
    private Button btnGit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(listenerPlay);

        Button mIdButtonHome = (Button)findViewById(R.id.buttonGit);
        mIdButtonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/Michyus/PJ_projekt"));
                startActivity(browserIntent);
            }
        });
    }

    View.OnClickListener listenerPlay = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MenuActivity.this, LevelSelectActivity.class);
            startActivity(intent);
        }
    };
}
