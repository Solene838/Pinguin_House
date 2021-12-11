package com.example.pinguinhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        MyAdapter adapter = new MyAdapter();
        ListView l = (ListView)findViewById(R.id.listResults);
        l.setAdapter(adapter);
    }
}