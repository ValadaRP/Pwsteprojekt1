package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class WiadomosciWyslane extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> wiadomosciWyslane;
    private TextView infoW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiadomosci_odebrane);
        list =  findViewById(R.id.list);
        infoW = findViewById(R.id.infoW);
        //String[] wiadomosci = {};
        wiadomosciWyslane = new ArrayList<String>();
        Collections.addAll(wiadomosciWyslane,new String[]{"Android","IPhone","JEDZIE POCIAG Z DALEKA NA NIKOGO NIE CZEKA","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"});
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,wiadomosciWyslane);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this::onItemClick);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                wiadomosciWyslane.remove(position);
                list.invalidateViews();
                Toast.makeText(WiadomosciWyslane.this, "Wiadomosc zostala usunięta", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        String wiadomosc = list.getItemAtPosition(position).toString();
        String idwiad = String.valueOf(id);
        Intent intent = new Intent(WiadomosciWyslane.this,WiadomosciWyslij.class);
        intent.putExtra("wiadomosc", wiadomosc);
        intent.putExtra("idwiadomosc",idwiad);
        startActivity(intent);
    }

    public ListView getList() {
        return list;
    }
}