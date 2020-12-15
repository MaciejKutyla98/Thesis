package com.example.thesis.model;

public class SingleNews {

    private String tittleOfNews;
    private String descriptionOfNews;
    private String date;

    public SingleNews(String date, String descriptionOfNews, String tittleOfNews) {
        this.tittleOfNews = tittleOfNews;
        this.descriptionOfNews = descriptionOfNews;
        this.date = date;
    }

    public String getTittleOfNews() {
        return tittleOfNews;
    }

    public void setTittleOfNews(String tittleOfNews) {
        this.tittleOfNews = tittleOfNews;
    }

    public String getDescriptionOfNews() {
        return descriptionOfNews;
    }

    public void setDescriptionOfNews(String descriptionOfNews) {
        this.descriptionOfNews = descriptionOfNews;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
