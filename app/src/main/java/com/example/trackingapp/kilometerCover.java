package com.example.trackingapp;



import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class kilometerCover extends AppCompatActivity {
    ActionBar actionBar;
    Button calculate;
    Intent gotoresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kilometer_covered);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.title);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setLogo(R.mipmap.cantje_logo);
            actionBar.setDisplayUseLogoEnabled(true);
//            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.sky_blue)));
            calculate();
        }
    }
    private void calculate(){
        calculate= findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoresult= new Intent(kilometerCover.this, result.class);
                startActivity(gotoresult);

            }
        });
    }
}