package com.example.pinguinhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ListView list = (ListView)findViewById(R.id.listHistory) ;
        ArrayAdapter<String> table = new ArrayAdapter<String>(list.getContext(), R.layout.support_simple_spinner_dropdown_item);


        MyDatabase mydb = new MyDatabase(this);

        mydb.readData();

        mydb.printData(table);
        mydb.close();
        list.setAdapter(table);
    }

}