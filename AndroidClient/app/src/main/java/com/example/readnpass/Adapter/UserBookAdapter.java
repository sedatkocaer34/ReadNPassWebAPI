package com.example.readnpass.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.readnpass.Activity.BookUpdateActivity;
import com.example.readnpass.Interfaces.ApiClient;
import com.example.readnpass.Interfaces.IRestService;
import com.example.readnpass.R;
import com.example.readnpass.Response.BaseResponse;
import com.example.readnpass.ViewModel.BookViewModel;
import com.example.readnpass.ViewModel.HomeItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserBookAdapter extends RecyclerView.Adapter<UserBookAdapter.ViewHolder> {

    public List<HomeItem> home_list;
    public Context context;
    private IRestService restService;
    public UserBookAdapter(List<HomeItem> list,Context context) {
        this.home_list = list;
        this.context = context;
        this.restService =restService = ApiClient.getClient().create(IRestService.class);
    }

    @NonNull
    @Override
    public UserBookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_book_list_item, parent, false);
        return new UserBookAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserBookAdapter.ViewHolder holder, final int position) {
        holder.title.setText(home_list.get(position).getTitle());
        holder.desc.setText(home_list.get(position).getDesc());
        Log.i("gelenfoto", "onBindViewHolder: "+home_list.get(position).getPhoto());
        Glide.with(context).load(home_list.get(position).getPhoto()).into(holder.bookphoto);
        if(home_list.get(position).getSatilik())
        {
            holder.satilik.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_check_16));
        }
        else
        {
            holder.satilik.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_baseline_cancel_24));
        }
        if(home_list.get(position).getTakas())
        {
            holder.takas.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_check_16));
        }
        else
        {
            holder.takas.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_baseline_cancel_24));
        }

        holder.updateicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BookUpdateActivity.class);
                intent.putExtra("bookId",home_list.get(position).getId());

                context.startActivity(intent);
            }
        });
        holder.removeicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle("Kitabı Sil");
                builder.setMessage("Kitabı silmek istediğinizden eminmisiniz?");

                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                        Call<BaseResponse<Boolean>> call =  restService.DeleteBook(home_list.get(position).getId());
                        call.enqueue(new Callback<BaseResponse<Boolean>>() {
                            @Override
                            public void onResponse(Call<BaseResponse<Boolean>> call, Response<BaseResponse<Boolean>> response) {
                                if(response.body().isSuccess())
                                {
                                    home_list.remove(home_list.get(position));
                                    notifyDataSetChanged();
                                }
                                else
                                {
                                    Toast.makeText(context, "Hata Yaşandı", Toast.LENGTH_SHORT).show();
                                }

                            }

                            @Override
                            public void onFailure(Call<BaseResponse<Boolean>> call, Throwable t) {
                                Log.i("bookhata", "onResponse: "+t);
                                Toast.makeText(context, "Hata Yaşandı", Toast.LENGTH_SHORT).show();
                            }
                        });
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return home_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        private TextView desc,title,removeicon,updateicon;
        private ImageView image,takas,satilik,bookphoto;
        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            title = mView.findViewById(R.id.title);
            desc = mView.findViewById(R.id.desc);
            image = mView.findViewById(R.id.avatar);
            takas = mView.findViewById(R.id.imgTakas);
            satilik = mView.findViewById(R.id.imgsatilik);
            removeicon = mView.findViewById(R.id.removeicon);
            updateicon = mView.findViewById(R.id.updateicon);
            bookphoto = mView.findViewById(R.id.bookphoto);
        }
    }
}
