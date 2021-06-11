package com.example.readnpass.Activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.readnpass.Adapter.FileUtils;
import com.example.readnpass.Adapter.PhotoAdapter;
import com.example.readnpass.Interfaces.ApiClient;
import com.example.readnpass.Interfaces.IRestService;
import com.example.readnpass.R;
import com.example.readnpass.Response.BaseResponse;
import com.example.readnpass.ViewModel.BookPhotoViewModel;
import com.example.readnpass.ViewModel.BookViewModel;
import com.example.readnpass.ViewModel.UserViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookAddPhotoActivity extends AppCompatActivity {
    private static final String TAG = BookAddPhotoActivity.class.getSimpleName();

    private IRestService restService;
    private ProgressBar mProgressBar;
    private Button btnChoose;
    GridView gridView;
    private ArrayList<Uri> arrayList;
    BookViewModel bookViewModel;
    private final int REQUEST_CODE_PERMISSIONS  = 1;
    private final int REQUEST_CODE_READ_STORAGE = 2;
    Context context = this;
    ProgressBar   pgsBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_add_book_photo);
        bookViewModel = (BookViewModel) getIntent().getSerializableExtra("bookViewModel");
        gridView = (GridView) findViewById(R.id.grid_view);
        mProgressBar = findViewById(R.id.progressBar);
        pgsBar = (ProgressBar) findViewById(R.id.progress_loader);
        pgsBar.setVisibility(View.GONE);
        btnChoose = findViewById(R.id.btnChoose);
        restService = ApiClient.getClient().create(IRestService.class);
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display the file chooser dialog
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    BookAddPhotoActivity.this.askForPermission();
                } else {
                    BookAddPhotoActivity.this.showChooser();
                }
            }
        });
        arrayList = new ArrayList<>();
    }

    public void onAddBookClick(View view)
    {
        showLoading();
       List<MultipartBody.Part> bookPhotoViewModel = new ArrayList<>();
        if (arrayList != null) {
            // create part for file (photo, video, ...)
            for (int i = 0; i < arrayList.size(); i++) {
                bookPhotoViewModel.add(prepareFilePart("image"+i, arrayList.get(i)));
            }
        }

        Call<BaseResponse<BookViewModel>> call =  restService.AddBook(bookPhotoViewModel,bookViewModel);
        call.enqueue(new Callback<BaseResponse<BookViewModel>>() {
            @Override
            public void onResponse(Call<BaseResponse<BookViewModel>> call, Response<BaseResponse<BookViewModel>> response) {
                Log.i("countdata", "onAddBookClick: "+response.body().isSuccess());
                if(response.body().isSuccess())
                {
                    hideLoading();
                    Intent intent  = new Intent(context,SuccesActivity.class);
                    startActivity(intent);
                    finish();
                }

            }

            @Override
            public void onFailure(Call<BaseResponse<BookViewModel>> call, Throwable t) {
                Log.i("bookhata", "onResponse: "+t);
                Toast.makeText(context, "Hata Yaşandı Tekrar Deneyiniz", Toast.LENGTH_SHORT).show();
                hideLoading();
            }
        });
    }

    private void showChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_CODE_READ_STORAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_READ_STORAGE) {
                if (resultData != null) {
                    if (resultData.getClipData() != null) {
                        int count = resultData.getClipData().getItemCount();
                        int currentItem = 0;
                        while (currentItem < count) {
                            Uri imageUri = resultData.getClipData().getItemAt(currentItem).getUri();
                            currentItem = currentItem + 1;

                            Log.d("Uri Selected", imageUri.toString());

                            try {
                                arrayList.add(imageUri);
                                PhotoAdapter mAdapter = new PhotoAdapter(BookAddPhotoActivity.this, arrayList);
                                gridView.setAdapter(mAdapter);

                            } catch (Exception e) {
                                Log.e(TAG, "File select error", e);
                            }
                        }
                    } else if (resultData.getData() != null) {

                        final Uri uri = resultData.getData();
                        Log.i(TAG, "Uri = " + uri.toString());

                        try {
                            arrayList.add(uri);
                            PhotoAdapter mAdapter = new PhotoAdapter(BookAddPhotoActivity.this, arrayList);
                            gridView.setAdapter(mAdapter);

                        } catch (Exception e) {
                            Log.e(TAG, "File select error", e);
                        }
                    }
                }
            }
        }
    }

    private void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        btnChoose.setEnabled(false);
    }

    private void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
        btnChoose.setEnabled(true);
    }

    private void askForPermission() {
        if ((ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) +
                ContextCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE))
                != PackageManager.PERMISSION_GRANTED) {
            /* Ask for permission */
            // need to request permission
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE) ||
                    ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                Snackbar.make(this.findViewById(android.R.id.content),
                        "Please grant permissions to write data in sdcard",
                        Snackbar.LENGTH_INDEFINITE).setAction("ENABLE",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ActivityCompat.requestPermissions(BookAddPhotoActivity.this,
                                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                                Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                        REQUEST_CODE_PERMISSIONS);
                            }
                        }).show();
            } else {
                /* Request for permission */
                ActivityCompat.requestPermissions(BookAddPhotoActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_PERMISSIONS);
            }

        } else {
            showChooser();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
                showChooser();
            } else {
                // Permission Denied
                Toast.makeText(BookAddPhotoActivity.this, "Permission Denied!", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void showMessageOKCancel(DialogInterface.OnClickListener okListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(BookAddPhotoActivity.this);
        final AlertDialog dialog = builder.setMessage("You need to grant access to Read External Storage")
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create();

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(
                        ContextCompat.getColor(BookAddPhotoActivity.this, android.R.color.holo_blue_light));
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(
                        ContextCompat.getColor(BookAddPhotoActivity.this, android.R.color.holo_red_light));
            }
        });

        dialog.show();
    }

    @NonNull
    private MultipartBody.Part prepareFilePart(String partName, Uri fileUri) {
        // use the FileUtils to get the actual file by uri
        File file = com.example.readnpass.Adapter.FileUtils.getFile(this, fileUri);

        // create RequestBody instance from file
        RequestBody requestFile = RequestBody.create (MediaType.parse(FileUtils.MIME_TYPE_IMAGE), file);

        // MultipartBody.Part is used to send also the actual file name
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
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