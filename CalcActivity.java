package com.example.practice08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CalcActivity extends AppCompatActivity {
    EditText edtNumber1, edtNumber2;
    RadioGroup grpOperator;
    Button btnCompute, btnPrev;
    double number1,number2;
    public static double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        setTitle("계산기");

        edtNumber1 = (EditText)findViewById(R.id.calc_editText1);
        edtNumber2 = (EditText)findViewById(R.id.calc_editText2);
        grpOperator = (RadioGroup)findViewById(R.id.calc_group);
        btnCompute = (Button)findViewById(R.id.calc_button1);
        btnPrev = (Button)findViewById(R.id.calc_button2);

        // 라디오그룹에서의 버튼 초기화
        grpOperator.check(R.id.calc_radioButton1);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1 = Double.parseDouble(edtNumber1.getText().toString());
                number2 = Double.parseDouble(edtNumber2.getText().toString());

                if(grpOperator.getCheckedRadioButtonId() == R.id.calc_radioButton1) {
                    result = number1 + number2;
                } else if(grpOperator.getCheckedRadioButtonId() == R.id.calc_radioButton2) {
                    result = number1 - number2;
                } else if(grpOperator.getCheckedRadioButtonId() == R.id.calc_radioButton3) {
                    result = number1 * number2;
                } else if(grpOperator.getCheckedRadioButtonId() == R.id.calc_radioButton4) {
                    result = number1 / number2;
                }

                Toast.makeText(CalcActivity.this, Double.toString(result), Toast.LENGTH_LONG).show();
               //startActivity(new Intent(CalcActivity.this, ResultActivity.class));
            }
        });
    }
}