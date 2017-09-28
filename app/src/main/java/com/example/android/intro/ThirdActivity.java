package com.example.android.intro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.sql.Timestamp;

public class ThirdActivity extends AppCompatActivity {
    TextView textView;
    String currentState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        textView = (TextView) findViewById(R.id.firstTimeStampTextView);
        newState("Activity Created");
    }

    void newState(String arg) {
        currentState = arg;
        update();
    }

    private void update() {
        textView.append(currentTimeToString() + "\t" + currentState+"\n");
    }


    protected String currentTimeToString() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }

    @Override
    protected void onPause() {
        super.onPause();
        newState("Activity Paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        newState("Activity Resumed");
    }

    @Override
    protected void onStart() {
        super.onStart();
        newState("Activity Started");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        newState("Activity Restarted");
    }

    @Override
    protected void onStop() {
        super.onStop();
        newState("Activity Stopped");
    }
}
