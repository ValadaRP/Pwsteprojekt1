package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import android.os.Handler;
import android.widget.TextView;

public class Mapy extends AppCompatActivity {

    private Button buttonPobierz;
    private EditText editTextID;
    private String wynik;
    private TextView textViewAdres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapy);

//        button = findViewById(R.id.button);
        buttonPobierz = findViewById(R.id.buttonPobierz);
        editTextID = findViewById(R.id.editTextID);
        textViewAdres = findViewById(R.id.textViewAdres);


        buttonPobierz.setOnClickListener(new View.OnClickListener() {

                @Override
            public void onClick(View v) {
                    if(TextUtils.isEmpty(editTextID.getText().toString())) {
                        editTextID.setError("Pole jest puste");
                    }else {
                        new TaskMapy().execute();
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Uri gmmIntentUri = Uri.parse("google.navigation:q="+textViewAdres.getText().toString()+",+Poland&mode=d");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);

                            }
                        }, 3000);
                    }
            }

        });
    }

    class TaskMapy extends AsyncTask<Void,Void,Void> {
        String error = "";
        Connection con;

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                con = getConnection(con);
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from mapa where idpojazdu = " + editTextID.getText().toString());
                resultSet.next();
                wynik = resultSet.getString(2);

                con.close();
            }catch (Exception e){
                error = e.toString();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {

            textViewAdres.setText(wynik);
            super.onPostExecute(unused);
        }

        public Connection getConnection(Connection con){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://mysql.mikr.us/db_j206","j206","0EF8_edee39");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return con;
        }


    }


}