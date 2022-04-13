package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DokumentyCN extends AppCompatActivity {
    private EditText nrRejCiagnikaEditText, nrRejNaczepyEditText;
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
                /*
                Intent intent = new Intent(DokumentyCN.this,DokumentyCN2.class);
                intent.getExtras();
                startActivity(intent);

                 */
            }
        });

    }
}