package com.example.practice08;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


// main_Activity
public class UnivActivity extends AppCompatActivity {
    TextView txtDisplay;
    RadioGroup grpUniv, grpDepart;
    EditText edtSize;
    Button btnOk, btnPrev;
    String univ = "", depart = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_univ);
        setTitle("학과선택");

        txtDisplay = (TextView)findViewById(R.id.univ_textView1);
        grpUniv = (RadioGroup)findViewById(R.id.univ_group1);
        grpDepart = (RadioGroup)findViewById(R.id.univ_group2);
        edtSize = (EditText)findViewById(R.id.univ_editText);
        btnOk = (Button)findViewById(R.id.univ_button1);
        btnPrev = (Button)findViewById(R.id.univ_button2);

        btnOk.setOnClickListener(new ButtonClickListner());
        btnPrev.setOnClickListener(new ButtonClickListner());

        grpUniv.setOnCheckedChangeListener(new UnivCheckChangeListener());
        grpDepart.setOnCheckedChangeListener(new UnivCheckChangeListener());
    }

    public class UnivCheckChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton rdoSelect = (RadioButton)findViewById(checkedId);
            //RadioButton rdoSelect = (RadioButton)findViewById(group.getCheckedRadioButtonId());
            if(group == grpUniv) {
                // 학교선택
                univ = rdoSelect.getText().toString();

            } else if(group == grpDepart) {
                // 학과선택
                depart = rdoSelect.getText().toString();

            }


        }
    }

    public class ButtonClickListner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.univ_button1) {
                txtDisplay.setText(univ + " " +depart);
                int size = Integer.parseInt(edtSize.getText().toString()); //값 가져오기
                txtDisplay.setTextSize(size);

            } else if(v.getId() == R.id.univ_button2) {
                AlertDialog.Builder exitBuilder = new AlertDialog.Builder(UnivActivity.this); // 대화상자 생성
                exitBuilder.setIcon(R.drawable.get_info);
                exitBuilder.setTitle("종료");
                exitBuilder.setMessage("종료 하시겠습니까?");
                exitBuilder.setPositiveButton("종료", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                exitBuilder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
            }
        }
    }
}