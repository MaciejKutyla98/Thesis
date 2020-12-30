package com.example.thesis.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.thesis.R;
import com.example.thesis.model.Person;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Registration extends AppCompatActivity {

    private String login, pass, secondPassword, name;
    private Button registerButton;
    RequestQueue requestQueue;
    List<Person> peopleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
        getAllUsers();

        requestQueue = Volley.newRequestQueue(this);
        peopleList = new ArrayList<>();
        registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = ((EditText) findViewById(R.id.login)).getText().toString();
                pass = ((EditText) findViewById(R.id.password)).getText().toString();
                secondPassword = ((EditText) findViewById(R.id.password2)).getText().toString();
                name = ((EditText) findViewById(R.id.name)).getText().toString();
                checkData(v);
            }
        });
    }

    public void goToLoginActivity(View view){
        Intent launchNewIntent = new Intent(this, Login.class);
        startActivity(launchNewIntent);
        finish();
    }

    private void checkData(View v){
        if(login.isEmpty() || pass.isEmpty() ||secondPassword.isEmpty() || name.isEmpty())
            Toast.makeText(getApplicationContext(), "Nie podano wszystkich danych ", Toast.LENGTH_SHORT).show();
        else if (!pass.equals(secondPassword))
            Toast.makeText(getApplicationContext(), "Hasła nie są takie same ", Toast.LENGTH_SHORT).show();
        else if (checkIfLoginExist(login))
            Toast.makeText(getApplicationContext(), "Uzytkownik o takim loginie juz istnieje", Toast.LENGTH_SHORT).show();
        else{
            Toast.makeText(getApplicationContext(), "Rejestracja udana!", Toast.LENGTH_SHORT).show();
            createAccount();
            goToLoginActivity(v);
        }

    }

    private boolean checkIfLoginExist(String login){
        for(int i=0; i<peopleList.size(); i++){
            if(peopleList.get(i).getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    private void createAccount(){
      String url = "https://thesis-server9.herokuapp.com/createNewUser";

    JSONObject postData = new JSONObject();
        try {
        postData.put("login", login);
        postData.put("pass", pass);
        postData.put("pass", name);

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

    private void getAllUsers(){
        String url = "https://thesis-server9.herokuapp.com/login";

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("login");
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject c = jsonArray.getJSONObject(i);
                        Person person = new Person(
                                c.getString("login"),
                                c.getString("pass")

                        );

                        peopleList.add(person);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}