package com.stuarddevapps.janoabonce;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class FragmentDirectos extends Fragment {

    WebView directoFragment;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_directos, container, false);

        directoFragment = vista.findViewById(R.id.directoFragment);
        directoFragment.loadUrl("https://janoabonce.ga/appstream.html");
        WebSettings webSettings = directoFragment.getSettings();
        webSettings.setJavaScriptEnabled(true);

        return vista;
    }
}