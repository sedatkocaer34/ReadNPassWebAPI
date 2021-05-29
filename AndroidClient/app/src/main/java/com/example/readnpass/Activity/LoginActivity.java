package com.example.readnpass.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.readnpass.Interfaces.ApiClient;
import com.example.readnpass.Interfaces.IRestService;
import com.example.readnpass.Models.User;
import com.example.readnpass.R;
import com.example.readnpass.ViewModel.UserViewModel;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private IRestService restService;
    Context context = this;
    ProgressBar   pgsBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        restService = ApiClient.getClient().create(IRestService.class);
        pgsBar = (ProgressBar) findViewById(R.id.progress_loader);
        pgsBar.setVisibility(View.GONE);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }

    public void onLoginClick(View View){
        startActivity(new Intent(this,RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
    }

    private void getUser()
    {
        showLoading();
        Call<UserViewModel> call = restService.GetUser(1);
        call.enqueue(new Callback<UserViewModel>() {
            @Override
            public void onResponse(Call<UserViewModel> call, Response<UserViewModel> response) {
              hideLoading();
            }

            @Override
            public void onFailure(Call<UserViewModel> call, Throwable t) {
              hideLoading();
            }
        });
    }

    private  void hideLoading()
    {
        pgsBar.setVisibility(View.GONE);
    }

    private  void showLoading()
    {
        pgsBar.setVisibility(View.VISIBLE);
    }
}
