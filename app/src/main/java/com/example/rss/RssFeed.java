package com.example.rss;

import androidx.annotation.NonNull;

public class RssFeed {

    private String title, description, pubdate;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubdate() {
        return pubdate;
    }
    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    @NonNull
    @Override
    public String toString() {
        return "Title: " + getTitle() + "\nPublication date: " + getPubdate()/* + "\nDescription: " + getDescription()*/;
    }
}
