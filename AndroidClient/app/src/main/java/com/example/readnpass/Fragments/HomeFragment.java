package com.example.readnpass.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.readnpass.Adapter.HomeRecyclerAdapter;
import com.example.readnpass.Adapter.UserBookAdapter;
import com.example.readnpass.Interfaces.ApiClient;
import com.example.readnpass.Interfaces.IRestService;
import com.example.readnpass.R;
import com.example.readnpass.ViewModel.BookViewModel;
import com.example.readnpass.ViewModel.HomeItem;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private List<HomeItem> rv_list;
    private RecyclerView recyclerView;
    private IRestService restService;
    public HomeFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.home_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        restService = ApiClient.getClient().create(IRestService.class);
        loadBookList();
        return view;
    }

    private  void loadBookList()
    {
        Call<List<BookViewModel>> call =  restService.GetAllBook();
        call.enqueue(new Callback<List<BookViewModel>>() {
            @Override
            public void onResponse(Call<List<BookViewModel>> call, Response<List<BookViewModel>> response) {
                rv_list = new ArrayList<>();

                for (int i = 0; i <response.body().size() ; i++) {
                    rv_list.add(new HomeItem(response.body().get(i).getId(),response.body().get(i).getBookName(),response.body().get(i).getBookDetailViewModel().getBookDescription(),
                            response.body().get(i).getBookPhoto(),response.body().get(i).isSales(),response.body().get(i).isSwap()));
                }

                HomeRecyclerAdapter mAdapter = new HomeRecyclerAdapter(rv_list,getContext());
                recyclerView.setAdapter(mAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
            }

            @Override
            public void onFailure(Call<List<BookViewModel>> call, Throwable t) {
                Log.i("bookhata", "onResponse: "+t);
            }
        });
    }
}
