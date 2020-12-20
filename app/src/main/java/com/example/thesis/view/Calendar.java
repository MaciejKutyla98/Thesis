package com.example.thesis.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.thesis.R;
import com.example.thesis.model.Event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendar extends AppCompatActivity {

    private static final String TAG = "Calendar";
    private static final String myUrl = "https://api.kloudless.com/v1/accounts/me/cal/calendars/calendar_NmxhcjU3c2YxM3EyY3FiODNvaGduMW01ZGtAZ3JvdXAuY2FsZW5kYXIuZ29vZ2xlLmNvbQ/events/";
    private static final String accesstoken = "SwZcwL7DxYzGUW07yyDuk7R5LilRv0";
    private RequestQueue queue;
    private CalendarView calendarView;
    private String currentDate;
    private List<Event> eventList;
    private TextView dayInformation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        eventList = new ArrayList<>();
        queue = Volley.newRequestQueue(this);
        jsonParse();
        dayInformation = (TextView) findViewById(R.id.dayInformation);
        calendarView = (CalendarView) findViewById(R.id.myCalendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                currentDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                Log.d(TAG, "Obecna data to: " + currentDate);
                Log.d(TAG, "eventList.get(i).getEventStart() " + eventList.get(1).getEventStart().startsWith(currentDate));

                for(int i=0; i<eventList.size(); i++){
                    Log.d(TAG, "iteracja " + i);
                    if(eventList.get(i).getEventStart().startsWith(currentDate)){
                        dayInformation.setText("Temat spotkania:" + eventList.get(i).getEventName() + "\nRozpocznie się o:  " + eventList.get(i).getEventStart().substring(11, 16) + "\nZakończy się o: " + eventList.get(i).getEventEnd().substring(11,16));
                    }
                }
            }
        });

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

    private void jsonParse(){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, myUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray objects = response.getJSONArray("objects");

                            for (int i = 0; i < objects.length(); i++) {
                                JSONObject c = objects.getJSONObject(i);
                                Event event = new Event(
                                        c.getString("name"),
                                        c.getString("start"),
                                        c.getString("end")
                                );
                                eventList.add(event);

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
        })
        {
            @Override
            public  Map<String,String> getHeaders() throws  AuthFailureError{
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer " + accesstoken);
                return headers;
            }
        };
        queue.add(request);
    }
}