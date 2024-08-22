package com.example.trackingapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

//Login fragment
public class loginFragment extends Fragment {
    Button loginBtn;
    Intent gotoCalculation;
    FirebaseAuth auth;
    EditText email,password;



    public loginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        loginBtn= view.findViewById(R.id.loginBtn);
        auth= FirebaseAuth.getInstance();
        email=view.findViewById(R.id.emailLogin);
        password=view.findViewById(R.id.passwordLogin);

//        adding click event on the login button
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


        // Inflate the layout for this fragment
        return view;
    }
//    Login function
    private void login(){
//        using firebaseAuth email and password signin
        auth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
//              adding firebase success listener
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(requireContext(), "Login sucessful", Toast.LENGTH_SHORT).show();
                        gotoCalculation = new Intent(requireContext(), kilometerCover.class);
                        startActivity(gotoCalculation);
                        getActivity().finish();
                    }
                })
//              Firebase failure listener
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(requireContext(), "failed " +e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }


}