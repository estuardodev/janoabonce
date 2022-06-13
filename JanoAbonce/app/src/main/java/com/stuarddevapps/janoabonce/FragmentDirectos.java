package com.stuarddevapps.janoabonce;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentDirectos extends Fragment {

    public FragmentDirectos() {
        // Required empty public constructor
    }

    public static FragmentDirectos newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentDirectos fragment = new FragmentDirectos();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_directos, container, false);
        return vista;
    }
}