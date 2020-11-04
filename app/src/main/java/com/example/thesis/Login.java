package com.example.thesis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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

    public void goToNewsActivity(View view){
        Intent launchNewIntent = new Intent(this, News.class);
        startActivity(launchNewIntent);
        finish();
    }
}