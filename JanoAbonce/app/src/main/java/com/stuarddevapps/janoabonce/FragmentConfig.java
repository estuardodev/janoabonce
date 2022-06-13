package com.stuarddevapps.janoabonce;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FragmentConfig extends Fragment {

    private FirebaseAuth mAuth;
    Button iniciarSesion,redesJano,apoyajano,editorRedes,politicas,terminos,ayuda,close;
    private InterstitialAd mInterstitialAd;

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
        View vista = inflater.inflate(R.layout.fragment_config, container, false);
        MobileAds.initialize(getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });


        mAuth = FirebaseAuth.getInstance();
        iniciarSesion = vista.findViewById(R.id.iniciarSesion);
        redesJano = vista.findViewById(R.id.redesJano);
        apoyajano = vista.findViewById(R.id.apoyajano);
        editorRedes = vista.findViewById(R.id.editorRedes);
        politicas = vista.findViewById(R.id.politicas);
        terminos = vista.findViewById(R.id.terminos);
        ayuda = vista.findViewById(R.id.ayuda);
        close = vista.findViewById(R.id.close);

        setAds();
        return vista;
    }



    private void setAds(){
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(getContext(),"ca-app-pub-6691938542138083/1269845251", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        mInterstitialAd = null;
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){

            iniciarSesion.setText("Cerrar Sesion");
            iniciarSesion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mInterstitialAd!=null){
                        mInterstitialAd.show(getActivity());
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                FirebaseAuth.getInstance().signOut();
                                Intent i = new Intent(getActivity(), MainActivity.class);
                                startActivity(i);
                            }

                        });

                    }


                }
            });

        }else{
            iniciarSesion.setText("Iniciar Sesion");
            iniciarSesion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getActivity(), Login.class);
                    startActivity(i);
                }
            });
        }
    }
}