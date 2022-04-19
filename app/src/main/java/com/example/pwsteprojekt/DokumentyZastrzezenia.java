package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class DokumentyZastrzezenia extends AppCompatActivity {
    private Button dalejButton4,zrob_zdjecie2Button;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumenty_zastrzezenia);
        dalejButton4 = findViewById(R.id.dalejButton8);
        zrob_zdjecie2Button = findViewById(R.id.zrob_zdjecie4);

        dalejButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DokumentyZastrzezenia.this,DokumentyFormularz1.class);
                startActivity(intent);
            }
        });

        zrob_zdjecie2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });


    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent2, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }


}