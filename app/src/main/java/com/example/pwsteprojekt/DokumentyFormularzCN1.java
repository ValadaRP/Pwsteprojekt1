package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class DokumentyFormularzCN1 extends AppCompatActivity {

    private Button dalejButton9;
    private CheckBox dowodRejestracyjnyPojazduTakNie,certyfikatEuroTakNie,upowaznienieTakNie,kartaShellTakNie,kartaRevolutTakNie,licencjaTakNie,ubezpieczenieTakNie,pozwolenieTakNie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumenty_formularz_cn1);

        dowodRejestracyjnyPojazduTakNie = findViewById(R.id.dowodRejestracyjnyPojazduTakNie);
        certyfikatEuroTakNie = findViewById(R.id.certyfikatEuroTakNie);
        upowaznienieTakNie = findViewById(R.id.upowaznienieTakNie);
        kartaShellTakNie = findViewById(R.id.kartaShellTakNie);
        kartaRevolutTakNie = findViewById(R.id.kartaRevolutTakNie);
        licencjaTakNie = findViewById(R.id.licencjaTakNie);
        ubezpieczenieTakNie = findViewById(R.id.ubezpieczenieTakNie);
        pozwolenieTakNie = findViewById(R.id.pozwolenieTakNie);
        dalejButton9 = findViewById(R.id.dalejButton9);

        zaznaczDomyslnie();

        dalejButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(DokumentyFormularzCN1.this, DokumentyFormularzCN2.class);
               startActivity(intent);
            }
        });
    }

    public void zaznaczDomyslnie(){
        dowodRejestracyjnyPojazduTakNie.setChecked(true);
        certyfikatEuroTakNie.setChecked(true);
        upowaznienieTakNie.setChecked(true);
        kartaShellTakNie.setChecked(true);
        kartaRevolutTakNie.setChecked(true);
        licencjaTakNie.setChecked(true);
        ubezpieczenieTakNie.setChecked(true);
        pozwolenieTakNie.setChecked(true);
    }
}