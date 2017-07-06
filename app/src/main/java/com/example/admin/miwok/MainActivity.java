package com.example.admin.miwok;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView phrases;
    private TextView legal;
    private TextView months;
    private TextView colors;
    private TextView numbers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //OBJECT INSTANCES
        phrases = (TextView) findViewById(R.id.phrases);
        legal = (TextView) findViewById(R.id.legal);
        months = (TextView) findViewById(R.id.months);
        colors = (TextView) findViewById(R.id.colors);
        numbers = (TextView) findViewById(R.id.numbers);




        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity1.class);
                startActivity(intent);
            }
        });

        legal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                startActivity(intent);
            }
        });

        months.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity3.class);
                startActivity(intent);
            }
        });

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity4.class);
                startActivity(intent);
            }
        });

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity5.class);
                startActivity(intent);
            }
        });

    }
}
