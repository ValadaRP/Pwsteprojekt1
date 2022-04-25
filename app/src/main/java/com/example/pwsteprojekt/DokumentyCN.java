package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DokumentyCN extends AppCompatActivity {
    private EditText nrRejCiagnikaEditText, nrRejNaczepyEditText;

    public String getNrRejCiagnik() {
        return nrRejCiagnik;
    }

    public String getNrRejNaczepy() {
        return nrRejNaczepy;
    }

    public String nrRejCiagnik, nrRejNaczepy;
    Button dalejButtonCN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumenty_cn);

        nrRejCiagnikaEditText = findViewById(R.id.nrRejCiagnikaEditText);
        nrRejNaczepyEditText = findViewById(R.id.nrRejNaczepyEditText);
        dalejButtonCN = findViewById(R.id.dalejButtonCN);



        dalejButtonCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(nrRejCiagnikaEditText.getText().toString().isEmpty() || nrRejNaczepyEditText.getText().toString().isEmpty()){
                    Toast.makeText(DokumentyCN.this, "Prosze wpisać nr rejestracyjny ciagnika i naczepy", Toast.LENGTH_SHORT).show();
                }else{
                    nrRejCiagnik = nrRejCiagnikaEditText.getText().toString();
                    nrRejNaczepy = nrRejNaczepyEditText.getText().toString();
                    Intent intent = new Intent(DokumentyCN.this,DokumentyCN2.class);
                    startActivity(intent);
                }
            }
        });

    }
}