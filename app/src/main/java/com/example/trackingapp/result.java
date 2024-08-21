package com.example.trackingapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class result extends AppCompatActivity {
    ActionBar actionBar;
    WebView webView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.title);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setLogo(R.mipmap.cantje_logo);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.sky_blue)));
        }
//        imagedisplay();
    }

private void imagedisplay(){
    imageView = findViewById(R.id.imageView);
    imageView.setImageResource(R.mipmap.maguire);



    // add the url of gif

}

}