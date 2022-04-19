package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class DokumentyFormularzCN2 extends AppCompatActivity {

    private CheckBox skrzynkaTakNie,lancuchyTakNie,podnosnikTakNie,kluczTakNie,manometrTakNie;
    private Button dalejButton10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumenty_formularz_cn2);

        skrzynkaTakNie = findViewById(R.id.skrzynkaTakNie);
        lancuchyTakNie = findViewById(R.id.lancuchyTakNie);
        podnosnikTakNie = findViewById(R.id.podnosnikTakNie);
        kluczTakNie = findViewById(R.id.kluczTakNie);
        manometrTakNie = findViewById(R.id.manometrTakNie);
        dalejButton10 = findViewById(R.id.dalejButton10);
        zaznaczWszystko();

        dalejButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DokumentyFormularzCN2.this,Dokumenty4.class);
                startActivity(intent);
            }
        });

    }

    public void zaznaczWszystko(){
        skrzynkaTakNie.setChecked(true);
        lancuchyTakNie.setChecked(true);
        podnosnikTakNie.setChecked(true);
        kluczTakNie.setChecked(true);
        manometrTakNie.setChecked(true);
    }
}