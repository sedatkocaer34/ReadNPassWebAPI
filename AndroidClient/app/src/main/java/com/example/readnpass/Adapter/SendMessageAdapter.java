package com.example.readnpass.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.readnpass.Activity.BookUpdateActivity;
import com.example.readnpass.Interfaces.ApiClient;
import com.example.readnpass.Interfaces.IRestService;
import com.example.readnpass.R;
import com.example.readnpass.Response.BaseResponse;
import com.example.readnpass.ViewModel.BookClaimViewModel;
import com.example.readnpass.ViewModel.HomeItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendMessageAdapter  extends RecyclerView.Adapter<SendMessageAdapter.ViewHolder> {


    public List<BookClaimViewModel> home_list;
    public Context context;
    private IRestService restService;

    public SendMessageAdapter(List<BookClaimViewModel> list, Context context) {
        this.home_list = list;
        this.context = context;
        this.restService = restService = ApiClient.getClient().create(IRestService.class);
    }

    @NonNull
    @Override
    public SendMessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new SendMessageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SendMessageAdapter.ViewHolder holder, final int position) {
        holder.kullaniciadi.setText(home_list.get(position).getUserViewModel().getName()+" "+home_list.get(position).getUserViewModel().getSurName());
        holder.kitapisim.setText(home_list.get(position).getBookViewModel().getBookName());
        holder.aciklama.setText(home_list.get(position).getExplain());
        if(home_list.get(position).getSales())
        {
            holder.teklifturu.setText("Satılık");
        }
        else{
            holder.teklifturu.setText("Takas");
        }

        Glide.with(context).load(home_list.get(position).getUserViewModel().getDefaultUserProfiePhoto()).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.userphoto) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.userphoto.setImageDrawable(circularBitmapDrawable);
            }
        });

    }

    @Override
    public int getItemCount() {
        return home_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        private TextView kullaniciadi, kitapisim, aciklama, teklifturu;
        private ImageView userphoto;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            kullaniciadi = mView.findViewById(R.id.kullaniciadi);
            kitapisim = mView.findViewById(R.id.kitapisim);
            aciklama = mView.findViewById(R.id.aciklama);
            teklifturu = mView.findViewById(R.id.teklifturutitle);
            userphoto = mView.findViewById(R.id.bookphoto);
        }
    }
}
