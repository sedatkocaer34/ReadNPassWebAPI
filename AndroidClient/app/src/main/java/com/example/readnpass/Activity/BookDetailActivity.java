package com.example.readnpass.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.viewpager.widget.ViewPager;

import com.example.readnpass.Adapter.BookDetailViewPagerAdapter;
import com.example.readnpass.Adapter.HomeRecyclerAdapter;
import com.example.readnpass.Interfaces.ApiClient;
import com.example.readnpass.Interfaces.IRestService;
import com.example.readnpass.R;
import com.example.readnpass.Response.BaseResponse;
import com.example.readnpass.ViewModel.BookClaimViewModel;
import com.example.readnpass.ViewModel.BookViewModel;
import com.example.readnpass.ViewModel.HomeItem;
import com.example.readnpass.ViewModel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookDetailActivity extends AppCompatActivity
{
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    private IRestService restService;
    String bookId;
    Button swapbutton,sellButton;
    Context context = this;
    BookDetailViewPagerAdapter viewPagerAdapter;
    TextView txttitle,txtdesc,txtauthorname,txtbookkind,txtprice;
    SharedPreferences sharedPref ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPref = this.getSharedPreferences("sharedPref",Context.MODE_PRIVATE);
        restService = ApiClient.getClient().create(IRestService.class);
        setContentView(R.layout.activity_bookdetail);
        txttitle = findViewById(R.id.txttitle);
        txtdesc = findViewById(R.id.txtdesc);
        txtauthorname = findViewById(R.id.txtauthorname);
        txtbookkind = findViewById(R.id.txtbookkind);
        txtprice = findViewById(R.id.txtprice);
        sellButton = findViewById(R.id.sellButton);
        swapbutton = findViewById(R.id.swapbutton);



        viewPager = (ViewPager) findViewById(R.id.viewPager);
        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);
        bookId=getIntent().getStringExtra("bookId");
        loadBookList();
    }

    private  void loadBookList()
    {
        Call<BookViewModel> call =  restService.GetBookDetail(bookId);
        call.enqueue(new Callback<BookViewModel>() {
            @Override
            public void onResponse(Call<BookViewModel> call, final Response<BookViewModel> response) {

                txtbookkind.setText(response.body().getBookDetailViewModel().getBookKind());
                txttitle.setText(response.body().getBookName());
                txtdesc.setText(response.body().getBookDetailViewModel().getBookDescription());
                txtauthorname.setText(response.body().getBookDetailViewModel().getWriterName());
                txtprice.setText(String.valueOf( response.body().getBookDetailViewModel().getBookPrice()));

                swapbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(response.body().isSwap())
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);

                            final EditText edittext = new EditText(context);
                            builder.setTitle("Takas İsteği Gönder");
                            builder.setMessage("Lütfen mesajınızı yazınız.");
                            builder.setView(edittext);
                            builder.setPositiveButton("Gönder", new DialogInterface.OnClickListener() {
                                public void onClick(final DialogInterface dialog, int whichButton) {
                                    //What ever you want to do with the value
                                    Editable YouEditTextValue = edittext.getText();
                                    BookClaimViewModel bookClaimViewModel = new BookClaimViewModel(response.body().getId(),response.body().getUserId(),
                                            sharedPref.getString("userId","Kayıt Yok"),YouEditTextValue.toString(),false);
                                    Call<BaseResponse<BookClaimViewModel>> call =  restService.AddBookClaim(bookClaimViewModel);
                                    call.enqueue(new Callback<BaseResponse<BookClaimViewModel>>() {
                                        @Override
                                        public void onResponse(Call<BaseResponse<BookClaimViewModel>> call, Response<BaseResponse<BookClaimViewModel>> response) {
                                            Toast.makeText(context, "Takas İsteği Gönderildi.", Toast.LENGTH_SHORT).show();
                                            dialog.dismiss();
                                        }

                                        @Override
                                        public void onFailure(Call<BaseResponse<BookClaimViewModel>> call, Throwable t) {
                                            Toast.makeText(context, "Hata Yaşandı Tekrar Deneyiniz.", Toast.LENGTH_SHORT).show();
                                            dialog.dismiss();
                                        }
                                    });
                                }
                            });

                            builder.setNegativeButton("İptal Et", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    // what ever you want to do with No option.
                                }
                            });
                            builder.show();
                        }

                        else
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);

                            builder.setTitle("Bu Kitap İçin Takas Mevcut Değildir.");
                            builder.setMessage("Kullanıcı bu kitap için takas isteği kabul etmemektedir.");

                            builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {
                                    // Do nothing but close the dialog

                                    dialog.dismiss();
                                }
                            });
                            AlertDialog alert = builder.create();
                            alert.show();
                        }

                    }

                });


                sellButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(response.body().isSales())
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);

                            final EditText edittext = new EditText(context);
                            builder.setTitle("Satın Alma İsteği Gönder");
                            builder.setMessage("Lütfen mesajınızı yazınız.");
                            builder.setView(edittext);
                            builder.setPositiveButton("Gönder", new DialogInterface.OnClickListener() {
                                public void onClick(final DialogInterface dialog, int whichButton) {
                                    //What ever you want to do with the value
                                    Editable YouEditTextValue = edittext.getText();
                                    BookClaimViewModel bookClaimViewModel = new BookClaimViewModel(response.body().getId(),response.body().getUserId(),
                                            sharedPref.getString("userId","Kayıt Yok"),YouEditTextValue.toString(),true);
                                    Call<BaseResponse<BookClaimViewModel>> call =  restService.AddBookClaim(bookClaimViewModel);
                                    call.enqueue(new Callback<BaseResponse<BookClaimViewModel>>() {
                                        @Override
                                        public void onResponse(Call<BaseResponse<BookClaimViewModel>> call, Response<BaseResponse<BookClaimViewModel>> response) {
                                            Toast.makeText(context, "Satın Alma İsteği Gönderildi.", Toast.LENGTH_SHORT).show();
                                            dialog.dismiss();
                                        }

                                        @Override
                                        public void onFailure(Call<BaseResponse<BookClaimViewModel>> call, Throwable t) {
                                            Toast.makeText(context, "Hata Yaşandı Tekrar Deneyiniz.", Toast.LENGTH_SHORT).show();
                                            dialog.dismiss();
                                        }
                                    });
                                }
                            });

                            builder.setNegativeButton("İptal Et", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    // what ever you want to do with No option.
                                }
                            });
                            builder.show();
                        }

                        else
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);

                            builder.setTitle("Bu Kitap İçin Satın Alma Mevcut Değildir.");
                            builder.setMessage("Kullanıcı bu kitap için satın alma isteği kabul etmemektedir.");

                            builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {
                                    // Do nothing but close the dialog

                                    dialog.dismiss();
                                }
                            });
                            AlertDialog alert = builder.create();
                            alert.show();
                        }

                    }

                });


                if(response.body().getBookPhotos()!=null)
                {
                    viewPagerAdapter = new BookDetailViewPagerAdapter(context,response.body().getBookPhotos());
                    viewPager.setAdapter(viewPagerAdapter);
                    dotscount = viewPagerAdapter.getCount();
                    dots = new ImageView[dotscount];
                    for(int i = 0; i < dotscount; i++){

                        dots[i] = new ImageView(context);
                        dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                        params.setMargins(8, 0, 8, 0);

                        sliderDotspanel.addView(dots[i], params);

                    }

                    dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

                    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                        }

                        @Override
                        public void onPageSelected(int position) {

                            for(int i = 0; i< dotscount; i++){
                                dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                            }

                            dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {

                        }
                    });
                }

            }

            @Override
            public void onFailure(Call<BookViewModel> call, Throwable t) {
                Log.i("bookhata", "onResponse: "+t);
            }
        });
    }

}
