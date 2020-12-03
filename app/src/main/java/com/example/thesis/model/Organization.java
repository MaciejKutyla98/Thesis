package com.example.thesis.model;

public class Organization {

    private int creationDate;
    private int numberOfActiveProjects;
    private int numberOfMembers;
    private String organizationDescription;
    private String organizationName;
    private String organizationSupervisor;
    private String supervisorRoom;

    public Organization(int creationDate, int numberOfActiveProjects, int numberOfMembers, String organizationDescription, String organizationName, String organizationSupervisor, String supervisorRoom) {
        this.creationDate = creationDate;
        this.numberOfActiveProjects = numberOfActiveProjects;
        this.numberOfMembers = numberOfMembers;
        this.organizationDescription = organizationDescription;
        this.organizationName = organizationName;
        this.organizationSupervisor = organizationSupervisor;
        this.supervisorRoom = supervisorRoom;
    }

    public int getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    public int getNumberOfActiveProjects() {
        return numberOfActiveProjects;
    }

    public void setNumberOfActiveProjects(int numberOfActiveProjects) {
        this.numberOfActiveProjects = numberOfActiveProjects;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationSupervisor() {
        return organizationSupervisor;
    }

    public void setOrganizationSupervisor(String organizationSupervisor) {
        this.organizationSupervisor = organizationSupervisor;
    }

    public String getSupervisorRoom() {
        return supervisorRoom;
    }

    public void setSupervisorRoom(String supervisorRoom) {
        this.supervisorRoom = supervisorRoom;
    }
}
