package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WiadomosciWyslij extends AppCompatActivity {

    private TextView nadawcaTV,odbiorcaTV,dataWyslaniaTV,tematTV,trescTV;
    private Button wyslijButton;
    private EditText editTextTresc;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiadomosci_wyslij);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        nadawcaTV = findViewById(R.id.nadawcaTV);
        odbiorcaTV = findViewById(R.id.nadawcaTV);
        dataWyslaniaTV = findViewById(R.id.dataWyslaniaTV);
        tematTV = findViewById(R.id.tematTV);
        trescTV = findViewById(R.id.trescTV);
        wyslijButton = findViewById(R.id.wyslijButton);
        editTextTresc = findViewById(R.id.editTextTresc);

        if(bundle!=null)
        {
            String id = (String) bundle.get("idwiadomosc");
            String j =(String) bundle.get("wiadomosc");
        }
        wyslijButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String odpowiedz = editTextTresc.getText().toString();
                if(!odpowiedz.isEmpty()){
                    // wyslij wiadomosc od id pobranym wczesniej do bazy
                    String id = (String) bundle.get("idwiadomosc");
                    String tresc = (String) bundle.get("wiadomosc");
                }else{
                    Toast.makeText(WiadomosciWyslij.this, "Nie mozesz wyslac pustej wiadomosci", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}