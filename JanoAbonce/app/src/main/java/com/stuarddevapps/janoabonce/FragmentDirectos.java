package com.stuarddevapps.janoabonce;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class FragmentDirectos extends Fragment {

    WebView directoFragment;
    Button btnOpen;

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

        btnOpen = vista.findViewById(R.id.btnOpen);

        directoFragment = vista.findViewById(R.id.directoFragment);
        directoFragment.loadUrl("https://janoabonce.ga/appstream.html");
        WebSettings webSettings = directoFragment.getSettings();
        webSettings.setJavaScriptEnabled(true);

        openTwitch();

        return vista;
    }


    private void openTwitch(){
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = getActivity().getPackageManager().getLaunchIntentForPackage("tv.twitch.android.app");
                if (i != null){
                    startActivity(i);
                }else
                {
                    Toast.makeText(getContext(),getString(R.string.notInstall), Toast.LENGTH_SHORT).show();
                    String url = "https://play.google.com/store/apps/details?id=tv.twitch.android.app&hl=es";
                    Uri uri = Uri.parse(url);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);


                }
             }
        });
    }

}