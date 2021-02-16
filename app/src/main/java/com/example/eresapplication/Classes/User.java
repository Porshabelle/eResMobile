package com.example.eresapplication.Classes;

public class User {

    private  String Firstname,Surname,Email,StudNum,Password,ConfPassword,Gender,Residence,Role;

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        Firstname = Firstname;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        Surname = Surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        Email = Email;
    }

    public String getStudNum() {
        return StudNum;
    }

    public void setStudNum(String StudNum) {
        StudNum = StudNum;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        Password = Password;
    }

    public String getConfPassword() {
        return ConfPassword;
    }

    public void setConfPassword(String ConfPassword) {
        ConfPassword = ConfPassword;
    }

   public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        Gender = Gender;
    }

    public String getResidence() {
        return Residence;
    }

    public void setResidence(String Residence) {
        Residence = Residence;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        Role = Role;
    }

    public  User(){ }

    public User(String Firstname,String Surname,String Email,String StudNum,String Password,String ConfPassword,String Gender,String Residence,String Role)
    {
       this.Firstname = Firstname;
        this.Surname = Surname;
        this.Email = Email;
        this.StudNum = StudNum;
        this.Password = Password;
        this.ConfPassword = ConfPassword;
        this.Gender = Gender;
        this.Residence = Residence;
        this.Role = Role;
    }
}
