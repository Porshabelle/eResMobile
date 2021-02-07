package com.example.eresapplication.Classes;

import java.util.Date;

public class UserHelperClass
{
    private String Title;
    private String Description;
    private String Role;
    private String Firstname;
    private String Surname;


    UserHelperClass()
    {

    }

    public UserHelperClass(String title, String description,String role,String firstname,String surname) {
        Title = title;
        Description = description;
        Role = role;
        Firstname = firstname;
        Surname = surname;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

}
