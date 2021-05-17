package com.example.readnpass.ViewModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserViewModel implements Serializable
{
    public UserViewModel(String id, String name, String surName, String password, String email, String defaultUserProfiePhoto, double locationLatidute, double longitudeLatidute) {
        Id = id;
        Name = name;
        SurName = surName;
        Password = password;
        Email = email;
        DefaultUserProfiePhoto = defaultUserProfiePhoto;
        this.locationLatidute = locationLatidute;
        this.longitudeLatidute = longitudeLatidute;
    }

    @SerializedName("id")
    public String Id;

    @SerializedName("name")
    public String Name;

    @SerializedName("surName")
    public String SurName;

    @SerializedName("password")
    public String Password;

    @SerializedName("email")
    public String Email;

    @SerializedName("defaultUserProfiePhoto")
    public String DefaultUserProfiePhoto;

    @SerializedName("locationLatidute")
    public double locationLatidute;

    @SerializedName("longitudeLatidute")
    public double longitudeLatidute;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDefaultUserProfiePhoto() {
        return DefaultUserProfiePhoto;
    }

    public void setDefaultUserProfiePhoto(String defaultUserProfiePhoto) {
        DefaultUserProfiePhoto = defaultUserProfiePhoto;
    }

    public double getLocationLatidute() {
        return locationLatidute;
    }

    public void setLocationLatidute(double locationLatidute) {
        this.locationLatidute = locationLatidute;
    }

    public double getLongitudeLatidute() {
        return longitudeLatidute;
    }

    public void setLongitudeLatidute(double longitudeLatidute) {
        this.longitudeLatidute = longitudeLatidute;
    }
}
