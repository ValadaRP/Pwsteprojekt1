package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Wiadomosci extends AppCompatActivity {

    private Button wyslijButton;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiadomosci);
        wyslijButton = findViewById(R.id.wyslijButton);
        editTextMessage = findViewById(R.id.editTextMessage);

    }
}