package com.example.pinguinhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.i("JFL", "in OnCreate ListActivity");

        MyAdapter adapter = new MyAdapter();
        ListView l = (ListView)findViewById(R.id.listResults);

        String url = "https://reststop.randomhouse.com/resources/authors/3446/";

        AsyncPinguinRandomJSONDataForList task = new AsyncPinguinRandomJSONDataForList(adapter);
        task.execute(url);

        l.setAdapter(adapter);
    }
}