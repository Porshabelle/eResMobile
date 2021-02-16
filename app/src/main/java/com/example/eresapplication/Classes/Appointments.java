package com.example.eresapplication.Classes;

public class Appointments {
    String title;
    String date;
    String location;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Appointments(String title, String date, String location) {
        this.title = title;
        this.date = date;
        this.location = location;
    }
}
