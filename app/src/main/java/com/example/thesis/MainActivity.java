package com.example.thesis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void goToRegisterActivity(View view){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
        finish();
    }

    public void goToNewsActivity(View view){
        Intent intent = new Intent(this, News.class);
        startActivity(intent);
        finish();
    }
}