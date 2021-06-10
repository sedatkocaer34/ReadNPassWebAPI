package com.example.readnpass.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.readnpass.Interfaces.ApiClient;
import com.example.readnpass.Interfaces.IRestService;
import com.example.readnpass.R;
import com.example.readnpass.Response.BaseResponse;
import com.example.readnpass.ViewModel.BookDetailViewModel;
import com.example.readnpass.ViewModel.BookViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookUpdateActivity extends AppCompatActivity
{
    Button btnupdatebutton;
    Context context = this;
    BookViewModel bookViewModel;
    EditText editTextBookName,editTextBookDesc,editTextWriterName,editTextBookKind,editTextBookPrice;
    CheckBox checkBoxSales,checkBoxSwap;
    private IRestService restService;
    String bookId,UserId;
    SharedPreferences sharedPref ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restService = ApiClient.getClient().create(IRestService.class);
        sharedPref = this.getSharedPreferences("sharedPref",Context.MODE_PRIVATE);
        bookId=getIntent().getStringExtra("bookId");
        Log.i("gelen", "onCreate: "+bookId);
        setContentView(R.layout.activity_bookupdate);
        btnupdatebutton = findViewById(R.id.btnupdatebutton);
        editTextBookName = findViewById(R.id.editTextBookName);
        editTextBookDesc = findViewById(R.id.editTextBookDesc);
        editTextWriterName = findViewById(R.id.editTextWriterName);
        editTextBookKind = findViewById(R.id.editTextBookKind);
        editTextBookPrice = findViewById(R.id.editTextBookPrice);
        UserId=    sharedPref.getString("userId","Kayıt Yok");
        checkBoxSales = findViewById(R.id.checkBoxSales);
        checkBoxSwap = findViewById(R.id.checkBoxSwap);
        btnupdatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookViewModel = new BookViewModel(bookId,editTextBookName.getText().toString(),"287ec72b-05ac-4fcf-1c90-08d91304fd81",new BookDetailViewModel(bookId,editTextBookDesc.getText().toString(),
                        editTextWriterName.getText().toString(),editTextBookKind.getText().toString(),Double.parseDouble(editTextBookPrice.getText().toString())),
                        checkBoxSales.isChecked(),checkBoxSwap.isChecked(),UserId,null);

                Call<BaseResponse<BookViewModel>> call =  restService.UpdateBook(bookViewModel);
                call.enqueue(new Callback<BaseResponse<BookViewModel>>() {
                    @Override
                    public void onResponse(Call<BaseResponse<BookViewModel>> call, Response<BaseResponse<BookViewModel>> response) {
                        Log.i("countdata", "onAddBookClick: "+response.body());
                        if(response.body().isSuccess())
                        {
                            finish();
                        }

                    }

                    @Override
                    public void onFailure(Call<BaseResponse<BookViewModel>> call, Throwable t) {
                        Log.i("bookhata", "onResponse: "+t);
                    }
                });
            }
        });
        loadBook();
    }

    private  void loadBook()
    {
        Call<BookViewModel> call =  restService.GetBook(bookId);
        call.enqueue(new Callback<BookViewModel>() {
            @Override
            public void onResponse(Call<BookViewModel> call, Response<BookViewModel> response) {
                editTextBookName.setText(response.body().getBookName());
                editTextBookDesc.setText(response.body().getBookDetailViewModel().getBookDescription());
                editTextBookKind.setText(response.body().getBookDetailViewModel().getBookKind());
                editTextWriterName.setText(response.body().getBookDetailViewModel().getWriterName());
                editTextBookPrice.setText(String.valueOf(response.body().getBookDetailViewModel().getBookPrice()));
                if(response.body().isSales())
                {
                    checkBoxSales.setChecked(true);
                }
                if(response.body().isSwap())
                {
                    checkBoxSwap.setChecked(true);
                }
            }

            @Override
            public void onFailure(Call<BookViewModel> call, Throwable t) {
                Log.i("bookhata", "onResponse: "+t);
            }
        });
    }
}
