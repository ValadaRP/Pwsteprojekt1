package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class DokumentyFormularz1 extends AppCompatActivity {

    private CheckBox zeszytCheckBox,drabinaCheckBox,tyczkaCheckBox,tablicaGabarytowCheckBox;
    private EditText liczbaPasowEditText,liczbaNaroznikowEditText,deskiAluminioweEditText,deskiRozporoweEditText;
    private Button wyslijDokumentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumenty_formularz1);

        zeszytCheckBox = findViewById(R.id.zeszytCheckBox);
        drabinaCheckBox = findViewById(R.id.drabinaCheckBox);
        tyczkaCheckBox = findViewById(R.id.tyczkaCheckBox);
        tablicaGabarytowCheckBox = findViewById(R.id.tablicaGabarytowCheckBox);

        liczbaPasowEditText = findViewById(R.id.liczbaPasowEditText);
        liczbaNaroznikowEditText = findViewById(R.id.liczbaNaroznikowEditText);
        deskiAluminioweEditText = findViewById(R.id.deskiAluminioweEditText);
        deskiRozporoweEditText = findViewById(R.id.deskiRozporoweEditText);

        wyslijDokumentButton = findViewById(R.id.wyslijDokumentButton);

        zaznaczDomyslnie();

        wyslijDokumentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // wyslij formularz oraz dane z poprzednich intencji
            }
        });


    }

    public void zaznaczDomyslnie(){
        zeszytCheckBox.setChecked(true);
        drabinaCheckBox.setChecked(true);
        tyczkaCheckBox.setChecked(true);
        tablicaGabarytowCheckBox.setChecked(true);
    }
}