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
import androidx.appcompat.widget.Toolbar;

import com.example.readnpass.Interfaces.ApiClient;
import com.example.readnpass.Interfaces.IRestService;
import com.example.readnpass.R;
import com.example.readnpass.ViewModel.BookDetailViewModel;
import com.example.readnpass.ViewModel.BookViewModel;

public class BookAddActivity extends AppCompatActivity
{
    private IRestService restService;
    Button buttonaddbook;
    Context context = this;
    BookViewModel bookViewModel;
    EditText editTextBookName,editTextBookDesc,editTextWriterName,editTextBookKind,editTextBookPrice;
    CheckBox checkBoxSales,checkBoxSwap;
    SharedPreferences sharedPref ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookadd);
        sharedPref = this.getSharedPreferences("sharedPref",Context.MODE_PRIVATE);
        restService = ApiClient.getClient().create(IRestService.class);

        buttonaddbook = findViewById(R.id.btnaddbookbutton);
        editTextBookName = findViewById(R.id.editTextBookName);
        editTextBookDesc = findViewById(R.id.editTextBookDesc);
        editTextWriterName = findViewById(R.id.editTextWriterName);
        editTextBookKind = findViewById(R.id.editTextBookKind);
        editTextBookPrice = findViewById(R.id.editTextBookPrice);

        checkBoxSales = findViewById(R.id.checkBoxSales);
        checkBoxSwap = findViewById(R.id.checkBoxSwap);

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
                Log.i("countdatassss", "onAddBookClick: "+checkBoxSales.isChecked()+checkBoxSwap.isChecked());
                bookViewModel = new BookViewModel(editTextBookName.getText().toString(),null,new BookDetailViewModel(null,editTextBookDesc.getText().toString(),
                        editTextWriterName.getText().toString(),editTextBookKind.getText().toString(),Double.parseDouble(editTextBookPrice.getText().toString())),
                        checkBoxSales.isChecked(),checkBoxSwap.isChecked(),sharedPref.getString("userId","Kayıt Yok"),null);
                Intent intent  = new Intent(context,BookAddPhotoActivity.class);
                intent.putExtra("bookViewModel",bookViewModel);
                startActivity(intent);
                finish();
            }
        });
    }
}
