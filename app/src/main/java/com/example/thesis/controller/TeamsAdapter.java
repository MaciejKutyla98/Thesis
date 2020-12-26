package com.example.thesis.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thesis.R;
import com.example.thesis.model.Team;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamsHolder> {

    List<Team> teamsList;
    Context context;

    public TeamsAdapter(List<Team> teamsList, Context context) {
        this.teamsList = teamsList;
        this.context = context;
    }

    @NonNull
    @Override
    public TeamsAdapter.TeamsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.team_row, viewGroup, false);
        return new TeamsAdapter.TeamsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsAdapter.TeamsHolder teamsHolder, int i) {

        Team team = teamsList.get(i);
        teamsHolder.teamNameTextView.setText(team.getTeamName());
        teamsHolder.teamCoordinatorsTextView.setText(team.getTeamCoordinators());
        teamsHolder.numberOfMembersTextView.setText(team.getNumberOfMembers());
        teamsHolder.teamDescriptionTextView.setText(team.getTeamDescription());


        boolean isExpanded = teamsList.get(i).isExpanded();
        teamsHolder.teamsDetailLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return teamsList.size();
    }

    public class TeamsHolder extends RecyclerView.ViewHolder{

        ConstraintLayout teamsDetailLayout;
        TextView teamNameTextView, teamCoordinatorsTextView, numberOfMembersTextView, teamDescriptionTextView;

        public TeamsHolder(@NonNull View itemView) {
            super(itemView);

            teamNameTextView = itemView.findViewById(R.id.team_name);
            teamCoordinatorsTextView = itemView.findViewById(R.id.team_coordinators);
            numberOfMembersTextView = itemView.findViewById(R.id.team_members);
            teamDescriptionTextView = itemView.findViewById(R.id.team_description);
            teamsDetailLayout = itemView.findViewById(R.id.teamDetailLayout);

            teamNameTextView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Team team  = teamsList.get(getAdapterPosition());
                    team.setExpanded(!team.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }

}
