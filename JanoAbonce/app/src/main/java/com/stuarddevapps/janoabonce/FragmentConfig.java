package com.stuarddevapps.janoabonce;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentConfig extends Fragment {

    public FragmentConfig() {
        // Required empty public constructor
    }

    public static FragmentConfig newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentConfig fragment = new FragmentConfig();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_config, container, false);
        return vista;
    }
}