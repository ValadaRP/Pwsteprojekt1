package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WiadomosciMain extends AppCompatActivity {

    private Button odebraneButton,wyslaneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiadomosci_main);

        odebraneButton = findViewById(R.id.odebraneButton);
        wyslaneButton = findViewById(R.id.wyslaneButton);

        odebraneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WiadomosciMain.this, WiadomosciOdebrane.class);
                startActivity(intent);
            }
        });
        wyslaneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WiadomosciMain.this,WiadomosciWyslane.class);
                startActivity(intent);
            }
        });

    }
}