package com.example.thesis.model;

public class Team {

    private String teamName;
    private String teamCoordinators;
    private String numberOfMembers;
    private String teamDescription;
    private boolean expanded;

    public Team(String teamName, String teamCoordinators, String numberOfMembers, String teamDescription) {
        this.teamName = teamName;
        this.teamCoordinators = teamCoordinators;
        this.numberOfMembers = numberOfMembers;
        this.teamDescription = teamDescription;
        this.expanded = false;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCoordinators() {
        return teamCoordinators;
    }

    public void setTeamCoordinators(String teamCoordinators) {
        this.teamCoordinators = teamCoordinators;
    }

    public String getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(String numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
