package com.example.readnpass.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.readnpass.R;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class SuccesActivity extends AppCompatActivity {

    CircularProgressButton circularProgressButton;
    Context context = this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        circularProgressButton =findViewById(R.id.mainbutton);
        circularProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}
