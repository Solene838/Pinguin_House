package com.example.pinguinhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Vector;

public class BookmarkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        ListView list = (ListView)findViewById(R.id.listBookmarks);
        ArrayAdapter<String> table = new ArrayAdapter<String>(list.getContext(), R.layout.support_simple_spinner_dropdown_item);

        MySecondDatabase msdb = new MySecondDatabase(this);

        msdb.readData();
        msdb.printData(table);
        msdb.close();
        list.setAdapter(table);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("SG", "item: " + parent.getItemAtPosition(position));
            }
        });

    }
}