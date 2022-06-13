package com.stuarddevapps.janoabonce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    //Menu Variables
    private BottomNavigationView bnvMenu;
    private Fragment fragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Llamadas
        initView();
        initValues();
        initListener();
    }


    //MENU BOTTOM
    private void initView(){
        bnvMenu = findViewById(R.id.bnvMenu);
    }
    private void initValues(){
        manager = getSupportFragmentManager();
        loadFirstFragment();
    }
    private void initListener(){
        bnvMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int idMenu = item.getItemId();
                switch (idMenu){
                    case R.id.menu_eventos:
                        getSupportActionBar().setTitle(getString(R.string.eventos));
                        fragment = FragmentEventos.newInstance();
                        openFragment(fragment);
                        return true;
                    case R.id.menu_directo:
                        getSupportActionBar().setTitle(getString(R.string.directos));
                        fragment = FragmentDirectos.newInstance();
                        openFragment(fragment);
                        return true;
                    case R.id.menu_config:
                        getSupportActionBar().setTitle(getString(R.string.config));
                        fragment = FragmentConfig.newInstance();
                        openFragment(fragment);
                        return true;
                }
                return false;
            }
        });
    }
    private void openFragment(Fragment fragment){
        manager.beginTransaction().
                replace(R.id.frameContainer, fragment)
                .commit();
    }
    private void loadFirstFragment(){
        getSupportActionBar().setTitle(R.string.app_name);
        fragment = FragmentEventos.newInstance();
        openFragment(fragment);
    }
}