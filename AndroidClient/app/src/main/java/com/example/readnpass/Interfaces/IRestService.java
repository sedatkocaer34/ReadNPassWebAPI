package com.example.readnpass.Interfaces;

import com.example.readnpass.Models.User;
import com.example.readnpass.Response.BaseResponse;
import com.example.readnpass.ViewModel.UserViewModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IRestService {

    @GET("/api/user/getUser")
    Call<UserViewModel> GetUser(int Id);

    @POST("/api/user/addUser")
    Call<BaseResponse<UserViewModel>> AddUser(UserViewModel userViewModel);

}
