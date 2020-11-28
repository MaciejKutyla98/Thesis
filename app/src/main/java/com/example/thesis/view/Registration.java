package com.example.thesis.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.thesis.R;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
    }
}