package com.example.readnpass.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.readnpass.Activity.BookAddActivity;
import com.example.readnpass.Activity.BookListActivity;
import com.example.readnpass.Activity.UserProfileUpdateActivity;
import com.example.readnpass.R;
import com.example.readnpass.ViewModel.UserViewModel;

public class ProfileFragment extends Fragment {
    UserViewModel userViewModel;
    public ProfileFragment(UserViewModel _userViewModel)
    {
        this.userViewModel=_userViewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup  view = (ViewGroup)inflater.inflate(R.layout.fragment_profile, container, false);
        RelativeLayout btnaddBook = view.findViewById(R.id.btnaddbook);
        RelativeLayout btnlibrary = view.findViewById(R.id.btnaddlibrary);
        ImageView btnupdateprofile = view.findViewById(R.id.btnupdateprofile);

        TextView textViewNameSurname =view.findViewById(R.id.tv_name);
        TextView txtemail =view.findViewById(R.id.txtemail);
        TextView txtadsoyad =view.findViewById(R.id.txtadsoyad);

        txtadsoyad.setText(userViewModel.getName()+" "+userViewModel.getSurName());
        txtemail.setText(userViewModel.getEmail());
        textViewNameSurname.setText(userViewModel.getName()+" "+userViewModel.getSurName());
        btnaddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BookAddActivity.class);
                startActivity(intent);
            }
        });
        btnlibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BookListActivity.class);
                startActivity(intent);
            }
        });
        btnupdateprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserProfileUpdateActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
