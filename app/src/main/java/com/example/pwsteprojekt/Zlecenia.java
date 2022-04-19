package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Zlecenia extends AppCompatActivity {

    private Button dokumentyButton;
    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> zlecenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlecenia);

        dokumentyButton = findViewById(R.id.dokumentyButton);
        list = findViewById(R.id.listPrzekazan);

        zlecenia = new ArrayList<String>();
        Collections.addAll(zlecenia,new String[]{"Zlecenie 1","Zlecenie 2"});
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,zlecenia);
        list.setAdapter(adapter);

        dokumentyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Zlecenia.this,Dokumenty.class);
                startActivity(intent);
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

                        zlecenia.remove(position);
                        list.invalidateViews();
                        Toast.makeText(Zlecenia.this, "Zlecenie zostalo usunięte", Toast.LENGTH_SHORT).show();
                        return true;
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent = new Intent(Zlecenia.this,ZleceniaInfo.class);
               startActivity(intent);
            }
        });
    }
}