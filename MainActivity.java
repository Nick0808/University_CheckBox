package com.example.practice08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnUniv, btnCalc;
    Intent practiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUniv = (Button)findViewById(R.id.main_button1);
        btnCalc = (Button)findViewById(R.id.main_button2);

        btnUniv.setOnClickListener(this);
        btnCalc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.main_button1) {
            practiceIntent = new Intent(MainActivity.this, UnivActivity.class);
        } else if(v.getId() == R.id.main_button2) {
            practiceIntent = new Intent(MainActivity.this, CalcActivity.class);
        }

        startActivity(practiceIntent);
    }
}