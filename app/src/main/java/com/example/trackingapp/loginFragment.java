package com.example.trackingapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class loginFragment extends Fragment {
    Button loginBtn;
    Intent gotoSexSelectionIntent;



    public loginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        loginBtn= view.findViewById(R.id.loginBtn);
        swtch();


        // Inflate the layout for this fragment
        return view;
    }

        public void swtch(){
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoSexSelectionIntent= new Intent(requireContext(), kilometerCover.class);
                startActivity(gotoSexSelectionIntent);
                getActivity().finish();


            }
        });
    }
    public void switchFragments(View view) {
    }
}