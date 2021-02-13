package com.example.eresapplication.Classes;

public class User {

    public  String Firstname,Surname,Email,StudNum,Password,ConfPassword,Gender,Residence,Role;

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getStudNum() {
        return StudNum;
    }

    public void setStudNum(String studNum) {
        StudNum = studNum;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfPassword() {
        return ConfPassword;
    }

    public void setConfPassword(String confPassword) {
        ConfPassword = confPassword;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getResidence() {
        return Residence;
    }

    public void setResidence(String residence) {
        Residence = residence;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

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
