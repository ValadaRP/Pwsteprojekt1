package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class Dokumenty4 extends AppCompatActivity {
    private CheckBox naczepaOdbiorTak,naczepaOdbiorNie;
    private Button dalejButton3;
    DokumentyCN3 dokumentyCN3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumenty4);

        naczepaOdbiorTak = findViewById(R.id.naczepaOdbiorTak);
        naczepaOdbiorNie = findViewById(R.id.naczepaOdbiorNie);
        dalejButton3 = findViewById(R.id.dalejButton3);
        naczepaOdbiorTak.setChecked(true);

        naczepaOdbiorNie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if(isChecked){
                    naczepaOdbiorTak.setChecked(false);
                }
            }
        }
        );
        naczepaOdbiorTak.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    naczepaOdbiorNie.setChecked(false);
                }
            }
        });

        dalejButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(naczepaOdbiorTak.isChecked() == true){
                    Intent intent = new Intent(Dokumenty4.this,DokumentyFormularz1.class);
                    startActivity(intent);
                }
                if(naczepaOdbiorNie.isChecked() == true){
                    Intent intent = new Intent(Dokumenty4.this,DokumentyZastrzezenia.class);
                    startActivity(intent);
                }
            }
        });
    }
}