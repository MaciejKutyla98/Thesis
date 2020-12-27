package com.example.thesis.model;

import java.util.Comparator;

public class Person   {

    private String login;
    private String pass;
    private String name;
    private String telephoneNumber;
    private String mail;
    private String fieldOfStudy;
    private String faculty;
    private String yearOfStudy;
    private String position;
    private String internationalActivity;
    private String currentStatus;
    private boolean expanded;

    public Person() {
    }

    public Person(String name, String telephoneNumber, String mail, String fieldOfStudy, String faculty, String yearOfStudy, String position, String internationalActivity, String currentStatus) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.mail = mail;
        this.fieldOfStudy = fieldOfStudy;
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
        this.position = position;
        this.internationalActivity = internationalActivity;
        this.currentStatus = currentStatus;
        this.expanded = false;
    }

    public Person(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public Person(String name, String telephoneNumber, String mail) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.mail = mail;
        this.expanded = false;
    }

    public Person(String name, String fieldOfStudy, String faculty, String yearOfStudy, String position, String internationalActivity, String currentStatus) {
        this.name = name;
        this.fieldOfStudy = fieldOfStudy;
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
        this.position = position;
        this.internationalActivity = internationalActivity;
        this.currentStatus = currentStatus;
        this.expanded = false;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getInternationalActivity() {
        return internationalActivity;
    }

    public void setInternationalActivity(String internationalActivity) {
        this.internationalActivity = internationalActivity;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public static Comparator<Person> personNameComparator = new Comparator<Person>() {

        public int compare(Person p1, Person p2) {
            String personOne = p1.getName().toUpperCase();
            String personTwo = p2.getName().toUpperCase();
            return personOne.compareTo(personTwo);
        }};

}
