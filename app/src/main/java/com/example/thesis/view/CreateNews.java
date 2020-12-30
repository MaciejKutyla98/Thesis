package com.example.thesis.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.thesis.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateNews extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String myDate, descriptionOfNews, titleOfNews, username;
    private Button createNewsButton;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_news);
        username = getIntent().getStringExtra("username");
        requestQueue = Volley.newRequestQueue(this);
        Spinner spinner = findViewById(R.id.spinnerNews);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type_of_news, R.layout.spinner_layout);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        myDate = date.toString();
        createNewsButton = (Button) findViewById(R.id.create_new_news);
        createNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descriptionOfNews = ((EditText) findViewById(R.id.description_of_news)).getText().toString();
                titleOfNews = spinner.getSelectedItem().toString();
                checkData(v);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        titleOfNews = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void goToNewsActivity(View view) {
        Intent launchNewIntent = new Intent(this, News.class);
        launchNewIntent.putExtra("username", username);
        startActivity(launchNewIntent);
        finish();
    }

    private void createNews() {
        String url = "https://thesis-server9.herokuapp.com/createNews";
        JSONObject postData = new JSONObject();
        try {
            postData.put("date", myDate);
            postData.put("tittleOfNews", titleOfNews);
            postData.put("descriptionOfNews", descriptionOfNews);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, postData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    private void checkData(View v) {
        if (myDate.isEmpty() || descriptionOfNews.isEmpty() || titleOfNews.isEmpty())
            Toast.makeText(getApplicationContext(), "Nie podano wszystkich danych ", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(getApplicationContext(), "Rejestracja udana!", Toast.LENGTH_SHORT).show();
            createNews();
            goToNewsActivity(v);
        }
    }
}
