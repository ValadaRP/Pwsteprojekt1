package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class DokumentyCN3 extends AppCompatActivity {

    private Button dalejButton6;
    private CheckBox pojazdZewnatrzTak, pojazdZewnatrzNie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumenty_cn3);

        dalejButton6 = findViewById(R.id.dalejButton6);
        pojazdZewnatrzTak = findViewById(R.id.pojazdZewnatrzTak);
        pojazdZewnatrzNie = findViewById(R.id.pojazdZewnatrzNie);
        pojazdZewnatrzTak.setChecked(true);

        pojazdZewnatrzNie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if(isChecked){
                    pojazdZewnatrzTak.setChecked(false);
                }
            }
        }
        );
        pojazdZewnatrzTak.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    pojazdZewnatrzNie.setChecked(false);
                }
            }
        });

        dalejButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pojazdZewnatrzTak.isChecked() == true){
                    Intent intent = new Intent(DokumentyCN3.this,DokumentyFormularzCN1.class);
                    startActivity(intent);
                }
                if(pojazdZewnatrzNie.isChecked() == true){
                    Intent intent = new Intent(DokumentyCN3.this,DokumentyZastrzezeniaCN2.class);
                    startActivity(intent);
                }
            }
        });


    }

    public CheckBox getPojazdZewnatrzTak() {
        return pojazdZewnatrzTak;
    }

    public CheckBox getPojazdZewnatrzNie() {
        return pojazdZewnatrzNie;
    }
}