package com.example.pwsteprojekt;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

public class WiadomosciWyslij extends AppCompatActivity {

    private TextView nadawcaTV,odbiorcaTV,dataWyslaniaTV,tematTV,trescTV,textView52;
    private Button wyslijButton;
    private EditText editTextTresc;
    WiadomosciMain wiadomosciMain = new WiadomosciMain();




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiadomosci_wyslij);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        nadawcaTV = findViewById(R.id.nadawcaTV);
        textView52 = findViewById(R.id.textView52);
        odbiorcaTV = findViewById(R.id.odbiorcaTV);
        dataWyslaniaTV = findViewById(R.id.dataWyslaniaTV);
        tematTV = findViewById(R.id.tematTV);
        trescTV = findViewById(R.id.trescTV);
        wyslijButton = findViewById(R.id.wyslijButton);
        editTextTresc = findViewById(R.id.editTextTresc);

        try {
            new TaskA().execute();
        }catch (Exception e) {
            e.printStackTrace();
        }

        if(bundle!=null)
        {
            String typWiadomosci = (String) bundle.get("typWiadomosci");
            //textView52.setText(wiadomosciMain.getTypWiadomosci());
            //textView52.setText(typWiadomosci);
        }
        wyslijButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
//                String odpowiedz = editTextTresc.getText().toString();
//                if(!odpowiedz.isEmpty()){
//                    // wyslij wiadomosc od id pobranym wczesniej do bazy
//                    String id = (String) bundle.get("idwiadomosc");
//                    String tresc = (String) bundle.get("wiadomosc");
//
//                }

                try{
                    new TaskB().execute();
                }catch (Exception e){
                    e.printStackTrace();
                }




//                else{
//                    Toast.makeText(WiadomosciWyslij.this, "Nie mozesz wyslac pustej wiadomosci", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }


     class TaskA extends AsyncTask<Void,Void,Void>{
        String error="";
        String nadawca = "";
        String odbiorca = "";
        Date date;
        String temat = "";
        String tresc = "";
        @Override
        protected Void doInBackground(Void... voids) {
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            bundle.get("idwiadomosc");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://mysql.mikr.us/db_j206","j206","0EF8_edee39");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from wiadomosc where id="+bundle.get("idwiadomosc")+"");
                while (resultSet.next()){
                    nadawca = resultSet.getString(2);
                    odbiorca= resultSet.getString(3);
                    date = resultSet.getDate(4);
                    temat = resultSet.getString(5);
                    tresc = resultSet.getString(6);
                }
            }catch (Exception e){
                error = e.toString();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void unused) {
            nadawcaTV.setText("Nadawca: "+nadawca);
            odbiorcaTV.setText("Odbiorca: " + odbiorca);
            dataWyslaniaTV.setText("Data: " + date);
            tematTV.setText("Temat: " + temat);
            trescTV.setText(tresc);
            super.onPostExecute(unused);
        }
        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        class TaskB extends AsyncTask<Void,Void,Void>{

            String nadawca = nadawcaTV.getText().toString();
            String odbiorca = odbiorcaTV.getText().toString();
            String date = dataWyslaniaTV.getText().toString();
            //LocalDate localDate = LocalDate.now();
            String temat = tematTV.getText().toString();
            //String tresc = trescTV.getText().toString();
            String odpowiedz = editTextTresc.getText().toString();

            @Override
            protected Void doInBackground(Void... voids) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                int id = bundle.getInt("id");
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://mysql.mikr.us/db_j206","j206","0EF8_edee39");
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("UPDATE `wiadomosc` SET `id`="+id+",`nadawca`="+nadawca+",`odbiorca`="+odbiorca+",`data`="+date+",`temat`="+temat+",`tresc`="+odpowiedz+"WHERE id=1");
                        resultSet.updateRow();
                }catch (Exception e){
                  e.toString();
                }
                return null;
            }
            protected void onPostExecute(Void unused) {

                Toast.makeText(WiadomosciWyslij.this, "Wyslano", Toast.LENGTH_SHORT).show();
                super.onPostExecute(unused);
            }
        }



}
