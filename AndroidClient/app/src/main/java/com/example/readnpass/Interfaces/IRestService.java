package com.example.readnpass.Interfaces;

import com.example.readnpass.Models.User;
import com.example.readnpass.Response.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IRestService {
    @GET("api/user/getuser")
    Call<User> GetUser(int userId);

    @POST("api/user/addUser")
    Call<BaseResponse<User>> AddUser(int userId);
}
