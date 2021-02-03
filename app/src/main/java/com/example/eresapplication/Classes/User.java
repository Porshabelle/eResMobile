package com.example.eresapplication.Classes;

public class User {

    public  String Firstname,Surname,Email,StudNum,Password,ConfPassword,Gender,Residence,Role;

    public  User()
    {

    }

    public User(String firstname,String surname,String email,String studNum,String password,String confPassword,String gender,String residence,String role)
    {
        this.Firstname = firstname;
        this.Surname = surname;
        this.Email = email;
        this.StudNum = studNum;
        this.Password = password;
        this.ConfPassword = confPassword;
        this.Gender = gender;
        this.Residence = residence;
        this.Role = role;
    }

    
}
