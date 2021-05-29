package com.example.readnpass.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readnpass.R;
import com.example.readnpass.ViewModel.HomeItem;

import java.util.List;

public class UserBookAdapter extends RecyclerView.Adapter<UserBookAdapter.ViewHolder> {

    public List<HomeItem> home_list;

    public UserBookAdapter(List<HomeItem> list) {
        this.home_list = list;
    }

    @NonNull
    @Override
    public UserBookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        return new UserBookAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserBookAdapter.ViewHolder holder, int position) {
        int id = home_list.get(position).getId();
        String desc = home_list.get(position).getDesc();
        holder.desc.setText(desc);
    }

    @Override
    public int getItemCount() {
        return home_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        private TextView desc;
        private ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            desc = mView.findViewById(R.id.title);
            image = mView.findViewById(R.id.avatar);
        }
    }
}
