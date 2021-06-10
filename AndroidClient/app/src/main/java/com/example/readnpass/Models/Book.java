package com.example.readnpass.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Book implements Serializable
{
    @SerializedName("id")
    public String Id;

    @SerializedName("bookName")
    public String BookName;

    @SerializedName("bookCreateDate")
    public String BookCreateDate;

    @SerializedName("bookUpdateDate")
    public String BookUpdateDate;

    @SerializedName("userLibraryId")
    public String UserLibraryId;

    @SerializedName("sales")
    public boolean Sales ;

    @SerializedName("swap")
    public boolean Swap ;

    public boolean isSales() {
        return Sales;
    }

    public void setSales(boolean sales) {
        Sales = sales;
    }

    public boolean isSwap() {
        return Swap;
    }

    public void setSwap(boolean swap) {
        Swap = swap;
    }

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

    public String getBookCreateDate() {
        return BookCreateDate;
    }

    public void setBookCreateDate(String bookCreateDate) {
        BookCreateDate = bookCreateDate;
    }

    public String getBookUpdateDate() {
        return BookUpdateDate;
    }

    public void setBookUpdateDate(String bookUpdateDate) {
        BookUpdateDate = bookUpdateDate;
    }

    public String getUserLibraryId() {
        return UserLibraryId;
    }

    public void setUserLibraryId(String userLibraryId) {
        UserLibraryId = userLibraryId;
    }
}
