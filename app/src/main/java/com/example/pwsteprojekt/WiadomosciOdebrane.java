package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class WiadomosciOdebrane extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> wiadomosciOdebrane;
    private TextView infoW;
    int id;
    public String [] a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiadomosci_odebrane);
        list =  findViewById(R.id.list);
        infoW = findViewById(R.id.infoW);
        //String[] wiadomosci = new String[]{WiadomosciWyslij.TaskA().execute()};
        wiadomosciOdebrane = new ArrayList<String>();
        Collections.addAll(wiadomosciOdebrane, new String[]{"ID: 1","ID: 2","ID: 3","ID: 4","ID: 5","ID: 6","ID: 7"});

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,wiadomosciOdebrane);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this::onItemClick);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                wiadomosciOdebrane.remove(position);
                list.invalidateViews();
                Toast.makeText(WiadomosciOdebrane.this, "Wiadomosc zostala usunięta", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        String wiadomosc = list.getItemAtPosition(position).toString();
        int idwiad = Integer.parseInt(String.valueOf(id));
        Intent intent = new Intent(WiadomosciOdebrane.this,WiadomosciWyslij.class);
        intent.putExtra("wiadomosc", wiadomosc);
        intent.putExtra("idwiadomosc",idwiad+1);
        startActivity(intent);
    }

    public ListView getList() {
        return list;
    }
    class TaskId extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://mysql.mikr.us/db_j206","j206","0EF8_edee39");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select id from wiadomosc");
                while (resultSet.next()){
                    id+=resultSet.getInt(1);
                }
            }catch (Exception e){
                e.toString();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void unused) {
            a = new String[id];
            super.onPostExecute(unused);
        }
    }
}