package com.example.michyus.sokoban;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class LevelSelectActivity extends AppCompatActivity {

    private ListView listViewLevels;
    private Button btntestLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);


        btntestLevel = findViewById(R.id.btnTestLevel);
        btntestLevel.setOnClickListener(listenerTestLevel);

        listViewLevels = findViewById(R.id.listViewLevels);
        listViewLevels.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3)
            {
                String value = (String)adapter.getItemAtPosition(position);
                // assuming string and if you want to get the value on click of list item
                // do what you intend to do on click of listview row
                Intent intent = new Intent(LevelSelectActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    View.OnClickListener listenerTestLevel = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LevelSelectActivity.this, MainActivity.class);
            startActivity(intent);
        }
    };
}
