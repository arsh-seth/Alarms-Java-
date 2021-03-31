package com.example.a22alarmsinjava;

 

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import com.example.a22alarmsinjava.MainActivity2;
import com.example.a22alarmsinjava.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnTask = findViewById(R.id.btnTask);

        btnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), MainActivity2.class);
               // schedule a task which will run 5 min from now and start my app
                 // we use intents generally to start an activity
                // but here in alarms we use pending intents
                PendingIntent  pi = PendingIntent.getActivity(getBaseContext(),1234,i,PendingIntent.FLAG_ONE_SHOT);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.ELAPSED_REALTIME ,
                        SystemClock.elapsedRealtime() + 60000 , pi); // activity automatically launches after 1 min

                alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME,
                        SystemClock.elapsedRealtime() + 60000 ,
                        60000 ,pi);
                

                //x , (x+5)min ,(x+5)5
                //current time + time delay for scheduling the alarm
                //System.currentTimeMillis()
                //Intent i2 = new Intent(getBaseContext(),MainActivity.class);
                // PendingIntent  pi2 = PendingIntent.getActivity(getBaseContext(),1234,i,);

            }
        });

    }
}