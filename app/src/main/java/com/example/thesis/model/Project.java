package com.example.thesis.model;

public class Project {

    private int logo;
    private String projectName;
    private String description;
    private String date;
    private String coordinators;
    private  boolean expanded;

    public Project(int logo, String projectName, String description, String date, String coordinators) {
        this.logo = logo;
        this.projectName = projectName;
        this.description = description;
        this.date = date;
        this.coordinators = coordinators;
        this.expanded = false;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCoordinators() {
        return coordinators;
    }

    public void setCoordinators(String coordinators) {
        this.coordinators = coordinators;
    }


    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
