package com.example.thesis;

public class SingleNews {

    private int avatar;
    private String tittleOfNews;
    private String descriptionOfNews;

    public SingleNews(int avatar, String tittleOfNews, String descriptionOfNews) {
        this.avatar = avatar;
        this.tittleOfNews = tittleOfNews;
        this.descriptionOfNews = descriptionOfNews;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
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
}
