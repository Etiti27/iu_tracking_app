package com.example.trackingapp;



import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class kilometerCover extends AppCompatActivity {
    ActionBar actionBar;
    FirebaseAuth auth;
    EditText tuesday, thursday;
    Button calculate;
    Intent gotoresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kilometer_covered);
        auth= FirebaseAuth.getInstance();
//        appbar
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
        tuesday= findViewById(R.id.tuesdayKilo);
        thursday= findViewById(R.id.thurdayKilo);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double tues= Double.parseDouble(tuesday.getText().toString());
                double thurs = Double.parseDouble(thursday.getText().toString());
                CalculateKilometre kilometre= new CalculateKilometre(tues,thurs);
                double totalKM=kilometre.calculateTotalKilometre();

                Toast.makeText(kilometerCover.this, ""+totalKM, Toast.LENGTH_SHORT).show();
                gotoresult= new Intent(kilometerCover.this, result.class);
                gotoresult.putExtra("result",totalKM);
                startActivity(gotoresult);
            }
        });
    }
//    assign a menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
//    select item on the menu
    //signout function is implemented on the menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.logout){
           auth.signOut();
           auth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
               @Override
               public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                   FirebaseUser user = auth.getCurrentUser();
                   if(user==null){
                       Toast.makeText(kilometerCover.this, "Logout successful", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(kilometerCover.this, MainActivity.class);
                       startActivity(intent);
                       finish();
                   }else{
                       Toast.makeText(kilometerCover.this, "Something is wrong", Toast.LENGTH_SHORT).show();
                   }
               }
           });


        }
        if(item.getItemId()==R.id.search){
            Toast.makeText(this,  "search is clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}