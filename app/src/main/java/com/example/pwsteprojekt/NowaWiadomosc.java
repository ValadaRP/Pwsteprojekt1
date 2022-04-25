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
import android.widget.Toast;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

public class NowaWiadomosc extends AppCompatActivity {

    //NowaWiadomosc nowaWiadomosc = new NowaWiadomosc();
    private Button wyslijWiad;
    private EditText nadawcaNowa,odbiorcaNowa,dataNowa,tematNowa,trescNowa;
    int id;

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
        //Date data1 = Date.valueOf(String.valueOf(LocalDateTime.now()));
        String temat = tematNowa.getText().toString();
        String tresc = trescNowa.getText().toString();
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://mysql.mikr.us/db_j206","j206","0EF8_edee39");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("INSERT INTO `wiadomosc`(`id`, `nadawca`, `odbiorca`, `data`, `temat`, `tresc`) VALUES ("+id+","+nadawca+","+odbiorca+","+data+","+temat+","+tresc+"");
                resultSet.last();
                id = resultSet.getInt("id")+1;
                resultSet.moveToInsertRow();
                    resultSet.updateInt("id",id);
                    resultSet.updateString("nadawca",nadawca);
                    resultSet.updateString("odbiorca",odbiorca);
                    resultSet.updateString("data",data);
                    resultSet.updateString("temat",temat);
                    resultSet.updateString("tresc",tresc);
                    resultSet.insertRow();

            }catch (Exception e){
               e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(Void unused) {

            Toast.makeText(NowaWiadomosc.this, "Jest okej", Toast.LENGTH_SHORT).show();
            super.onPostExecute(unused);
        }
    }
}