package com.example.pwsteprojekt;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Locale;

public class NowaWiadomosc extends AppCompatActivity {

    //NowaWiadomosc nowaWiadomosc = new NowaWiadomosc();
    private Button wyslijWiad;
    private EditText nadawcaNowa,odbiorcaNowa,tematNowa,trescNowa;
    private TextView dataNowa;
    int id;

    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    public String Date;

    //)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowa_wiadomosc);

        wyslijWiad = findViewById(R.id.wyslijWiad);
        nadawcaNowa = findViewById(R.id.nadawcaNowa);
        odbiorcaNowa = findViewById(R.id.odbiorcaNowa);
        dataNowa = findViewById(R.id.dataNowa);
        tematNowa = findViewById(R.id.tematNowa);
        trescNowa = findViewById(R.id.trescNowa);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date = simpleDateFormat.format(calendar.getTime());
        dataNowa.setText(Date);


        wyslijWiad.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
               new TaskWstaw().execute();
            }
        });



    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    class TaskWstaw extends AsyncTask<Void,Void,Void> {
        String nadawca = nadawcaNowa.getText().toString();
        String odbiorca = odbiorcaNowa.getText().toString();
        String data = dataNowa.getText().toString();
        String temat = tematNowa.getText().toString();
        String tresc = trescNowa.getText().toString();
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://mysql.mikr.us/db_j206","j206","0EF8_edee39");
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("INSERT INTO `wiadomosc` (`nadawca`,`odbiorca`,`data`,`temat`,`tresc`) VALUES ("+nadawca+","+odbiorca+","+data+","+temat+","+tresc);

                    resultSet.moveToInsertRow();
                    resultSet.updateString(2,nadawca);
                    resultSet.updateString(3,odbiorca);
                    resultSet.updateString(4,data);
                    resultSet.updateString(5,temat);
                    resultSet.updateString(6,tresc);
                    resultSet.insertRow();
//                resultSet.moveToCurrentRow();
            }catch (Exception e){
               e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(Void unused) {

            //Toast.makeText(NowaWiadomosc.this, "Jest okej", Toast.LENGTH_SHORT).show();
            super.onPostExecute(unused);
        }
    }
}