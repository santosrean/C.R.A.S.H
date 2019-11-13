package com.example.crash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RankingActivity extends AppCompatActivity {

    dataBase myDB = new dataBase(this);
    Cursor curs;
    StringBuffer buffer;
    TextView txtRanks = findViewById(R.id.txtRanking);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        curs = myDB.SelectTopTen();
        buffer = new StringBuffer();


        while (curs.moveToNext()) {
            buffer.append(curs.getString(1) + "   -   " + curs.getString(2));
        }

        txtRanks.setText(buffer.toString());
    }

    public void OpenMainLayout(View v){
        Intent OpenView = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(OpenView);
    }
}
