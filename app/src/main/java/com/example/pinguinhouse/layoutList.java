package com.example.pinguinhouse;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class layoutList extends AppCompatActivity {

    MySecondDatabase msdb = new MySecondDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list);

        /*Button b = (Button)findViewById((R.id.btnBM));

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("SG", "in Onclick");
                TextView txt = (TextView)findViewById(R.id.tv);
                String info = String.valueOf(txt.getText());
                Log.i("SG", "info: " + info);
            }
        });*/
    }
}
