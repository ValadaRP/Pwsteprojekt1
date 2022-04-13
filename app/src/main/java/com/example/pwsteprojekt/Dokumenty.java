package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Dokumenty extends AppCompatActivity {

    private ConstraintLayout fragment;
    private EditText nrNaczepyEditText,liczbaPasowEditText, liczbaNaroznikowEditText,liczbaDesekAluEditText,liczbaDesekRozpoEditText;
    private Button ciagnikNaczepaButton,naczepaButton;
    private CheckBox naczepaTak,naczepaNie,zeszytTakNie,drabinaTakNie,tyczkaDachuTakNie,tablicaDoGabarytowTakNie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumenty);

        ciagnikNaczepaButton = findViewById(R.id.ciagnikNaczepaButton);
        naczepaButton = findViewById(R.id.naczepaButton);
        //Sama naczepa
        naczepaTak = findViewById(R.id.naczepaTak);
        naczepaNie = findViewById(R.id.naczepaNie);
        zeszytTakNie = findViewById(R.id.zeszytTakNie);
        liczbaPasowEditText= findViewById(R.id.liczbaPasowEditText);
        liczbaNaroznikowEditText= findViewById(R.id.liczbaNaroznikowEditText);
        liczbaDesekAluEditText = findViewById(R.id.liczbaDesekAluEditText);
        liczbaDesekRozpoEditText= findViewById(R.id.liczbaDesekRozpoEditText);
        drabinaTakNie = findViewById(R.id.drabinaTakNie);
        tyczkaDachuTakNie = findViewById(R.id.tyczkaDachuTakNie);
        tablicaDoGabarytowTakNie = findViewById(R.id.tablicaDoGabarytowTakNie);





        fragment = findViewById(R.id.fragment);
        fragment.setVisibility(View.INVISIBLE);
        nrNaczepyEditText = findViewById(R.id.nrNaczepyEditText);

        ciagnikNaczepaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        naczepaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.setVisibility(View.VISIBLE);
                zaznaczDomyslnie();

            }
        });


    }
    public void zaznaczDomyslnie(){
        zeszytTakNie.setChecked(true);
        drabinaTakNie.setChecked(true);
        tyczkaDachuTakNie.setChecked(true);
        tablicaDoGabarytowTakNie.setChecked(true);
    }
}