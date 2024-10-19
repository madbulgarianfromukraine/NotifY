package com.example.notify.utils;

import android.os.Build;

import java.time.LocalDateTime;

public class Note {

    private String title;
    private LocalDateTime timeLastAccessed;
    private String text;

    public Note(String onlyTitle, boolean isTitle){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.timeLastAccessed = LocalDateTime.now();
        }
        // title or text only given
        if(isTitle){
            this.title = onlyTitle;
            this.text = "";
        }
        else{
            this.title = "No title";
            this.text = onlyTitle;

        }
    }

    public Note(String title, String text){
        this.title = title;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.timeLastAccessed = LocalDateTime.now();
        }
        this.text = text;
    }


    // getters and setters
    public LocalDateTime getTimeLastAccessed() {
        return this.timeLastAccessed;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTimeLastAccessed(LocalDateTime timeLastAccessed) {
        this.timeLastAccessed = timeLastAccessed;
    }
}
