package com.example.pwsteprojekt;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Usterka extends AppCompatActivity {
    private Button zrob_zdjecie,wyslij_usterka;
    private EditText editTextMultiLine;
    public String imagePath;
    public Bitmap yourSelectedImage;
    public File imageFile;

    static final int REQUEST_IMAGE_CAPTURE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usterka);

        zrob_zdjecie = findViewById(R.id.zrob_zdjecie);
        editTextMultiLine = findViewById(R.id.editTextMultiLine);
        wyslij_usterka = findViewById(R.id.wyslij_usterka);

        zrob_zdjecie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dispatchTakePictureIntent();
            }
        });
        wyslij_usterka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent,3);

            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && data != null){
//            Uri selectedImage = data.getData();
//            imagePath = getPath(selectedImage);
//            imageFile = new File(imagePath);
//        }
//    }

//    public String getPath(Uri uri) {
//        String[] projection = { MediaStore.Images.Media.DATA };
//        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
//        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//        cursor.moveToFirst();
//        int columnIndex = cursor.getColumnIndex(projection[0]);
//        String filePath = cursor.getString(columnIndex);
//        cursor.close();
//        yourSelectedImage = BitmapFactory.decodeFile(filePath);
//        return cursor.getString(column_index);
//    }

    public EditText getEditTextMultiLine() {
        return editTextMultiLine;
    }
}