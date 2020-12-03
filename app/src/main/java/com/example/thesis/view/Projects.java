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

import com.example.thesis.model.Project;
import com.example.thesis.R;
import com.example.thesis.adapters.ProjectsAdapter;

import java.util.ArrayList;
import java.util.List;

public class Projects extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Project> projectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        initData();
        initRecyclerProjects();
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

    private void initRecyclerProjects(){
        recyclerView = findViewById(R.id.projects_recycler);
        ProjectsAdapter projectsAdapter = new ProjectsAdapter(projectList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(projectsAdapter);
    }

    private void initData(){
        projectList = new ArrayList<>();
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
        projectList.add(new Project(R.drawable.ssa,
                "Soft Skills Academy 10",
                "Nasze wydarzenie skupia się wokół tematyki umiejętności miękkich, czyli wszystkich tych które potrzebne są nam do skutecznej interakcji z innymi ludźmi a także do swobodnego wyrażania siebie. Korzystamy z nich nieświadomie w każdej minucie naszego życia – na studiach, w pracy, podczas spotkań ze znajomymi czy rodziną, a także podczas nauki czy organizacji dnia. To “pierwiastek ludzki”, niezbędny w każdym procesie, niemożliwy do zastąpienia przez żadną maszynę czy program. ",
                "26.11.2020 - 06.12.2020",
                "Julia Machnio \nKacper Szepielak \nKamil Pytel \nBenita Myśliwiec \nMarysia Nowak"));
    }
}