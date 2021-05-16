package com.example.readnpass.ViewModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BookViewModel implements Serializable
{
    @SerializedName("id")
    public String Id;

    @SerializedName("bookName")
    public String BookName;

    @SerializedName("userLibraryId")
    public String UserLibraryId;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getUserLibraryId() {
        return UserLibraryId;
    }

    public void setUserLibraryId(String userLibraryId) {
        UserLibraryId = userLibraryId;
    }
}
