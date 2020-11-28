package com.example.thesis.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thesis.R;

public class DetailNews extends AppCompatActivity {

    ImageView imageView;
    TextView title, description;

    String receivedTitle, recivedDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

        imageView = findViewById(R.id.detail_news_image);
        title = findViewById(R.id.detail_news_title);
        description = findViewById(R.id.detail_news_description);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("title_of_news") && getIntent().hasExtra("description_of_news")){
            receivedTitle = getIntent().getStringExtra("title_of_news");
            recivedDescription = getIntent().getStringExtra("description_of_news");
    }else{
            Toast.makeText(this, "Brak parametrów do przekazania", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title.setText(receivedTitle);
        description.setText(recivedDescription);
    }

}