package com.example.readnpass.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.readnpass.Interfaces.ApiClient;
import com.example.readnpass.Interfaces.IRestService;
import com.example.readnpass.R;
import com.example.readnpass.Response.BaseResponse;
import com.example.readnpass.ViewModel.BookViewModel;
import com.example.readnpass.ViewModel.UserViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfileUpdateActivity extends AppCompatActivity
{
    private IRestService restService;
    EditText editTextName,editTextSurName,editTextEmail,editTextPassword,EditTextPasswordRef;
    String userId;
    Context context = this;
    Button updateprofilebutton;
    SharedPreferences sharedPref ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restService = ApiClient.getClient().create(IRestService.class);
        setContentView(R.layout.activity_userprofileupdate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        editTextName =findViewById(R.id.editTextName);
        editTextSurName =findViewById(R.id.editTextSurname);
        editTextEmail =findViewById(R.id.editTextEmail);
        editTextPassword =findViewById(R.id.editTextPassword);
        EditTextPasswordRef =findViewById(R.id.editTextPasswordRef);
        updateprofilebutton =findViewById(R.id.updateprofilebutton);
        sharedPref = this.getSharedPreferences("sharedPref",Context.MODE_PRIVATE);
        userId=sharedPref.getString("userId","Kayıt Yok");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });
        loadProfile();

        updateprofilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editTextPassword.getText().toString().equals(EditTextPasswordRef.getText().toString()))
                {
                    Toast.makeText(context, "Şifreler Aynı Değil !", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    UpdateProfile();

                }
            }
        });
    }
    private void loadProfile()
    {
        Call<UserViewModel> call =  restService.GetUser(userId);
        call.enqueue(new Callback<UserViewModel>() {
            @Override
            public void onResponse(Call<UserViewModel> call, Response<UserViewModel> response) {
                Log.i("bookresponse", "onResponse: "+response);

                editTextName.setText(response.body().getName());
                editTextSurName.setText(response.body().getSurName());
                editTextEmail.setText(response.body().getEmail());
                editTextPassword.setText("******");
                EditTextPasswordRef.setText("******");
            }

            @Override
            public void onFailure(Call<UserViewModel> call, Throwable t) {
                Log.i("bookhata", "onResponse: "+t);
            }
        });
    }

    private  void UpdateProfile()
    {
        final UserViewModel userViewModel = new UserViewModel(userId,editTextName.getText().toString(),editTextSurName.getText().toString(),editTextPassword.getText().toString(),editTextEmail.getText().toString());
        Call<BaseResponse<UserViewModel>> call =  restService.UpdateUser(userViewModel);
        call.enqueue(new Callback<BaseResponse<UserViewModel>>() {
            @Override
            public void onResponse(Call<BaseResponse<UserViewModel>> call, Response<BaseResponse<UserViewModel>> response) {
                if(response.body().isSuccess())
                {
                    Toast.makeText(context, "Profil Güncellendi.", Toast.LENGTH_SHORT).show();
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("userModel",userViewModel);
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<UserViewModel>> call, Throwable t) {
                Log.i("bookhata", "onResponse: "+t);
            }
        });
    }
}
