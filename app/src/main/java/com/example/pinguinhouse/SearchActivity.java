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

        bAuthor.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.i("JFL", "in OnClick function");
                EditText lastName = (EditText)findViewById(R.id.inputAuthor);
                String mid1 = String.valueOf(lastName.getText());
                Log.i("JFL", "mid1: "+ mid1);
                EditText firstName = (EditText)findViewById(R.id.inputAuthorbis);
                String mid2 = String.valueOf(firstName.getText());
                Log.i("JFL", "mid2: "+ mid2);

                String output1 = new String(mid1+ " " + mid2);
                Log.i("JFL", "output1 = "+output1);

                Instant instant = Instant.now();
                String output3 = instant.toString();

                mydb.insertData(output1,output3);
                Intent intent = new Intent(v.getContext(), ListActivity.class);
                intent.putExtra("authorLastName", mid1);
                intent.putExtra("authorFirstName", mid2);
                v.getContext().startActivity(intent);

            }
        } );


        ImageButton bWork = (ImageButton)findViewById(R.id.btnWorkSearch);
        bWork.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.i("work", "in OnClick function");
                EditText var1 = (EditText) findViewById(R.id.inputWork);
                String output1 = String.valueOf(var1.getText());
                Log.i("work", "output1 = " + output1);

                Instant instant = Instant.now();
                String output2 = instant.toString();

                mydb.insertData(output1, output2);

                Intent intent = new Intent(v.getContext(), ListActivityWork.class);
                intent.putExtra("workKey", output1);
                v.getContext().startActivity(intent);
            }
        });


        ImageButton bTitle = (ImageButton)findViewById(R.id.btnTitleSearch);
        bTitle.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.i("title", "in OnClick function");
                EditText var1 = (EditText) findViewById(R.id.inputTitle);
                String output1 = String.valueOf(var1.getText());
                Log.i("title", "output1 = " + output1);

                Instant instant = Instant.now();
                String output2 = instant.toString();

                mydb.insertData(output1, output2);

                Intent intent = new Intent(v.getContext(), ListActivityTitle.class);
                intent.putExtra("titleKey", output1);
                v.getContext().startActivity(intent);
            }
        });


        ImageButton bEvent = (ImageButton)findViewById(R.id.btnEventSearch);
        bEvent.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.i("JFL", "in OnClick function");
                EditText var1 = (EditText) findViewById(R.id.inputEvent);
                Log.i("JFL", String.valueOf(var1.getText()));
                String output1 = String.valueOf(var1.getText());
                Log.i("JFL", "output1 = " + output1);
                Instant instant = Instant.now();
                String output2 = instant.toString();
                mydb.insertData(output1, output2);
                Intent intent = new Intent(v.getContext(), ListActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}