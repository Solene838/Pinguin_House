package com.example.pinguinhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class ListActivityTitle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_title);
        Log.i("title", "in OnCreate ListActivity");

        Bundle extras = getIntent().getExtras();
        String title = extras.getString("titleKey");

        MyAdapter adapter = new MyAdapter();
        ListView l = (ListView)findViewById(R.id.listResults);

        String url = "https://reststop.randomhouse.com/resources/titles?start=0&max=4&expandLevel=0&onsaleStart=MM/dd/yyyy&onsaleEnd=MM/dd/yyyy&authorid=0&workid=0&keyword=Grisham%20Christmas";

        String url_mod = new String("https://reststop.randomhouse.com/resources/titles?start=0&max=4&expandLevel=0&onsaleStart=MM/dd/yyyy&onsaleEnd=MM/dd/yyyy&authorid=0&workid=0&keyword=" + title);
        Log.i("title", "url_mod: " +url_mod);
    }
}