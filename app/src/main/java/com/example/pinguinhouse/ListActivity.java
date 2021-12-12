package com.example.pinguinhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.time.Instant;

public class ListActivity extends AppCompatActivity {

    MySecondDatabase msdb = new MySecondDatabase(this);

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
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("SG", "in ItemOnClickListener");
                String info = new String(firstName + " " + lastName);

                msdb.insertData(info);
                Toast.makeText(ListActivity.this, "This reference is added to your bookmarks !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}