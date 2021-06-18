package com.example.practice08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("계산결과");

        txtResult = (TextView)findViewById(R.id.result_textView);
        txtResult.setText(Double.toString(CalcActivity.result));
    }
}