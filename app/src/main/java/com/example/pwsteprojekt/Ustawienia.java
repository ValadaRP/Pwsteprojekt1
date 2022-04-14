package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Ustawienia extends AppCompatActivity {
    private Switch aSwitch;
    private ConstraintLayout view1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustawienia);

        aSwitch = findViewById(R.id.aSwitch);
        view1 = findViewById(R.id.view1);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    aSwitch.setText("Tryb ciemny");
                }else{
                    aSwitch.setText("Tryb jasny");
                }
            }
        });

    }
}