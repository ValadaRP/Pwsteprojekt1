package com.example.pwsteprojekt;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class Ustawienia extends AppCompatActivity {
    private Switch aSwitch;
    private EditText nrPojazduUstawienia;

    public String getNrPojazduSettings() {
        return nrPojazduSettings;
    }

    public String nrPojazduSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustawienia);

        aSwitch = findViewById(R.id.aSwitch);
        nrPojazduUstawienia = findViewById(R.id.nrPojazduUstawienia);

        if(!nrPojazduUstawienia.getText().toString().isEmpty()){
            nrPojazduSettings = nrPojazduUstawienia.getText().toString();
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    aSwitch.setText("Tryb ciemny");
                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
                }else{
                    aSwitch.setText("Tryb jasny");
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

    }
}