package com.example.readnpass.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.readnpass.Adapter.HomeRecyclerAdapter;
import com.example.readnpass.R;
import com.example.readnpass.ViewModel.HomeItem;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<HomeItem> rv_list;
    private RecyclerView recyclerView;

    public HomeFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.home_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        rv_list = new ArrayList<>();
        rv_list.add(new HomeItem("Home", R.drawable.ic_favorite_white_24dp));
        rv_list.add(new HomeItem("Dashboard", R.drawable.ic_favorite_white_24dp));
        rv_list.add(new HomeItem("Notification", R.drawable.ic_favorite_white_24dp));
        rv_list.add(new HomeItem("image", R.drawable.ic_favorite_white_24dp));
        rv_list.add(new HomeItem("Music video", R.drawable.ic_favorite_white_24dp));
        rv_list.add(new HomeItem("Settings", R.drawable.ic_settings_24));

        HomeRecyclerAdapter mAdapter = new HomeRecyclerAdapter(rv_list);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }
}
