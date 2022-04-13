package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Dokumenty extends AppCompatActivity {




    private Button dalejButton;
    private CheckBox odbierajacyTakNie,zdajacyTakNie;
    String typ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumenty);

        dalejButton = findViewById(R.id.dalejButton);
        odbierajacyTakNie = findViewById(R.id.odbierajacyTakNie);
        zdajacyTakNie = findViewById(R.id.zdajacyTakNie);


        odbierajacyTakNie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if(isChecked){
                    typ = "Odbierajacy";
                    zdajacyTakNie.setChecked(false);
                }
            }
        }
        );
        zdajacyTakNie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    typ = "Zdajacy";
                    odbierajacyTakNie.setChecked(false);
                }
            }
        });

        dalejButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent  intent = new Intent(Dokumenty.this, Dokumenty2.class);
                intent.putExtra("typ", typ);
                startActivity(intent);
            }
        });


    }

}