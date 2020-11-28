package com.example.thesis.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thesis.model.Project;
import com.example.thesis.R;

import java.util.List;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectsHolder> {

    List<Project> projectList;
    Context context;

    public ProjectsAdapter(List<Project> projectList) {
        this.projectList = projectList;
    }


    @NonNull
    @Override
    public ProjectsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.projects_row, viewGroup, false);
        return new ProjectsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectsAdapter.ProjectsHolder projectsHolder, int i) {

        Project project = projectList.get(i);
        projectsHolder.nameTextView.setText(project.getProjectName());
        projectsHolder.descriptionTextView.setText(project.getDescription());
        projectsHolder.dateTextView.setText(project.getDate());
        projectsHolder.coordinatorsTextView.setText(project.getCoordinators());
        projectsHolder.logo.setImageResource(project.getLogo());

        boolean isExpanded = projectList.get(i).isExpanded();
        projectsHolder.projectDetailsLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    public class ProjectsHolder extends RecyclerView.ViewHolder{

        ConstraintLayout projectDetailsLayout;
        ImageView logo;
        TextView nameTextView, descriptionTextView, dateTextView, coordinatorsTextView;

        public ProjectsHolder(@NonNull View itemView) {
            super(itemView);

            logo = itemView.findViewById(R.id.project_logo);
            nameTextView = itemView.findViewById(R.id.project_name);
            descriptionTextView = itemView.findViewById(R.id.project_description);
            dateTextView = itemView.findViewById(R.id.project_date);
            coordinatorsTextView = itemView.findViewById(R.id.project_coordinators);
            projectDetailsLayout = itemView.findViewById(R.id.project_details_Layout);

            nameTextView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Project project = projectList.get(getAdapterPosition());
                    project.setExpanded(!project.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
