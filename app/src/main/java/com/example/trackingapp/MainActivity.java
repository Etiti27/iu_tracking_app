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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;
    FirebaseAuth auth;
    Fragment fragment;
    Button loginBtn, RegisterBtn, gotoSexSelectionBtn;
    Intent gotoCalculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        firebaseAuth instance
        auth= FirebaseAuth.getInstance();

//        AppBar menu
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.title);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setLogo(R.mipmap.cantje_logo);
            actionBar.setDisplayUseLogoEnabled(true);
//            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources()
                    .getColor(R.color.sky_blue)));
        }
    }
//    add menu to appbar

//    switching login and registration fragments
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

//    For good user experience,
//    detect if a users has logged in not longer again
//    if true, use the previous sessioon
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser= auth.getCurrentUser();
                if(currentUser !=null){
                    Toast.makeText(this, "user exist", Toast.LENGTH_SHORT).show();
                    gotoCalculation = new Intent(this, kilometerCover.class);
                    startActivity(gotoCalculation);
                    finish();
                }else{
                    Toast.makeText(this, "no user", Toast.LENGTH_SHORT).show();
                }

        ;
    }
}