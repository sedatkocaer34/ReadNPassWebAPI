package com.example.readnpass.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.readnpass.Activity.BookAddActivity;
import com.example.readnpass.Activity.BookListActivity;
import com.example.readnpass.Activity.LoginActivity;
import com.example.readnpass.Activity.UserProfileUpdateActivity;
import com.example.readnpass.R;
import com.example.readnpass.ViewModel.UserViewModel;

public class ProfileFragment extends Fragment {
    UserViewModel userViewModel;
    int LAUNCH_SECOND_ACTIVITY = 1;
    TextView textViewNameSurname,txtemail,txtadsoyad,logoutbutton;
    SharedPreferences sharedPref ;
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
        logoutbutton = view.findViewById(R.id.logoutbutton);
        final ImageView imgUserphoto = view.findViewById(R.id.imgUserphoto);

        textViewNameSurname =view.findViewById(R.id.tv_name);
         txtemail =view.findViewById(R.id.txtemail);
         txtadsoyad =view.findViewById(R.id.txtadsoyad);

        txtadsoyad.setText(userViewModel.getName()+" "+userViewModel.getSurName());
        txtemail.setText(userViewModel.getEmail());
        Glide.with(getActivity())
                .load(userViewModel.getDefaultUserProfiePhoto())
                .asBitmap().centerCrop().into(new BitmapImageViewTarget(imgUserphoto) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imgUserphoto.setImageDrawable(circularBitmapDrawable);
            }
        });

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
                intent.putExtra("userId",userViewModel.getId());
                startActivity(intent);
            }
        });
        btnupdateprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), UserProfileUpdateActivity.class);
                intent.putExtra("userId",userViewModel.getId());
                startActivityForResult(intent, LAUNCH_SECOND_ACTIVITY);
            }
        });

        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPref = getActivity().getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.remove("userId");
                editor.commit();

                Intent i = new Intent(getActivity(), LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                UserViewModel userModel = (UserViewModel) data.getSerializableExtra("userModel");

                textViewNameSurname.setText(userModel.getName()+" "+userModel.getSurName());
                txtemail.setText(userModel.getEmail());
                txtadsoyad.setText(userModel.getName()+" "+userModel.getSurName());
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                // Write your code if there's no result
            }
        }
    }
}
