package com.example.custombutton;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.Chronometer;

import java.sql.Time;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chronometer chronometer = findViewById(R.id.Crono);

        chronometer.setText("00:00:00");
        chronometer.setBase(SystemClock.elapsedRealtime() - StartFrom(1,45,40));

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

            @Override
            public void onChronometerTick(Chronometer chronometer) {
                CharSequence text = chronometer.getText();
                if (text.length() == 5) {
                    String a[] = text.toString().split(":");
                    String min = a[0];
                    String sec = a[1];
                    chronometer.setText("00:" + min + ":" + sec);
                } else if (text.length() == 7) {
                    String a[] = text.toString().split(":");
                    String hr = a[0];
                    String min = a[1];
                    String sec = a[2];
                    chronometer.setText(hr + ":" + min + ":" + sec);
                }
            }
        });

        //chronometer.getBase();
        chronometer.start();
    }

    public long StartFrom(int ore,int min, int sec){

        long total=0;

        total =  ((ore * 3600) + (60 * min) + sec) * 1000;

        return total;
    }

}
