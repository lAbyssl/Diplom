package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstIKZ2 extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        double RbVal = 0;
        int RsVal = 0;
        String rb;
        String rs;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_ikz2);

        RbVal = getIntent().getExtras().getDouble("RbVal");
        RsVal = getIntent().getExtras().getInt("RsVal");
        rb = String.valueOf(RbVal);
        rs = String.valueOf(RsVal);

        TextView txtTest = (TextView) findViewById(R.id.RbText);
        txtTest.setText(rb);

        txtTest = (TextView) findViewById(R.id.RsText);
        txtTest.setText(rs);
    }
}