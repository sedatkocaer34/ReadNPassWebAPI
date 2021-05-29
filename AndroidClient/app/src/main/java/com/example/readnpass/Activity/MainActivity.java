package com.example.readnpass.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import com.example.readnpass.Fragments.HomeFragment;
import com.example.readnpass.Fragments.MessageFragment;
import com.example.readnpass.Fragments.ProfileFragment;
import com.example.readnpass.R;
import com.example.readnpass.ViewModel.UserViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    final Fragment fragmentHome    = new HomeFragment();
    final Fragment fragmentMessage = new MessageFragment();
    Fragment fragmentProfile ;
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragmentHome;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserViewModel userModel = (UserViewModel) getIntent().getSerializableExtra("userModel");

        Toolbar toolbar = findViewById(R.id.main_tool_bar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        bottomNavigationView.setSelectedItemId(R.id.action_schedules);
        fragmentProfile = new ProfileFragment(userModel);
        fm.beginTransaction().add(R.id.main_container, fragmentProfile, "3").hide(fragmentProfile).commit();
        fm.beginTransaction().add(R.id.main_container, fragmentMessage, "2").hide(fragmentMessage).commit();
        fm.beginTransaction().add(R.id.main_container,fragmentHome, "1").commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_toolbar_menu,menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.ic_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.ic_search:
                Toast.makeText(context, "Hey", Toast.LENGTH_SHORT).show();
                fm.beginTransaction().hide(active).show(fragmentHome).commit();
                active = fragmentHome;
                break;
            case R.id.ic_setting:
                Intent intent = new Intent(context,MessageActivity.class);
                context.startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_favorites:
                    fm.beginTransaction().hide(active).show(fragmentMessage).commit();
                    active = fragmentMessage;
                    return true;
                case R.id.action_schedules:
                    fm.beginTransaction().hide(active).show(fragmentHome).commit();
                    active = fragmentHome;
                    return true;
                case R.id.action_music:
                    fm.beginTransaction().hide(active).show(fragmentProfile).commit();
                    active = fragmentProfile;
                    return true;
            }
            return false;
        }
    };


}