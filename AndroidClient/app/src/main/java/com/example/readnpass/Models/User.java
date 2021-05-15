package com.example.readnpass.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String Name ;

    @SerializedName("surName")
    public String SurName ;

    @SerializedName("email")
    public String Email ;

    @SerializedName("password")
    public String Password;

    @SerializedName("locationLatidute")
    public double LocationLatidute ;

    @SerializedName("longitudeLatidute")
    public double LongitudeLatidute;

    @SerializedName("defaultUserProfiePhoto")
    public String DefaultUserProfiePhoto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public double getLocationLatidute() {
        return LocationLatidute;
    }

    public void setLocationLatidute(double locationLatidute) {
        LocationLatidute = locationLatidute;
    }

    public double getLongitudeLatidute() {
        return LongitudeLatidute;
    }

    public void setLongitudeLatidute(double longitudeLatidute) {
        LongitudeLatidute = longitudeLatidute;
    }

    public String getDefaultUserProfiePhoto() {
        return DefaultUserProfiePhoto;
    }

    public void setDefaultUserProfiePhoto(String defaultUserProfiePhoto) {
        DefaultUserProfiePhoto = defaultUserProfiePhoto;
    }
}
