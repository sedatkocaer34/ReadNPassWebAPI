package com.example.readnpass.Interfaces;

import com.example.readnpass.Response.BaseResponse;
import com.example.readnpass.ViewModel.BookClaimViewModel;
import com.example.readnpass.ViewModel.BookDetailViewModel;
import com.example.readnpass.ViewModel.BookPhotoViewModel;
import com.example.readnpass.ViewModel.BookViewModel;
import com.example.readnpass.ViewModel.LoginViewModel;
import com.example.readnpass.ViewModel.UserLibraryViewModel;
import com.example.readnpass.ViewModel.UserViewModel;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface IRestService
{
    //User
    @GET("/api/user/getUser")
    Call<UserViewModel> GetUser(@Query("Id")  String Id);

    @Headers({"Content-Type: application/json"})
    @POST("/api/user/addUser")
    Call<BaseResponse<UserViewModel>> AddUser(@Body UserViewModel userViewModel);

    @Headers({"Content-Type: application/json"})
    @PUT("/api/user/updateUser")
    Call<BaseResponse<UserViewModel>> UpdateUser(@Body UserViewModel userViewModel);

    @GET("/api/user/getAllUser")
    Call<UserViewModel> GetAllUser(int Id);

    @DELETE("/api/user/deleteUser")
    Call<BaseResponse<UserViewModel>> DeleteUser(UserViewModel userViewModel);

    @Headers({"Content-Type: application/json"})
    @POST("/api/bookClaim/login")
    Call<BaseResponse<UserViewModel>> Login(@Body LoginViewModel loginViewModel);


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
    Call<BookViewModel> GetBook(@Query("Id") String  Id);

    @GET("/api/book/GetUserBook")
    Call<List<BookViewModel>> GetUserBook(@Query("Id") String  Id);
    @Multipart
    @POST("/api/book/addBook")
    Call<BaseResponse<BookViewModel>> AddBook(@Part List<MultipartBody.Part> filePart, @Part("bookViewModel") BookViewModel bookViewModel);

    @Headers({"Content-Type: application/json"})
    @PUT("/api/book/updateBook")
    Call<BaseResponse<BookViewModel>> UpdateBook(@Body BookViewModel bookViewModel);

    @GET("/api/book/getAllBook")
    Call<List<BookViewModel>> GetAllBook();

    @GET("/api/book/GetBookDetail")
    Call<BookViewModel> GetBookDetail(@Query("Id") String  Id);

    @DELETE("/api/book/deleteBook")
    Call<BaseResponse<Boolean>> DeleteBook(@Query("Id") String  Id);

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


    @GET("/api/bookClaim/GetUserSendClaim")
    Call<List<BookClaimViewModel>> GetUserSendClaim(@Query("Id") String Id);

    @GET("/api/bookClaim/GetInComeMessageClaim")
    Call<List<BookClaimViewModel>> GetInComeMessageClaim(@Query("Id") String Id);


    @Headers({"Content-Type: application/json"})
    @POST("/api/bookClaim/addBookClaim")
    Call<BaseResponse<BookClaimViewModel>> AddBookClaim(@Body  BookClaimViewModel bookClaimViewModel);

    @PUT("/api/bookClaim/updateUserLibrary")
    Call<BaseResponse<BookClaimViewModel>> UpdateBookClaim(BookClaimViewModel bookClaimViewModel);

    @GET("/api/bookClaim/getAllBookClaim")
    Call<List<BookClaimViewModel>> GetAllBookClaim(String Id);

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
