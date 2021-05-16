package com.example.readnpass.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.readnpass.Interfaces.ApiClient;
import com.example.readnpass.Interfaces.IRestService;
import com.example.readnpass.Models.User;
import com.example.readnpass.R;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private IRestService restService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restService = ApiClient.getClient().create(IRestService.class);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login);
    }

    public void onLoginClick(View View){
        startActivity(new Intent(this,RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
    }

    private void getUser()
    {
        Call<User> call = restService.GetUser(1);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
