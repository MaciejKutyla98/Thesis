package com.example.thesis.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thesis.R;
import com.example.thesis.model.Person;
import com.example.thesis.model.database.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    private String TAG = Login.class.getSimpleName();
    private String login, pass;
    private Button logInButton;
    List<Person> peopleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        peopleList = new ArrayList<>();
        new GetData().execute();

        logInButton = (Button) findViewById(R.id.register_button);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = ((EditText) findViewById(R.id.login)).getText().toString();
                pass = ((EditText) findViewById(R.id.password)).getText().toString();
                checkLoginAndPassword(v);
            }
        });
    }

    public void goToRegisterActivity(View view){
        Intent launchNewIntent = new Intent(this, Registration.class);
        startActivity(launchNewIntent);
        finish();
    }

    public void goToOrganizationDetailsActivity(View view){
        Intent launchNewIntent = new Intent(this, OrganizationDetails.class);
        launchNewIntent.putExtra("username", login);
        startActivity(launchNewIntent);
        finish();
    }

    private class GetData extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://thesis-server9.herokuapp.com/login";
            String jsonStr = sh.makeServiceCall(url);
            initContactsData(jsonStr);
            return  null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }

        protected void initContactsData(String jsonStr){
            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray jsonArray = jsonObj.getJSONArray("login");

                    // looping through All Contacts
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject c = jsonArray.getJSONObject(i);
                        Person person = new Person(
                                c.getString("login"),
                                c.getString("pass")

                        );
                        peopleList.add(person);

                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
    }

    private void checkLoginAndPassword(View v){
        if(login.isEmpty() || pass.isEmpty()){
            Toast.makeText(getApplicationContext(), "Nie podano loginu lub hasla", Toast.LENGTH_SHORT).show();
        }
        else if(!login.isEmpty() && !pass.isEmpty()){
            for(int i=0; i<peopleList.size(); i++){
                if(peopleList.get(i).getLogin().equals(login) && peopleList.get(i).getPass().equals(pass)){
                    goToOrganizationDetailsActivity(v);
                }
            }
        }
    }
}