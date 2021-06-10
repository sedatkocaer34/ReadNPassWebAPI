package com.example.readnpass.ViewModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BookClaimViewModel implements Serializable {

    public BookClaimViewModel(String id, String bookId, String userId, String senderUserId, String explain,boolean sales) {
        Id = id;
        BookId = bookId;
        UserId = userId;
        this.senderUserId = senderUserId;
        Explain = explain;
        isSales = sales;
    }


    public BookClaimViewModel(String bookId, String userId, String senderUserId, String explain,boolean sales) {
        BookId = bookId;
        UserId = userId;
        this.senderUserId = senderUserId;
        Explain = explain;
        isSales = sales;
    }

    @SerializedName("id")
    public String Id ;
    @SerializedName("bookId")
    public String BookId ;
    @SerializedName("userId")
    public String UserId;
    @SerializedName("senderUserId")
    public String senderUserId ;
    @SerializedName("explain")
    public String Explain ;

    @SerializedName("isSales")
    public boolean isSales ;

    @SerializedName("bookViewModel")
    public BookViewModel bookViewModel;

    @SerializedName("userViewModel")
    public UserViewModel userViewModel;

    public BookViewModel getBookViewModel() {
        return bookViewModel;
    }

    public void setBookViewModel(BookViewModel bookViewModel) {
        this.bookViewModel = bookViewModel;
    }

    public UserViewModel getUserViewModel() {
        return userViewModel;
    }

    public void setUserViewModel(UserViewModel userViewModel) {
        this.userViewModel = userViewModel;
    }

    public boolean getSales() {
        return isSales;
    }

    public void setSales(boolean sales) {
        isSales = sales;
    }

    public String getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(String senderUserId) {
        this.senderUserId = senderUserId;
    }

    public String getExplain() {
        return Explain;
    }

    public void setExplain(String explain) {
        Explain = explain;
    }

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

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
