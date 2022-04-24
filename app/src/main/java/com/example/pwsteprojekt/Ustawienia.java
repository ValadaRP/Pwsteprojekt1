package com.example.pwsteprojekt;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Ustawienia extends AppCompatActivity {
    private Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustawienia);

        aSwitch = findViewById(R.id.aSwitch);

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