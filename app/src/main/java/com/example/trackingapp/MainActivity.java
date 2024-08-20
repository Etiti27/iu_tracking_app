package com.example.trackingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;
    Fragment fragment;
    Button loginBtn, RegisterBtn, gotoSexSelectionBtn;
    Intent gotoSexSelectionIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.title);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setLogo(R.mipmap.cantje_logo);
            actionBar.setDisplayUseLogoEnabled(true);
//            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.sky_blue)));
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.history){
            Toast.makeText(this, "History is clicked", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.search){
            Toast.makeText(this,  "search is clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    public void switchFragments(View view){
        loginBtn= findViewById(R.id.loginBtn);
        RegisterBtn=findViewById(R.id.RegisterBtn);
        fragment= new Fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        if (view==loginBtn){
            ft.replace(R.id.fragment_view, new loginFragment())
                    .commit();
        } else if (view==RegisterBtn) {
            ft.replace(R.id.fragment_view, new registerFragment())
                    .commit();
        }
    }

}