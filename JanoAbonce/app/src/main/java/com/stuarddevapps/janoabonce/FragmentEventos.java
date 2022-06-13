package com.stuarddevapps.janoabonce;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentEventos extends Fragment {


    public FragmentEventos() {
        // Required empty public constructor
    }

    public static FragmentEventos newInstance() {

        Bundle args = new Bundle();

        FragmentEventos fragment = new FragmentEventos();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_eventos, container, false);

        return vista;
    }
}