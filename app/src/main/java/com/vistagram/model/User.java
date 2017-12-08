package com.vistagram.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Android on 12/1/2017.
 */

public class User {

    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("userName")
    String userName;
    @SerializedName("password")
    String password;
    @SerializedName("website")
    String website;
    @SerializedName("bio")
    String bio;
    @SerializedName("icon")
    String icon;
    @SerializedName("phoneNumber")
    String phoneNumber;
    @SerializedName("email")
    String email;
    @SerializedName("gender")
    boolean gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }


}
