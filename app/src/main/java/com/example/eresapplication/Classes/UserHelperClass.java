package com.example.eresapplication.Classes;

import java.util.Date;

public class UserHelperClass
{
    String Title, Description;


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
