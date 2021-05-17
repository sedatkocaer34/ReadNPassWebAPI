package com.example.readnpass.Interfaces;

import com.example.readnpass.Models.User;
import com.example.readnpass.Response.BaseResponse;
import com.example.readnpass.ViewModel.BookClaimViewModel;
import com.example.readnpass.ViewModel.BookDetailViewModel;
import com.example.readnpass.ViewModel.BookPhotoViewModel;
import com.example.readnpass.ViewModel.BookViewModel;
import com.example.readnpass.ViewModel.UserLibraryViewModel;
import com.example.readnpass.ViewModel.UserViewModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface IRestService
{
    //User
    @GET("/api/user/getUser")
    Call<UserViewModel> GetUser(int Id);

    @Headers({"Content-Type: application/json"})
    @POST("/api/user/addUser")
    Call<BaseResponse<UserViewModel>> AddUser(@Body UserViewModel userViewModel);

    @PUT("/api/user/updateUser")
    Call<BaseResponse<UserViewModel>> UpdateUser(UserViewModel userViewModel);

    @GET("/api/user/getAllUser")
    Call<UserViewModel> GetAllUser(int Id);

    @DELETE("/api/user/deleteUser")
    Call<BaseResponse<UserViewModel>> DeleteUser(UserViewModel userViewModel);


    //UserLibrary
    @GET("/api/userLibrary/getUserLibrary")
    Call<UserLibraryViewModel> GetUserLibrary(int Id);

    @POST("/api/userLibrary/addUserLibrary")
    Call<BaseResponse<UserLibraryViewModel>> AddUserLibrary(UserLibraryViewModel userLibraryViewModel);

    @PUT("/api/userLibrary/updateUserLibrary")
    Call<BaseResponse<UserLibraryViewModel>> UpdateUserLibrary(UserLibraryViewModel userLibraryViewModel);

    @GET("/api/userLibrary/getAllUserLibrary")
    Call<UserLibraryViewModel> GetAllUserLibrary(int Id);

    @DELETE("/api/userLibrary/deleteUserLibrary")
    Call<BaseResponse<UserLibraryViewModel>> DeleteUserLibrary(UserLibraryViewModel userLibraryViewModel);

    //Book
    @GET("/api/book/getBook")
    Call<BookViewModel> GetBook(int Id);

    @POST("/api/book/addUserLibrary")
    Call<BaseResponse<BookViewModel>> AddBook(BookViewModel bookViewModel);

    @PUT("/api/book/updateBook")
    Call<BaseResponse<BookViewModel>> UpdateBook(BookViewModel bookViewModel);

    @GET("/api/book/getAllBook")
    Call<BookViewModel> GetAllBook(int Id);

    @DELETE("/api/book/deleteBook")
    Call<BaseResponse<BookViewModel>> DeleteBook(BookViewModel bookViewModel);

    //BookPhoto
    @GET("/api/bookPhoto/getBookPhoto")
    Call<BookPhotoViewModel> GetBookPhoto(int Id);

    @POST("/api/bookPhoto/addBookPhoto")
    Call<BaseResponse<BookPhotoViewModel>> AddBookPhoto(BookPhotoViewModel bookPhotoViewModel);

    @PUT("/api/bookPhoto/updateBookPhoto")
    Call<BaseResponse<BookPhotoViewModel>> UpdateBookPhoto(BookPhotoViewModel bookPhotoViewModel);

    @GET("/api/bookPhoto/getAllBookPhoto")
    Call<BookPhotoViewModel> GetAllBookPhoto(int Id);

    @DELETE("/api/bookPhoto/deleteBookPhoto")
    Call<BaseResponse<BookPhotoViewModel>> DeleteBookPhoto(BookPhotoViewModel bookPhotoViewModel);

    //BookClaim
    @GET("/api/bookClaim/getBookClaim")
    Call<BookClaimViewModel> GetBookClaim(int Id);

    @POST("/api/bookClaim/addBookClaim")
    Call<BaseResponse<BookClaimViewModel>> AddBookClaim(BookClaimViewModel bookClaimViewModel);

    @PUT("/api/bookClaim/updateUserLibrary")
    Call<BaseResponse<BookClaimViewModel>> UpdateBookClaim(BookClaimViewModel bookClaimViewModel);

    @GET("/api/bookClaim/getAllBookClaim")
    Call<BookClaimViewModel> GetAllBookClaim(int Id);

    @DELETE("/api/bookClaim/deleteBookClaim")
    Call<BaseResponse<BookClaimViewModel>> DeleteBookClaim(BookClaimViewModel bookClaimViewModel);

    //BookDetail
    @GET("/api/bookDetail/getBookDetail")
    Call<BookDetailViewModel> GetBookDetail(int Id);

    @POST("/api/bookDetail/addUserLibraryDetail")
    Call<BaseResponse<BookDetailViewModel>> AddBookDetail(BookDetailViewModel bookDetailViewModel);

    @PUT("/api/bookDetail/updateBookDetail")
    Call<BaseResponse<BookDetailViewModel>> UpdateBookDetail(BookDetailViewModel bookDetailViewModel);

    @GET("/api/bookDetail/getAllBookDetail")
    Call<BookDetailViewModel> GetAllBookDetail(int Id);

    @DELETE("/api/bookDetail/deleteBookDetail")
    Call<BaseResponse<BookDetailViewModel>> DeleteBookDetail(BookDetailViewModel bookDetailViewModel);

}
