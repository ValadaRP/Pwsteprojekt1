package com.example.pwsteprojekt;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Ustawienia extends AppCompatActivity {
    private Switch switchtryb;
    private ConstraintLayout backgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ustawienia);
        switchtryb= findViewById(R.id.switchtryb);
        backgr= findViewById(R.id.backgr);
        switchtryb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (switchtryb.isChecked())
                {
                    backgr.setBackgroundColor(Color.GRAY);
                    switchtryb.setTextColor(Color.WHITE);
                    switchtryb.setText("Tryb ciemny");
                }
                else {
                    backgr.setBackgroundColor(Color.WHITE);
                    switchtryb.setTextColor(Color.BLACK);
                    switchtryb.setText("Tryb jasny");
                }
            }
        });
    }
}