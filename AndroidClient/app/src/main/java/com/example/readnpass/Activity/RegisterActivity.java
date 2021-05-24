package com.example.readnpass.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.readnpass.Interfaces.ApiClient;
import com.example.readnpass.Interfaces.IRestService;
import com.example.readnpass.R;
import com.example.readnpass.Response.BaseResponse;
import com.example.readnpass.ViewModel.UserViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private IRestService restService;
    EditText editTextName,editTextSurName,editTextEmail,editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextName = findViewById(R.id.editTextName);
        editTextSurName = findViewById(R.id.editTextSurname);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        restService = ApiClient.getClient().create(IRestService.class);
        changeStatusBarColor();
    }
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }

    public void onLoginClick(View view){
        startActivity(new Intent(this,LoginActivity.class));
        overridePendingTransition(R.anim.slide_in_left,android.R.anim.slide_out_right);

    }

    public void onRegisterClick(View view){
        Call<BaseResponse<UserViewModel>> call =  restService.AddUser(new UserViewModel(editTextName.getText().toString(),
                editTextSurName.getText().toString(),editTextEmail.getText().toString(),
                editTextPassword.getText().toString(),"00",0,0));
        call.enqueue(new Callback<BaseResponse<UserViewModel>>() {
            @Override
            public void onResponse(Call<BaseResponse<UserViewModel>> call, Response<BaseResponse<UserViewModel>> response) {
                Toast.makeText(RegisterActivity.this, "Kaydın Başarılı"+response, Toast.LENGTH_SHORT).show();
                Log.i("hata", "onFailure: "+response);
            }

            @Override
            public void onFailure(Call<BaseResponse<UserViewModel>> call, Throwable t) {
                Log.i("hata", "onFailure: "+t.getMessage().toString());
            }
        });
    }
}
