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

import com.example.readnpass.Adapter.HomeRecyclerAdapter;
import com.example.readnpass.Adapter.UserBookAdapter;
import com.example.readnpass.Interfaces.ApiClient;
import com.example.readnpass.Interfaces.IRestService;
import com.example.readnpass.R;
import com.example.readnpass.ViewModel.BookViewModel;
import com.example.readnpass.ViewModel.HomeItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookListActivity extends AppCompatActivity
{
    private IRestService restService;
    private List<HomeItem> rv_list;
    private RecyclerView recyclerView;
    Context context=this;
    String UserId;
    SharedPreferences sharedPref ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restService = ApiClient.getClient().create(IRestService.class);
        sharedPref = this.getSharedPreferences("sharedPref",Context.MODE_PRIVATE);
        setContentView(R.layout.activity_booklist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.home_booklist);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        UserId=    sharedPref.getString("userId","Kayıt Yok");


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
        Call<List<BookViewModel>> call =  restService.GetUserBook(UserId);
        call.enqueue(new Callback<List<BookViewModel>>() {
            @Override
            public void onResponse(Call<List<BookViewModel>> call, Response<List<BookViewModel>> response) {
                rv_list = new ArrayList<>();
                Log.i("responsebody", "onResponse: "+response.body());
                if(response.body()!=null)
                {
                    for (int i = 0; i <response.body().size() ; i++) {
                        rv_list.add(new HomeItem(response.body().get(i).getId(),response.body().get(i).getBookName(),response.body().get(i).getBookDetailViewModel().getBookDescription(),
                                response.body().get(i).getBookPhoto(),response.body().get(i).isSales(),response.body().get(i).isSwap()));
                    }
                }


                UserBookAdapter mAdapter = new UserBookAdapter(rv_list,context);
                recyclerView.setAdapter(mAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
            }

            @Override
            public void onFailure(Call<List<BookViewModel>> call, Throwable t) {
                Log.i("bookhata", "onResponse: "+t);
            }
        });
    }
}
