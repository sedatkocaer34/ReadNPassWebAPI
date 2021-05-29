package com.example.readnpass.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.readnpass.R;

import java.util.ArrayList;

public class PhotoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Uri> arrayList;

    public PhotoAdapter(Context context, ArrayList<Uri> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = LayoutInflater.from(context);
        if (mInflater != null) {
            convertView = mInflater.inflate(R.layout.add_photo_list_items, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        Glide.with(context)
                .load(arrayList.get(position))
                .into(imageView);

        return convertView;
    }

}
