package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class DokumentyCN2 extends AppCompatActivity {
        private Button dalejButton5;
        private CheckBox wnetrzeKabinyTak,wnetrzeKabinyNie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumenty_cn2);

        dalejButton5 = findViewById(R.id.dalejButton5);
        wnetrzeKabinyTak = findViewById(R.id.wnetrzeKabinyTak);
        wnetrzeKabinyNie = findViewById(R.id.wnetrzeKabinyNie);

        wnetrzeKabinyTak.setChecked(true);

        wnetrzeKabinyNie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if(isChecked){
                    wnetrzeKabinyTak.setChecked(false);
                }
            }
        }
        );
        wnetrzeKabinyTak.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    wnetrzeKabinyNie.setChecked(false);
                }
            }
        });

        dalejButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wnetrzeKabinyTak.isChecked() == true){
                    Intent intent = new Intent(DokumentyCN2.this,DokumentyCN3.class);
                    startActivity(intent);
                }
                if(wnetrzeKabinyNie.isChecked() == true){
                    Intent intent = new Intent(DokumentyCN2.this,DokumentyZastrzezeniaCN.class);
                    startActivity(intent);
                }
            }
        });
    }

    public CheckBox getWnetrzeKabinyNie() {
        return wnetrzeKabinyNie;
    }

    public CheckBox getWnetrzeKabinyTak() {
        return wnetrzeKabinyTak;
    }
}