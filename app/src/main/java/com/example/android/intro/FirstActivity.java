package com.example.android.intro;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    RatingBar ratingBar;
    EditText editText;
    CheckBox checkBox;
    RadioButton radioButton;
    Switch mySwitch;
    protected AlphaAnimation fadeIn = new AlphaAnimation(0f, 1f);
    protected AlphaAnimation fadeOut = new AlphaAnimation(1f, 0f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initializeViews();
        changeRatingColor();
        checkSwitch();
    }

    protected void initializeViews() {
        ratingBar = (RatingBar) findViewById(R.id.rating);
        editText = (EditText) findViewById(R.id.text);
        checkBox = (CheckBox) findViewById(R.id.myCheckbox);
        mySwitch = (Switch) findViewById(R.id.mySwitch);
        radioButton = (RadioButton) findViewById(R.id.myRadio);
    }

    public void checkSwitch() {
        final TextView man = (TextView) findViewById(R.id.manTextView);
        final TextView woman = (TextView) findViewById(R.id.womanTextView);
        fadeIn.setFillAfter(true);
        fadeIn.setDuration(600);
        fadeOut.setFillAfter(true);
        fadeOut.setDuration(600);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    man.startAnimation(fadeIn);
                    woman.startAnimation(fadeOut);

                }else{
                    woman.startAnimation(fadeIn);
                    man.startAnimation(fadeOut);
                }
            }
        });

    }

    protected void changeRatingColor() {
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
    }

    public void clickButton(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        //EditView
        intent.putExtra("editTextResult", editText.getText().toString());
        //CheckBox
        intent.putExtra("checkBoxResult", checkBox.isChecked());
        //RatingBar
        intent.putExtra("ratingBarResult", ratingBar.getRating());
        //Switch
        intent.putExtra("switchResult", mySwitch.isChecked());
        //RadioButton
        intent.putExtra("radioButtonResult", radioButton.isChecked());
        startActivity(intent);
    }
}
