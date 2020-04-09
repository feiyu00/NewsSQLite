package com.example.localization.pojo;

import java.io.Serializable;

public class News implements Serializable {
    private String NewsTitle;
    private String NewsContent;

    public News(String newsTitle, String newsContent) {
        NewsTitle = newsTitle;
        NewsContent = newsContent;
    }

    public News() {
    }

    public String getNewsTitle() {
        return NewsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        NewsTitle = newsTitle;
    }

    public String getNewsContent() {
        return NewsContent;
    }

    public void setNewsContent(String newsContent) {
        NewsContent = newsContent;
    }

    @Override
    public String toString() {
        return "News{" +
                "NewsTitle='" + NewsTitle + '\'' +
                ", NewsContent='" + NewsContent + '\'' +
                '}';
    }
}
