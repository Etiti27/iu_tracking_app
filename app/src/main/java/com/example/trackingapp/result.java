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
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class result extends AppCompatActivity {
    ActionBar actionBar;
    FirebaseAuth auth;
    WebView webView;
    ImageView imageView;
    Intent intent;
    TextView congratText, KMText, congratText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        intent= getIntent();
        auth=FirebaseAuth.getInstance();
//        appbar
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.title);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setLogo(R.mipmap.cantje_logo);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.sky_blue)));
        }
        StatusCheck();
    }

private void StatusCheck(){
        congratText = findViewById(R.id.resultText1);
        congratText2= findViewById(R.id.resultText2);
        KMText = findViewById(R.id.resultInfp);

        double result=intent.getDoubleExtra("result",0);
        KMText.setText(""+result +" KM/HR");

        Toast.makeText(this, "the ressult is "+result, Toast.LENGTH_SHORT).show();
        if (result <12.5){
            imageView = findViewById(R.id.imageView);
            imageView.setImageResource(R.mipmap.maguire);
            congratText.setText(R.string.failuretext1);
            congratText2.setText(R.string.failure_advice);

        }





    // add the url of gif

}
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
                        Toast.makeText(result.this, "Logout successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(result.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(result.this, "Something is wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        if(item.getItemId()==R.id.search){
            Toast.makeText(this,  "search is clicked", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == android.R.id.home) {
            // Handle the back button action
            onBackPressed(); // This will go back to the previous activity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}