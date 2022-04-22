package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    private Button button_usterka,button_wiadomosci,button_zlecenia,button_mapy,button_dokumenty,button_ustawienia;
    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_usterka = findViewById(R.id.button_usterka);
        button_wiadomosci = findViewById(R.id.button_wiadomosci);
        button_zlecenia = findViewById(R.id.button_zlecenia);
        button_mapy = findViewById(R.id.button_mapy);
        button_dokumenty = findViewById(R.id.button_dokumenty);
        button_ustawienia = findViewById(R.id.button_ustawienia);





        button_usterka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TestDB.class);
                startActivity(intent);
            }
        });
        button_wiadomosci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WiadomosciMain.class);
                startActivity(intent);
            }
        });
        button_zlecenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Zlecenia.class);
                startActivity(intent);
            }
        });
        button_mapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Mapy.class);
                startActivity(intent);

            }
        });
        button_dokumenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Dokumenty.class);
                startActivity(intent);
            }
        });
        button_ustawienia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Ustawienia.class);
                startActivity(intent);
            }
        });
    }

}