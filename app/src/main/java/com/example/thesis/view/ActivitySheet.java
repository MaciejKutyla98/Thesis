package com.example.thesis.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.thesis.adapters.ActivityAdapter;
import com.example.thesis.model.Person;
import com.example.thesis.R;

import java.util.ArrayList;
import java.util.List;

public class ActivitySheet extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheet);

        initData();
        initRecyclerActivity();
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

    private void initRecyclerActivity(){
        recyclerView = findViewById(R.id.activity_recycler);
        ActivityAdapter activityAdapter = new ActivityAdapter(personList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(activityAdapter);
    }

    private void initData(){
        personList = new ArrayList<>();
        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));
        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));
        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));
        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));
        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));
        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));
        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));
        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));
        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));
        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));
        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));
        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));
        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));
        personList.add(new Person("Maciej Kutyła",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));
        personList.add(new Person("Hubert Kompanowski",
                "Informatyka",
                "Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej",
                "IV",
                "IT Team Koordynator",
                "History Collectors Member",
                "Active Member"));


    }
}