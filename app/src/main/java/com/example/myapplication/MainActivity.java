package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        Button btnGoToIKZ_1_1 = findViewById(R.id.btnGoToIKZ_1_1);
        Button btnGoToIKZ_1_2 = findViewById(R.id.btnGoToIKZ_1_2);
        Button btnGoToIKZ_2 = findViewById(R.id.btnGoToIKZ_2);
        Button btnGoToIKZ_3_2 = findViewById(R.id.btnGoToIKZ_3_2);
        Button btnGoToIKZ_3_1 = findViewById(R.id.btnGoToIKZ_3_1);
        Button btnGoToIKZ_3_3 = findViewById(R.id.btnGoToIKZ_3_3);
        Button btnGoToIKZ_4_1 = findViewById(R.id.btnGoToIKZ_4_1);
        Button btnGoToIKZ_4_2 = findViewById(R.id.btnGoToIKZ_4_2);
        Button btnGoToIKZ_5 = findViewById(R.id.btnGoToIKZ_5);
        Button btnGoToIKZ_6 = findViewById(R.id.btnGoToIKZ_6);

        View.OnClickListener oclBtnGoToIKZ_1_1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IKZ_1_1_intent = new Intent(MainActivity.this, Task_1_1.class);
                startActivity(IKZ_1_1_intent);
            }
        };
        View.OnClickListener oclBtnGoToIKZ_1_2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IKZ_1_2_intent = new Intent(MainActivity.this, Task_1_2.class);
                startActivity(IKZ_1_2_intent);
            }
        };
        View.OnClickListener oclBtnGoToIKZ_2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IKZ_2_intent = new Intent(MainActivity.this, Task_2.class);
                startActivity(IKZ_2_intent);
            }
        };
        View.OnClickListener oclBtnGoToIKZ_3_1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IKZ_3_1_intent = new Intent(MainActivity.this, Task_3_1.class);
                startActivity(IKZ_3_1_intent);
            }
        };
        View.OnClickListener oclBtnGoToIKZ_3_2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IKZ_3_2_intent = new Intent(MainActivity.this, Task_3_2.class);
                startActivity(IKZ_3_2_intent);
            }
        };
        View.OnClickListener oclBtnGoToIKZ_3_3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IKZ_3_3_intent = new Intent(MainActivity.this, Task_3_3.class);
                startActivity(IKZ_3_3_intent);
            }
        };
        View.OnClickListener oclBtnGoToIKZ_4_1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IKZ_4_1_intent = new Intent(MainActivity.this, Task_4_1.class);
                startActivity(IKZ_4_1_intent);
            }
        };
        View.OnClickListener oclBtnGoToIKZ_4_2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IKZ_4_2_intent = new Intent(MainActivity.this, Task_4_2.class);
                startActivity(IKZ_4_2_intent);
            }
        };
        View.OnClickListener oclBtnGoToIKZ_5 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IKZ_5_intent = new Intent(MainActivity.this, Task_5.class);
                startActivity(IKZ_5_intent);
            }
        };
        View.OnClickListener oclBtnGoToIKZ_6 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IKZ_6_intent = new Intent(MainActivity.this, Task_6.class);
                startActivity(IKZ_6_intent);
            }
        };

       btnGoToIKZ_1_1.setOnClickListener(oclBtnGoToIKZ_1_1);
       btnGoToIKZ_1_2.setOnClickListener(oclBtnGoToIKZ_1_2);
       btnGoToIKZ_2.setOnClickListener(oclBtnGoToIKZ_2);
       btnGoToIKZ_3_1.setOnClickListener(oclBtnGoToIKZ_3_1);
       btnGoToIKZ_3_2.setOnClickListener(oclBtnGoToIKZ_3_2);
       btnGoToIKZ_3_3.setOnClickListener(oclBtnGoToIKZ_3_3);
       btnGoToIKZ_4_1.setOnClickListener(oclBtnGoToIKZ_4_1);
       btnGoToIKZ_4_2.setOnClickListener(oclBtnGoToIKZ_4_2);
       btnGoToIKZ_5.setOnClickListener(oclBtnGoToIKZ_5);
       btnGoToIKZ_6.setOnClickListener(oclBtnGoToIKZ_6);
    }
}