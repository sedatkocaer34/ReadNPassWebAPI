package com.example.readnpass.ViewModel;

import com.example.readnpass.Models.Book;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import okhttp3.MultipartBody;

public class BookViewModel implements Serializable
{

    public BookViewModel(String id, String bookName, String userLibraryId, BookDetailViewModel bookDetailViewModel, boolean sales,boolean swap,String userId,String bookPhoto) {
        Id = id;
        BookName = bookName;
        UserLibraryId = userLibraryId;
        Sales = sales;
        Swap = swap;
        UserId = userId;
        BookPhoto = bookPhoto;
        this.bookDetailViewModel = bookDetailViewModel;
    }

    public BookViewModel(String bookName, String userLibraryId, BookDetailViewModel bookDetailViewModel, boolean sales,boolean swap,String userId,String bookPhoto) {
        BookName = bookName;
        UserLibraryId = userLibraryId;
        UserId = userId;
        Sales = sales;
        Swap = swap;
        BookPhoto = bookPhoto;
        this.bookDetailViewModel = bookDetailViewModel;
    }

    public BookViewModel() { }

    @SerializedName("id")
    public String Id;

    @SerializedName("bookName")
    public String BookName;

    @SerializedName("userLibraryId")
    public String UserLibraryId;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    @SerializedName("userId")
    public String UserId;

    @SerializedName("sales")
    public boolean Sales ;

    @SerializedName("swap")
    public boolean Swap ;

    @SerializedName("bookPhoto")
    public String BookPhoto;

    @SerializedName("bookPhotos")
    public List<BookPhotoViewModel> BookPhotos;

    public List<BookPhotoViewModel> getBookPhotos() {
        return BookPhotos;
    }

    public void setBookPhotos(List<BookPhotoViewModel> bookPhotos) {
        BookPhotos = bookPhotos;
    }

    public String getBookPhoto() {
        return BookPhoto;
    }

    public void setBookPhoto(String bookPhoto) {
        BookPhoto = bookPhoto;
    }

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

    @SerializedName("bookDetailViewModel")
    public BookDetailViewModel bookDetailViewModel;

    public BookDetailViewModel getBookDetailViewModel() {
        return bookDetailViewModel;
    }

    public void setBookDetailViewModel(BookDetailViewModel bookDetailViewModel) {
        this.bookDetailViewModel = bookDetailViewModel;
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

    public String getUserLibraryId() {
        return UserLibraryId;
    }

    public void setUserLibraryId(String userLibraryId) {
        UserLibraryId = userLibraryId;
    }
}
