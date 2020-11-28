package com.example.thesis.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thesis.model.Person;
import com.example.thesis.R;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityHolder> {

    List<Person> personList;
    Context context;

    public ActivityAdapter(List<Person> personList, Context context) {
        this.personList = personList;
        this.context = context;
    }

    @NonNull
    @Override
    public ActivityAdapter.ActivityHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_sheet_row, viewGroup, false);
        return new ActivityHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityAdapter.ActivityHolder activityHolder, int i) {

        Person person = personList.get(i);
        activityHolder.nameTextView.setText(person.getName());
        activityHolder.fieldOfStudyTextView.setText("Kierunek: " +person.getFieldOfStudy());
        activityHolder.facultyTextView.setText(person.getFaculty());
        activityHolder.yearOfStudyTextView.setText("Rok: "+ person.getYearOfStudy());
        activityHolder.positionTextView.setText(person.getPosition());
        activityHolder.internationalPositionTextView.setText(person.getInternationalActivity());
        activityHolder.statusTextView.setText(person.getCurrentStatus());

        boolean isExpanded = personList.get(i).isExpanded();
        activityHolder.activitySheetDetailLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ActivityHolder extends RecyclerView.ViewHolder{

        ConstraintLayout activitySheetDetailLayout;
        TextView nameTextView, fieldOfStudyTextView, facultyTextView, yearOfStudyTextView, positionTextView, internationalPositionTextView, statusTextView;

        public ActivityHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.activity_sheet_name);
            fieldOfStudyTextView = itemView.findViewById(R.id.field_of_study);
            facultyTextView = itemView.findViewById(R.id.faculty);
            yearOfStudyTextView = itemView.findViewById(R.id.year_of_study);
            positionTextView = itemView.findViewById(R.id.position);
            internationalPositionTextView = itemView.findViewById(R.id.international_position);
            statusTextView = itemView.findViewById(R.id.status);
            activitySheetDetailLayout = itemView.findViewById(R.id.activitySheetDetailLayout);

            nameTextView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Person person  = personList.get(getAdapterPosition());
                    person.setExpanded(!person.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
