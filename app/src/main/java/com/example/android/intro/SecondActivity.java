package com.example.android.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        loadDataFromPreviousActivity();
    }


    protected void loadDataFromPreviousActivity() {
        TextView textViewEdit = (TextView) findViewById(R.id.textResult);
        TextView textViewCheckBox = (TextView) findViewById(R.id.checkboxResult);
        TextView textViewRating = (TextView) findViewById(R.id.ratingBarResult);
        TextView textViewSwitch = (TextView) findViewById(R.id.switchResult);
        TextView textViewRadio = (TextView) findViewById(R.id.radioButtonResult);
        intent = getIntent();

        //EditText
        textViewEdit.setText("Your name is: " + intent.getStringExtra("editTextResult"));
        //CheckBox
        if (intent.getBooleanExtra("checkBoxResult", false)) {
            textViewCheckBox.setText("You are human");
        } else {
            textViewCheckBox.setText("You are not human");
        }
        //RatingStars
        textViewRating.setText("Your rated android as : " + Float.toString(intent.getFloatExtra("ratingBarResult", 0f)) + " stars");
        //Switch
        if (intent.getBooleanExtra("switchResult", false)) {
            textViewSwitch.setText("You are man");
        } else {
            textViewSwitch.setText("You are woman");
        }
        //Radio
        if (intent.getBooleanExtra("radioButtonResult", false)) {
            textViewRadio.setText("You've checked radio button");
        } else {
            textViewRadio.setText("You've not checked the radio button");
        }

    }

    public void previousButton(View view) {
        startActivity(new Intent(this, FirstActivity.class));
    }

    public void nextButton(View view) {
        startActivity(new Intent(this, ThirdActivity.class));
    }

}
