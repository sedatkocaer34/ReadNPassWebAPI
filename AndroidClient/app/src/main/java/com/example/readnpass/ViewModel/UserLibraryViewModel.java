package com.example.readnpass.ViewModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserLibraryViewModel implements Serializable
{
    @SerializedName("id")
    public String Id;

    @SerializedName("libraryName")
    public String LibraryName;

    @SerializedName("userId")
    public String UserId;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLibraryName() {
        return LibraryName;
    }

    public void setLibraryName(String libraryName) {
        LibraryName = libraryName;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
