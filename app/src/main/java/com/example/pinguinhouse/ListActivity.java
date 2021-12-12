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

        Bundle extras = getIntent().getExtras();
        String lastName = extras.getString("authorLastName");
        String firstName = extras.getString("authorFirstName");
        Log.i("JFL", "info: " + firstName + lastName);

        MyAdapter adapter = new MyAdapter();
        ListView l = (ListView)findViewById(R.id.listResults);

        String url_mod = new String("https://reststop.randomhouse.com/resources/authors?firstName=" + firstName + "&lastName=" + lastName);
        Log.i("JFL", "url_mod: " + url_mod);

        String url = "https://reststop.randomhouse.com/resources/authors/3446/";

        AsyncPinguinRandomJSONDataForList task = new AsyncPinguinRandomJSONDataForList(adapter);
        task.execute(url_mod);

        l.setAdapter(adapter);
    }
}