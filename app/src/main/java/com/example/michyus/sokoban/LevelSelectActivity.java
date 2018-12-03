package com.example.michyus.sokoban;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LevelSelectActivity extends AppCompatActivity {

    private int[][] level;

    private ListView listViewLevels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_level_select);

        final ArrayList<String> arrayList=new ArrayList<>();

        listViewLevels = findViewById(R.id.listViewLevels);

        arrayList.add("First");
        arrayList.add("Second");
        arrayList.add("Third");
        arrayList.add("Another");
        arrayList.add("Level");
        arrayList.add("Something");
        arrayList.add("-");
        arrayList.add("-");
        arrayList.add("-");
        arrayList.add("-");
        arrayList.add("-");
        arrayList.add("-");
        arrayList.add("-");
        arrayList.add("Last");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

        listViewLevels.setAdapter(arrayAdapter);

        listViewLevels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(LevelSelectActivity.this, MainActivity.class);
                intent.putExtra("id", i);
                intent.putExtra("name", arrayList.get(i).toString());
                startActivity(intent);
            }
        });
    }
}
