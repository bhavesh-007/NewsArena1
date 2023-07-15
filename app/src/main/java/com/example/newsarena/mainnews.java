package com.example.newsarena;

import java.util.ArrayList;

public class mainnews {
    private String status;
    private String totalr;
    private ArrayList<modalclass> articles;

    public mainnews(String status, String totalr, ArrayList<modalclass> articles) {

        this.status = status;
        this.totalr = totalr;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalr() {
        return totalr;
    }

    public void setTotalr(String totalr) {
        this.totalr = totalr;
    }

    public ArrayList<modalclass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<modalclass> articles) {
        this.articles = articles;
    }
}
