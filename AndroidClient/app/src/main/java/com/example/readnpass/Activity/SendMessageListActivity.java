package com.example.readnpass.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readnpass.Adapter.SendMessageAdapter;
import com.example.readnpass.Adapter.UserBookAdapter;
import com.example.readnpass.Interfaces.ApiClient;
import com.example.readnpass.Interfaces.IRestService;
import com.example.readnpass.R;
import com.example.readnpass.ViewModel.BookClaimViewModel;
import com.example.readnpass.ViewModel.BookViewModel;
import com.example.readnpass.ViewModel.HomeItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendMessageListActivity extends AppCompatActivity {

    private IRestService restService;
    private List<BookClaimViewModel> rv_list;
    private RecyclerView recyclerView;
    Context context=this;
    String UserId;
    SharedPreferences sharedPref ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message_list);
        restService = ApiClient.getClient().create(IRestService.class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.home_booklist);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        sharedPref = this.getSharedPreferences("sharedPref",Context.MODE_PRIVATE);
        UserId=sharedPref.getString("userId","Kayıt Yok");


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
            }
        });
        loadBookList();
    }

    private  void loadBookList()
    {
        Call<List<BookClaimViewModel>> call =  restService.GetUserSendClaim(UserId);
        call.enqueue(new Callback<List<BookClaimViewModel>>() {
            @Override
            public void onResponse(Call<List<BookClaimViewModel>> call, Response<List<BookClaimViewModel>> response) {
                rv_list = new ArrayList<>();
                rv_list =response.body();

                SendMessageAdapter mAdapter = new SendMessageAdapter(rv_list,context);
                recyclerView.setAdapter(mAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
            }

            @Override
            public void onFailure(Call<List<BookClaimViewModel>> call, Throwable t) {
                Log.i("bookhata", "onResponse: "+t);
            }
        });
    }

}
