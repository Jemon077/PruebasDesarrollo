package com.example.damn_tiendaapp.Entidades;

public class Users {


     private String name;
     private String surename;

     private String userName;
     private String email;
     private String cellphone;
     private String password;

    public Users(String name, String surename, String userName, String email, String cellphone, String password) {
        this.name = name;
        this.surename = surename;
        this.userName = userName;
        this.email = email;
        this.cellphone = cellphone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
