package com.example.thesis;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class News extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.calendar:
                Toast.makeText(this, "calendar selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.activity_sheet:
                Toast.makeText(this, "activity_sheet selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.contacts:
                Toast.makeText(this, "Contacts selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.projects:
                Toast.makeText(this, "projects selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.important_links:
                Toast.makeText(this, "important_links selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}