package com.timebird.scheduleGetData.entity;

import java.util.Date;

public class User {
    private String userID;
    private String name;
    private String username;
    private Date birthday;
    private String address;
    private String mail;
    private String role;
    private String gender;

    public User() {
    }

    public User(String userID, String name, String username, Date birthday,
                String address, String mail, String role, String gender) {
        this.userID = userID;
        this.name = name;
        this.username = username;
        this.birthday = birthday;
        this.address = address;
        this.mail = mail;
        this.role = role;
        this.gender = gender;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getMail() {
        return mail;
    }

    public String getRole() {
        return role;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", mail='" + mail + '\'' +
                ", role='" + role + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
