package com.example.pinguinhouse;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.time.Instant;

public class SearchActivity extends AppCompatActivity {

    MyDatabase mydb = new MyDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ImageButton bAuthor = (ImageButton) findViewById(R.id.btnAuthorSearch);
        Log.i("JFL", "in OnCreate SearchActivity");

        /*bAuthor.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.i("JFL", "in OnClick function");
                EditText var1 = (EditText) findViewById(R.id.inputAuthor);
                Log.i("JFL", String.valueOf(var1.getText()));
                String output1 = String.valueOf(var1.getText());
                Log.i("JFL", "output1 = "+output1);
                Instant instant = Instant.now();
                String output2 = instant.toString();
                mydb.insertData(output1,output2);

            }
        });*/

        bAuthor.setOnClickListener(new GetTextOnClickListener(this));

        Button b = (Button)findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}