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
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.thesis.R;
import com.example.thesis.model.SingleNews;
import com.example.thesis.controller.NewsAdapter;
import com.example.thesis.model.database.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class News extends AppCompatActivity {

    private String TAG = News.class.getSimpleName();
    private RecyclerView recyclerView;
    private String username;
    private Button addNewNews;
    private List<SingleNews> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        username = getIntent().getStringExtra("username");
        addNewNews = (Button) findViewById(R.id.add_new_news);
        addNewNews.setVisibility(View.INVISIBLE);
        if(username.equals("Oskar12345")|| username.equals("LHajec")|| username.equals("Sagata")|| username.equals("KaKania")|| username.equals("MKilian"))
            addNewNews.setVisibility(View.VISIBLE);
        newsList = new ArrayList<>();
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
                    launchNewIntent.putExtra("username", username);
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
                    launchNewIntent.putExtra("username", username);
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
                    launchNewIntent.putExtra("username", username);
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
                    launchNewIntent.putExtra("username", username);
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
                    launchNewIntent.putExtra("username", username);
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
                    launchNewIntent.putExtra("username", username);
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
                    launchNewIntent.putExtra("username", username);
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
                    launchNewIntent.putExtra("username", username);
                    startActivityForResult(launchNewIntent, 0);
                    finish();
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initRecyclerNews(){
        recyclerView = findViewById(R.id.news_recycler);
        NewsAdapter newsAdapter  = new NewsAdapter(newsList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(newsAdapter);
    }

    private class GetData extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(News.this,"Pobieram dane z bazy :)",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://thesis-server9.herokuapp.com/news";
            String jsonStr = sh.makeServiceCall(url);
            initNewsData(jsonStr);
            return  null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            initRecyclerNews();

        }

        protected void initNewsData(String jsonStr){
            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray organization = jsonObj.getJSONArray("news");

                    // looping through All Contacts
                    for (int i = 0; i < organization.length(); i++) {
                        JSONObject c = organization.getJSONObject(i);
                        SingleNews news = new SingleNews(
                                c.getString("date"),
                                c.getString("descriptionOfNews"),
                                c.getString("tittleOfNews")

                        );
                        newsList.add(news);

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

    public void goToCreateNewsActivity(View view){
        Intent launchNewIntent = new Intent(this, CreateNews.class);
        launchNewIntent.putExtra("username", username);
        startActivity(launchNewIntent);
        finish();
    }
}