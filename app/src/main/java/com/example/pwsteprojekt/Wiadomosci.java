package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Wiadomosci extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> adapter;
    private TextView infoW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiadomosci);

        list = (ListView) findViewById(R.id.list);
        infoW = findViewById(R.id.infoW);
        String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"};
        String[] wiadomosci = {};
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mobileArray);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this::onItemClick);

    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        String wiadomosc = list.getItemAtPosition(position).toString();
        infoW.setText(wiadomosc);
    }
}