package com.example.crash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OpenRankLayout(View v){
        Intent OpenView = new Intent(getApplicationContext(), RankingActivity.class);
        startActivity(OpenView);
    }
}
