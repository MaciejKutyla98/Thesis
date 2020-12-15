package com.example.thesis.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.thesis.R;
import com.example.thesis.model.database.HttpHandler;

public class OrganizationDetails extends AppCompatActivity {

    private String TAG = OrganizationDetails.class.getSimpleName();

    ArrayList<HashMap<String, String>> organizationDetailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_details);
        
        organizationDetailsList  = new ArrayList<>();
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
                if (this.getClass().getSimpleName().equals("Calendar")){
                    Toast.makeText(this, "Jesteś już w kalendarzu!", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else {
                    Intent launchNewIntent = new Intent(this, Calendar.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            case R.id.teams:
                if (this.getClass().getSimpleName().equals("Teams")){
                    Toast.makeText(this, "Jesteś już w informacjach o zespołach całorocznych!", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else {
                    Intent launchNewIntent = new Intent(this, Teams.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            case R.id.news:
                if (this.getClass().getSimpleName().equals("News")){
                    Toast.makeText(this, "Jesteś już w ogłoszeniach!", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else {
                    Intent launchNewIntent = new Intent(this, News.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            case R.id.activity_sheet:
                if (this.getClass().getSimpleName().equals("ActivitySheet")){
                    Toast.makeText(this, "Jesteś już w Arkuszu Aktywności!", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else {
                    Intent launchNewIntent = new Intent(this, ActivitySheet.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            case R.id.contacts:
                if (this.getClass().getSimpleName().equals("Contacts")){
                    Toast.makeText(this, "Jesteś już w liście kontaktów!", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else {
                    Intent launchNewIntent = new Intent(this, Contacts.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            case R.id.projects:
                if (this.getClass().getSimpleName().equals("Projects")){
                    Toast.makeText(this, "Jesteś już w projektach!", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else {
                    Intent launchNewIntent = new Intent(this, Projects.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            case R.id.important_links:
                if (this.getClass().getSimpleName().equals("ImportantLinks")){
                    Toast.makeText(this, "Jesteś już w ważnych linkach!", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else {
                    Intent launchNewIntent = new Intent(this, ImportantLinks.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            case R.id.organization_details:
                if (this.getClass().getSimpleName().equals("OrganizationDetails")){
                    Toast.makeText(this, "Jesteś już w informacjach o organizacji!", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else {
                    Intent launchNewIntent = new Intent(this, OrganizationDetails.class);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class GetData extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(OrganizationDetails.this,"Pobieram dane z bazy :)",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://thesis-server9.herokuapp.com/information_about_organization";
            String jsonStr = sh.makeServiceCall(url);
            initOrgaznizationDetailsData(jsonStr);
            return  null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            TextView numberOfMembers = (TextView)findViewById(R.id.number_of_members);
            TextView organizationName = (TextView)findViewById(R.id.organization_name);
            TextView organizationDescription = (TextView)findViewById(R.id.organization_description);
            TextView organizationSupervisor = (TextView)findViewById(R.id.organization_supervisor);
            TextView supervisorRoom = (TextView)findViewById(R.id.supervisor_room);
            TextView creationDate = (TextView)findViewById(R.id.creation_date);
            TextView numberOfActiveProjects = (TextView)findViewById(R.id.number_of_active_projects);

            for (HashMap<String, String> hash : organizationDetailsList) {
                for (String keys : hash.keySet()) {
                    if(keys.equals("creation_date"))
                        creationDate.setText(hash.get(keys));
                    if(keys.equals("number_of_active_projects"))
                        numberOfActiveProjects.setText(hash.get(keys));
                    if(keys.equals("number_of_members"))
                        numberOfMembers.setText(hash.get(keys));
                    if(keys.equals("organization_description"))
                        organizationDescription.setText(hash.get(keys));
                    if(keys.equals("organization_name"))
                        organizationName.setText(hash.get(keys));
                    if(keys.equals("organization_supervasior"))
                        organizationSupervisor.setText(hash.get(keys));
                    if(keys.equals("supervisor_room"))
                        supervisorRoom.setText(hash.get(keys));
                }

            }
        }

        protected void initOrgaznizationDetailsData (String jsonStr){
            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray organization = jsonObj.getJSONArray("organization");

                    // looping through All Contacts
                    for (int i = 0; i < organization.length(); i++) {
                        JSONObject c = organization.getJSONObject(i);
                        String organization_description = c.getString("organization_description");
                        String organization_name = c.getString("organization_name");
                        String organization_supervasior = c.getString("organization_supervasior");
                        String supervisor_room = c.getString("supervisor_room");
                        String creation_date = c.getString("creation_date");
                        String number_of_active_projects = c.getString("number_of_active_projects");
                        String number_of_members = c.getString("number_of_members");


                        // tmp hash map for single contact
                        HashMap<String, String> organizationMap = new HashMap<>();

                        // adding each child node to HashMap key => value
                        organizationMap.put("organization_description", organization_description);
                        organizationMap.put("organization_name", organization_name);
                        organizationMap.put("organization_supervasior", organization_supervasior);
                        organizationMap.put("supervisor_room", supervisor_room);
                        organizationMap.put("creation_date", creation_date);
                        organizationMap.put("number_of_active_projects", number_of_active_projects);
                        organizationMap.put("number_of_members", number_of_members);

                        // adding contact to contact list
                        organizationDetailsList.add(organizationMap);
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