package com.example.thesis.model;

import java.util.Comparator;

public class Project {

    private String projectName;
    private String description;
    private String date;
    private String coordinators;
    private  boolean expanded;

    public Project(String projectName, String description, String date, String coordinators) {
        this.projectName = projectName;
        this.description = description;
        this.date = date;
        this.coordinators = coordinators;
        this.expanded = false;
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

    public static Comparator<Project> projectNameComparator = new Comparator<Project>() {

        public int compare(Project p1, Project p2) {
            String projectOne = p1.getProjectName().toUpperCase();
            String projectTwo = p2.getProjectName().toUpperCase();
            return projectOne.compareTo(projectTwo);
        }};
}
