package com.example.readnpass.ViewModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BookDetailViewModel implements Serializable
{
    @SerializedName("id")
    public String Id;

    @SerializedName("bookId")
    public String BookId;

    @SerializedName("bookDescription")
    public String BookDescription;

    @SerializedName("writerName")
    public String WriterName;

    @SerializedName("bookKind")
    public String BookKind;

    @SerializedName("bookPrice")
    public double BookPrice;

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

    public String getBookDescription() {
        return BookDescription;
    }

    public void setBookDescription(String bookDescription) {
        BookDescription = bookDescription;
    }

    public String getWriterName() {
        return WriterName;
    }

    public void setWriterName(String writerName) {
        WriterName = writerName;
    }

    public String getBookKind() {
        return BookKind;
    }

    public void setBookKind(String bookKind) {
        BookKind = bookKind;
    }

    public double getBookPrice() {
        return BookPrice;
    }

    public void setBookPrice(double bookPrice) {
        BookPrice = bookPrice;
    }
}
