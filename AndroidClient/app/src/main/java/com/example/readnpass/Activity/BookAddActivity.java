package com.example.readnpass.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.readnpass.Interfaces.ApiClient;
import com.example.readnpass.Interfaces.IRestService;
import com.example.readnpass.R;

public class BookAddActivity extends AppCompatActivity
{
    private IRestService restService;
    Button buttonaddbook;
    Context context = this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restService = ApiClient.getClient().create(IRestService.class);

        setContentView(R.layout.activity_bookadd);
        buttonaddbook = findViewById(R.id.btnaddbookbutton);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
            }
        });

        buttonaddbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(context,BookAddPhotoActivity.class);
                startActivity(intent);
            }
        });
    }
}
