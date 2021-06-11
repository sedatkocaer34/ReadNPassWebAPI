package com.example.readnpass.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.readnpass.Interfaces.ApiClient;
import com.example.readnpass.Interfaces.IRestService;
import com.example.readnpass.Models.User;
import com.example.readnpass.R;
import com.example.readnpass.Response.BaseResponse;
import com.example.readnpass.ViewModel.LoginViewModel;
import com.example.readnpass.ViewModel.UserViewModel;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private IRestService restService;
    Context context = this;
    ProgressBar   pgsBar ;
    EditText editTextemnail;
    SharedPreferences sharedPref ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPref = this.getSharedPreferences("sharedPref",Context.MODE_PRIVATE);
        if(sharedPref.getString("userId",null)!=null)
        {
            getuser();
        }
        else
        {
            setContentView(R.layout.activity_login);

            restService = ApiClient.getClient().create(IRestService.class);
            pgsBar = (ProgressBar) findViewById(R.id.progress_loader);
            editTextemnail =  findViewById(R.id.editTextEmail);
            pgsBar.setVisibility(View.GONE);
            if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }

    }

    public void onLoginClick(View View){
        startActivity(new Intent(this,RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
    }
    public void loginUser(View View){
        showLoading();

        Call<BaseResponse<UserViewModel>> call =  restService.Login(new LoginViewModel(editTextemnail.getText().toString(),"123123"));
        call.enqueue(new Callback<BaseResponse<UserViewModel>>() {
            @Override
            public void onResponse(Call<BaseResponse<UserViewModel>> call, Response<BaseResponse<UserViewModel>> response) {
                Intent intent = new Intent(context,MainActivity.class);
                intent.putExtra("userModel",response.body().getData());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("userId",response.body().getData().getId());
                editor.commit();
                startActivity(intent);
                hideLoading();
            }

            @Override
            public void onFailure(Call<BaseResponse<UserViewModel>> call, Throwable t) {
                Toast.makeText(context, "Hata Yaşandı Tekrar Deneyiniz.", Toast.LENGTH_SHORT).show();
                hideLoading();
            }
        });
    }

    private void getuser()
    {
        showLoading();
        Call<UserViewModel> call =  restService.GetUser(sharedPref.getString("userId","yok"));
        call.enqueue(new Callback<UserViewModel>() {
            @Override
            public void onResponse(Call<UserViewModel> call, Response<UserViewModel> response) {
                Intent intent = new Intent(context,MainActivity.class);
                intent.putExtra("userModel",response.body());
                startActivity(intent);
                hideLoading();
                finish();
            }

            @Override
            public void onFailure(Call<UserViewModel> call, Throwable t) {
                Toast.makeText(context, "Hata Yaşandı Tekrar Deneyiniz.", Toast.LENGTH_SHORT).show();
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
