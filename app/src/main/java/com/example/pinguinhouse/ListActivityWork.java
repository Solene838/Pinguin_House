package com.example.pinguinhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class ListActivityWork extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_work);
        Log.i("work", "in OnCreate ListActivityWork");

        Bundle extras = getIntent().getExtras();
        String work = extras.getString("workKey");
        Log.i("work", "extra: " +work);

        MyAdapter adapter = new MyAdapter();
        ListView l = (ListView)findViewById(R.id.listResults);

        String url = "https://reststop.randomhouse.com/resources/works/?start=0&max=10&expandLevel=1&search=Grisham";

        String url_mod = new String("https://reststop.randomhouse.com/resources/works/72140/?start=0&max=0&expandLevel=1&search=" + work);
        Log.i("work", "url_mod: " + url_mod);

        AsyncPRJSONDataForListWork task = new AsyncPRJSONDataForListWork(adapter);
        task.execute(url);

        l.setAdapter(adapter);

    }
}