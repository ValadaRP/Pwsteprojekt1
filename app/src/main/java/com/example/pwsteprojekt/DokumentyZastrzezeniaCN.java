package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class DokumentyZastrzezeniaCN extends AppCompatActivity {
    private Button dalejButton7,zrob_zdjecie3;
    final static int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumenty_zastrzezenia_cn);

        dalejButton7 = findViewById(R.id.dalejButton8);
        zrob_zdjecie3 = findViewById(R.id.zrob_zdjecie4);

        dalejButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DokumentyZastrzezeniaCN.this,DokumentyCN3.class);
                startActivity(intent);
            }
        });

        zrob_zdjecie3.setOnClickListener(new View.OnClickListener() {
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