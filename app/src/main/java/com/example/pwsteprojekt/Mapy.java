package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.LocationRequest;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Mapy extends AppCompatActivity {

    private Button button;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapy);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText.getText().toString().isEmpty()){
                    Toast.makeText(Mapy.this, "Podaj miejsce docelowe!", Toast.LENGTH_LONG).show();
                }else {
                    Uri gmmIntentUri = Uri.parse("google.navigation:q="+editText.getText().toString()+",+Poland&mode=d");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                }
                

            }
        });
    }

}