package com.example.thesis.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.thesis.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
    }

    public void goToRegisterActivity(View view){
        Intent launchNewIntent = new Intent(this, Registration.class);
        startActivity(launchNewIntent);
        finish();
    }

    public void goToOrganizationDetailsActivity(View view){
        Intent launchNewIntent = new Intent(this, OrganizationDetails.class);
        startActivity(launchNewIntent);
        finish();
    }
}