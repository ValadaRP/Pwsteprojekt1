package com.example.pwsteprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB extends AppCompatActivity {

    Connection con;
    String ConnectionResult = "";

    public TextView textView;
    public Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_db);
        textView = findViewById(R.id.textViewDB);
        button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new Task().execute();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }


    
    class Task extends AsyncTask<Void,Void,Void>{
        String records = "",error="";

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1/test","piotrek123","12345");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from uzytkownicy");
                while (resultSet.next()){
                    records += resultSet.getString(2);
                }
            }catch (Exception e){
                error = e.toString();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            textView.setText(records);

            super.onPostExecute(unused);
        }
    }

}