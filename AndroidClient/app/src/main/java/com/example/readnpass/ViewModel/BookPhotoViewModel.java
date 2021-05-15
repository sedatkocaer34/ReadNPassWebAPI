package com.example.readnpass.ViewModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BookPhotoViewModel implements Serializable
{
    @SerializedName("id")
    public String Id;

    @SerializedName("bookId")
    public String  BookId;

    @SerializedName("bookPhotoUrl")
    public String BookPhotoUrl;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getBookPhotoUrl() {
        return BookPhotoUrl;
    }

    public void setBookPhotoUrl(String bookPhotoUrl) {
        BookPhotoUrl = bookPhotoUrl;
    }
}
