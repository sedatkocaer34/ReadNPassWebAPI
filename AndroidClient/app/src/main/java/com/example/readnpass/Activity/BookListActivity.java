package com.example.readnpass.Activity;

import android.content.Context;
import android.os.Bundle;
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
import com.example.readnpass.ViewModel.HomeItem;

import java.util.ArrayList;
import java.util.List;

public class BookListActivity extends AppCompatActivity
{
    private IRestService restService;
    private List<HomeItem> rv_list;
    private RecyclerView recyclerView;
    Context context=this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restService = ApiClient.getClient().create(IRestService.class);
        setContentView(R.layout.activity_booklist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.home_booklist);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        rv_list = new ArrayList<>();
        rv_list.add(new HomeItem("Home", R.drawable.ic_favorite_white_24dp));
        rv_list.add(new HomeItem("Dashboard", R.drawable.ic_favorite_white_24dp));
        rv_list.add(new HomeItem("Notification", R.drawable.ic_favorite_white_24dp));
        rv_list.add(new HomeItem("image", R.drawable.ic_favorite_white_24dp));
        rv_list.add(new HomeItem("Music video", R.drawable.ic_favorite_white_24dp));
        rv_list.add(new HomeItem("Settings", R.drawable.ic_settings_24));

        UserBookAdapter mAdapter = new UserBookAdapter(rv_list);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
            }
        });
    }
}
