package com.example.eresapplication.Classes;

import java.util.Date;

public class UserHelperClass
{
    private String Title;
    private String Description;

    UserHelperClass()
    {

    }

    public UserHelperClass(String title, String description) {
        Title = title;
        Description = description;
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


}
