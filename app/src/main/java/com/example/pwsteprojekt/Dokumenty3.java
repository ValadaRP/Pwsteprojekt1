package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Dokumenty3 extends AppCompatActivity {

    private EditText nrNaczepyEditText;
    private Button dalejButton2;
    public String nrRejNaczepy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumenty3);

        nrNaczepyEditText = findViewById(R.id.nrNaczepyEditText);
        dalejButton2 = findViewById(R.id.dalejButton2);


        nrRejNaczepy = nrNaczepyEditText.getText().toString();

        dalejButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dokumenty3.this,Dokumenty4.class);
                //intent.getStringExtra("typ");
                //intent.getStringExtra("typ2");
                //intent.putExtra("nrRejNaczepy",nrRejNaczepy);
                startActivity(intent);
            }
        });


    }


}