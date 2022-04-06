package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Switch;

public class Ustawienia extends AppCompatActivity {
    private Switch aSwitch;
    private ConstraintLayout view1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        aSwitch = findViewById(R.id.switch_ciemny);
        view1 = findViewById(R.id.view1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustawienia);
    }
}