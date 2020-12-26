package com.example.thesis.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.thesis.R;
import com.example.thesis.controller.TeamsAdapter;
import com.example.thesis.model.Person;
import com.example.thesis.model.Team;
import com.example.thesis.model.database.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Teams extends AppCompatActivity {

    private String TAG = Teams.class.getSimpleName();
    RecyclerView recyclerView;
    List<Team> teamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        teamList = new ArrayList<>();
        new GetData().execute();
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
                if (this.getClass().getSimpleName().equals("Calendar")) {
                    Toast.makeText(this, "Jesteś już w kalendarzu!", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    Intent launchNewIntent = new Intent(this, Calendar.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            case R.id.teams:
                if (this.getClass().getSimpleName().equals("Teams")) {
                    Toast.makeText(this, "Jesteś już w informacjach o zespołach całorocznych!", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    Intent launchNewIntent = new Intent(this, Teams.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            case R.id.news:
                if (this.getClass().getSimpleName().equals("News")) {
                    Toast.makeText(this, "Jesteś już w ogłoszeniach!", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    Intent launchNewIntent = new Intent(this, News.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            case R.id.activity_sheet:
                if (this.getClass().getSimpleName().equals("ActivitySheet")) {
                    Toast.makeText(this, "Jesteś już w Arkuszu Aktywności!", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    Intent launchNewIntent = new Intent(this, ActivitySheet.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            case R.id.contacts:
                if (this.getClass().getSimpleName().equals("Contacts")) {
                    Toast.makeText(this, "Jesteś już w liście kontaktów!", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    Intent launchNewIntent = new Intent(this, Contacts.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            case R.id.projects:
                if (this.getClass().getSimpleName().equals("Projects")) {
                    Toast.makeText(this, "Jesteś już w projektach!", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    Intent launchNewIntent = new Intent(this, Projects.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            case R.id.important_links:
                if (this.getClass().getSimpleName().equals("ImportantLinks")) {
                    Toast.makeText(this, "Jesteś już w ważnych linkach!", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    Intent launchNewIntent = new Intent(this, ImportantLinks.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            case R.id.organization_details:
                if (this.getClass().getSimpleName().equals("OrganizationDetails")) {
                    Toast.makeText(this, "Jesteś już w informacjach o organizacji!", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    Intent launchNewIntent = new Intent(this, OrganizationDetails.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initRecyclerTeams() {
        recyclerView = findViewById(R.id.teams_recycler);
        TeamsAdapter teamsAdapter = new TeamsAdapter(teamList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(teamsAdapter);
    }

    private class GetData extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(Teams.this,"Pobieram dane z bazy",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://thesis-server9.herokuapp.com/teams";
            String jsonStr = sh.makeServiceCall(url);
            initContactsData(jsonStr);
            return  null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            initRecyclerTeams();

        }

        protected void initContactsData(String jsonStr){
            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray jsonArray = jsonObj.getJSONArray("teams");

                    // looping through All Contacts
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject c = jsonArray.getJSONObject(i);
                        Team team = new Team(
                                c.getString("teamName"),
                                c.getString("teamCoordinators"),
                                c.getString("numberOfMembers"),
                                c.getString("teamDescription")

                        );
                        teamList.add(team);

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
}