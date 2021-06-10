package com.example.readnpass.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.readnpass.Activity.BookDetailActivity;
import com.example.readnpass.Models.BookDetail;
import com.example.readnpass.R;
import com.example.readnpass.ViewModel.HomeItem;
import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {
    public List<HomeItem> home_list;
    public Context context;

    public HomeRecyclerAdapter(List<HomeItem> list, Context context) {
        this.home_list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerAdapter.ViewHolder holder, final int position) {
        holder.title.setText(home_list.get(position).getTitle());
        holder.desc.setText(home_list.get(position).getDesc());
        Log.i("gelenfoto", "onBindViewHolder: "+home_list.get(position).getPhoto());
        if(home_list.get(position).getPhoto()!=null)
        {
            Glide.with(context).load(home_list.get(position).getPhoto()).into(holder.bookphoto);
        }
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
        holder.homeviewitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BookDetailActivity.class);
                intent.putExtra("bookId",home_list.get(position).getId());
                context.startActivity(intent);
            }
        });
        //holder.image.setImageResource(id);
    }

    @Override
    public int getItemCount() {
        return home_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        private TextView desc,title;
        private ImageView takas,satilik,bookphoto;
        RelativeLayout homeviewitem;
        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            title = mView.findViewById(R.id.title);
            desc = mView.findViewById(R.id.desc);
            bookphoto = mView.findViewById(R.id.bookphoto);
            takas = mView.findViewById(R.id.imgTakas);
            satilik = mView.findViewById(R.id.imgsatilik);
            homeviewitem = mView.findViewById(R.id.homeviewitem);
        }
    }
}
