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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class registerFragment extends Fragment {
    FirebaseAuth auth;
    FirebaseFirestore db;
    Intent gotoSexSelectionIntent;
    EditText name, email, password, sex;
    Button btn;
    RadioGroup radioGroup;
    String playerSex, playerEmail, playerPassword,playerName;





    public registerFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_register, container, false);
        auth= FirebaseAuth.getInstance();
        db= FirebaseFirestore.getInstance();
        name= view.findViewById(R.id.nameRegister);
        email= view.findViewById(R.id.emailRegister);
        password=view.findViewById(R.id.passwordRegister1);
        radioGroup=view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.female){
                    playerSex="Female";

                } else if (checkedId==R.id.male) {
                    playerSex="Male";

                }
            }
        });
        btn= view.findViewById(R.id.RegisterBtnn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Register();
            }
        });





        return view;
    }

    private void Register(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.female){
                    playerSex="Female";
                } else if (checkedId==R.id.male) {
                    playerSex="Male";
                }
            }
        });
        playerEmail=email.getText().toString();
        playerPassword=password.getText().toString();
        playerName=name.getText().toString();
        auth.createUserWithEmailAndPassword(playerEmail,playerPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Map<String, Object> users= new HashMap<>();
                users.put("name",playerName);
                users.put("email", playerEmail);
                users.put("sex", playerSex);
                db.collection("users")
                        .add(users)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(requireContext(), "Registration Successful", Toast.LENGTH_LONG).show();
                                gotoSexSelectionIntent= new Intent(requireContext(), kilometerCover.class);
                                startActivity(gotoSexSelectionIntent);
                                getActivity().finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(requireContext(), "failed! "+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}