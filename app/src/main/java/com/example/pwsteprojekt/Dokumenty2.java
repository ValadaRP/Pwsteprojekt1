package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Dokumenty2 extends AppCompatActivity {

    private Button ciagnikNaczepaButton,naczepaButton;
    public String typ2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumenty2);

        ciagnikNaczepaButton = findViewById(R.id.ciagnikNaczepaButton);
        naczepaButton = findViewById(R.id.naczepaButton);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String typ = (String) bundle.get("typ");

//        if(bundle!=null){
//            String typ = (String) bundle.get("typ");
//
//           // typ "Zdajacy lub Odbierajacy"
//        }



        ciagnikNaczepaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                typ2 = "ciagnik + naczepa";
                Intent intent = new Intent(Dokumenty2.this,DokumentyCN.class);
                intent.putExtra("typ",typ);
                intent.putExtra("typ2",typ2);
                startActivity(intent);
            }
        });
        naczepaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typ2 = "sama naczepa";
                Intent intent = new Intent(Dokumenty2.this,Dokumenty3.class);
                intent.putExtra("typ2",typ2);
                startActivity(intent);
            }
        });

    }
}