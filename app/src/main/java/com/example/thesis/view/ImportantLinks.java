package com.example.thesis.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.thesis.R;

public class ImportantLinks extends AppCompatActivity {

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important_links);
        username = getIntent().getStringExtra("username");
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


    public void openForum(View view){
        Uri uri = Uri.parse("https://forum.eestec.agh.edu.pl");
        Intent launchNewIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(launchNewIntent);
    }

    public void openEESTECNet(View view){
        Uri uri = Uri.parse("https://eestec.net");
        Intent launchNewIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(launchNewIntent);
    }

    public void openFacebookGroup(View view){
        Uri uri = Uri.parse("https://www.facebook.com/groups/EESTEC.AGH.Krakow");
        Intent launchNewIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(launchNewIntent);
    }

    public void openInstagram(View view){
        Uri uri = Uri.parse("https://www.instagram.com/eestec_lc_krakow/?hl=pl");
        Intent launchNewIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(launchNewIntent);
    }

    public void openFacebookPage(View view){
        Uri uri = Uri.parse("https://www.facebook.com/EESTEC.AGH.Krakow");
        Intent launchNewIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(launchNewIntent);
    }
}