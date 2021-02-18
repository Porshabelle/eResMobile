package com.example.eresapplication.Classes;

public class EventCalender {
    private String Day;
    private String Event;
    private String Month;
    private String Year;
    private  String Role;
    private String Description;



    private  String Firstname;
    private  String Surname;

    public EventCalender(String day, String event,String description,String month, String year,String role,String firstname,String surname) {
        Day = day;
        Event = event;
        Month = month;
        Year = year;
        Role = role;
        Firstname = firstname;
        Surname = surname;
        Description = description;
    }

    public EventCalender() {

    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
