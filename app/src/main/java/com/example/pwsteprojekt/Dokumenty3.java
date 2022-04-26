package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dokumenty3 extends AppCompatActivity {

    private EditText nrNaczepyEditText;
    private Button dalejButton2;

    public String getNrRejNaczepy() {
        return nrRejNaczepy;
    }

    public String nrRejNaczepy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumenty3);

        nrNaczepyEditText = findViewById(R.id.nrNaczepyEditText);
        dalejButton2 = findViewById(R.id.dalejButton2);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null){
            String zdaj = (String) b.get("typ");
            nrNaczepyEditText.setText(zdaj);
        }else{
            nrNaczepyEditText.setText("Nie ma zadnych extra");
        }


        dalejButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nrNaczepyEditText.getText().toString().isEmpty()){
                    Toast.makeText(Dokumenty3.this, "Nie podano nr rejestracyjnego naczepy", Toast.LENGTH_SHORT).show();
                }
                else{
                    nrRejNaczepy = nrNaczepyEditText.getText().toString();
                    Intent intent = new Intent(Dokumenty3.this,Dokumenty4.class);
                    startActivity(intent);
                }

            }
        });


    }


}