package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Task_6 extends AppCompatActivity {

    public String[] classBetona = {"B10", "B15", "B20", "B25", "B30", "B35", "B40", "B45", "B50", "B55", "B60"};
    public String[] classArmaturi = {"A240", "A400", "A500", "A600", "A800", "A1000", "B500", "K1400", "K1500"};
    public String[] kolvoSt = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public String[] diam = {"10","12","14","15","16","18","20","22","25","28","32","36","40"};

    public double[][] AsNum = {{10., 78.5},
            {12., 113.1},
            {14., 159.3},
            {16., 201.1},
            {18., 254.5},
            {20., 314.2},
            {22., 380.1},
            {25., 490.9},
            {28., 615.8},
            {32., 804.2},
            {36., 1017.9},
            {40., 1256.6}};

    public double[][] AsNum_K1400 = {{15., 141.6}};
    public double[][] AsNum_K1500 = {{12., 90.6},};


    public Integer Stergni_Sp = 0;
    public Integer Diametr_Sp = 0;
    public Integer Stergni_S = 0;
    public Integer Diametr_S = 0;
    public Integer AredPow;
    public Integer IredPow;
    public Integer x1;
    public Integer Rbp;


    public Double b;
    public Double bf;
    public Double h;
    public Double hf;
    public Double a;
    public Double ap;
    public Double L;
    public Double L0;
    public Double SigmaSp;
    public Double Wet;
    public Double Ared;
    public Double Ired;
    public Double y;
    public Double x2;
    public Double ysp;
    public Double Asp, As, Eb, Esp, Rsn, Es, P1, e0p1, SigmaBp, Ebsh, A, qw, Mw, SigmaBp2, Phib, Alpha, Musp, P, e0p;
    public Double D_SigmaSp1, D_SigmaSp2, D_SigmaSp3, D_SigmaSp4, D_SigmaSp5, D_SigmaSp6, D_Sigma_Sp1, D_Sigma_Sp2, Sigma_Sp2;

    public String classBetTxt;
    public String kolvoStTxt_Sp;
    public String diamTxt_Sp;
    public String classArmTxt_Sp;
    public String kolvoStTxt_S;
    public String diamTxt_S;
    public String classArmTxt_S;
    public String RbpTxt;

    public EditText b_Text;
    public EditText bf_Text;
    public EditText h_Text;
    public EditText hf_Text;
    public EditText ap_Text;
    public EditText a_Text;
    public EditText L_Text;
    public EditText L0_Text;
    public EditText SigmaSp_Text;
    public EditText Rbp_Text;
    public EditText Wet_Text;
    public EditText Ared_Text;
    public EditText Ired_Text;
    public EditText AredPow_Text;
    public EditText IredPow_Text;
    public EditText y_Text;

    public Spinner ClassBetona;
    public Spinner KolvoSt_Sp;
    public Spinner KolvoSt_S;
    public Spinner Diam_Sp;
    public Spinner Diam_S;
    public Spinner ClassArmaturi_Sp;
    public Spinner ClassArmaturi_S;


    TextView textView_D_SigmaSp1;
    TextView textView_D_SigmaSp2;
    TextView textView_D_SigmaSp3;
    TextView textView_D_SigmaSp4;
    TextView textView_D_SigmaSp5;
    TextView textView_D_SigmaSp6;
    TextView textView_Sigma_Sp2;
    TextView textView_SigmaBp;
    TextView textView_P;
    TextView textView_e0p;

    RadioGroup radioGroup;
    RadioGroup radioGroup1;

    RadioButton radioButton_Mehan;
    RadioButton radioButton_Electroterm;
    RadioButton radioButton_Estestv;
    RadioButton radioButton_TeplObr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_6);

        b_Text = findViewById(R.id.b_6);
        bf_Text = findViewById(R.id.bf_6);
        h_Text = findViewById(R.id.h_6);
        hf_Text = findViewById(R.id.hf_6);
        ap_Text = findViewById(R.id.ap_6);
        a_Text = findViewById(R.id.a_6);
        L_Text = findViewById(R.id.L_6);
        L0_Text = findViewById(R.id.L0_6);
        SigmaSp_Text = findViewById(R.id.SigmaSp_6);
        Rbp_Text = findViewById(R.id.Rbp_6);
        Wet_Text = findViewById(R.id.Wet_6);
        Ared_Text = findViewById(R.id.Ared_6);
        Ired_Text = findViewById(R.id.Ired_6);
        AredPow_Text = findViewById(R.id.AredPow_6);
        IredPow_Text = findViewById(R.id.IredPow_6);
        y_Text = findViewById(R.id.y_6);

        textView_D_SigmaSp1 = findViewById(R.id.DSigmaSp1_6);
        textView_D_SigmaSp2 = findViewById(R.id.DSigmaSp2_6);
        textView_D_SigmaSp3 = findViewById(R.id.DSigmaSp3_6);
        textView_D_SigmaSp4 = findViewById(R.id.DSigmaSp4_6);
        textView_D_SigmaSp5 = findViewById(R.id.DSigmaSp5_6);
        textView_D_SigmaSp6 = findViewById(R.id.DSigmaSp6_6);
        textView_Sigma_Sp2 = findViewById(R.id.SigmaSp2_6);
        textView_SigmaBp = findViewById(R.id.Sigmabp_6);
        textView_P = findViewById(R.id.P_6);
        textView_e0p = findViewById(R.id.e0p_6);

        radioGroup = findViewById(R.id.radio_group_6);
        radioGroup1 = findViewById(R.id.radio_group_6_1);

        radioButton_Mehan = findViewById(R.id.radioButton_Mehan_6);
        radioButton_Electroterm = findViewById(R.id.radioButton_Electroterm_6);
        radioButton_Estestv = findViewById(R.id.radioButton_Estestv_6_1);
        radioButton_TeplObr = findViewById(R.id.radioButton_TeplObr_6_1);

        ClassBetona = findViewById(R.id.ClassBetona_7);
        ArrayAdapter<String> classBetonaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classBetona);
        classBetonaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassBetona.setAdapter(classBetonaAdapter);

        KolvoSt_Sp = findViewById(R.id.KolvoSt_Sp_6);
        ArrayAdapter<String> kolvoSt_Sp_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kolvoSt);
        kolvoSt_Sp_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        KolvoSt_Sp.setAdapter(kolvoSt_Sp_Adapter);

        Diam_Sp = findViewById(R.id.Diam_Sp_6);
        ArrayAdapter<String> diam_Sp_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, diam);
        diam_Sp_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Diam_Sp.setAdapter(diam_Sp_Adapter);

        ClassArmaturi_Sp = findViewById(R.id.ClassArmaturi_Sp_6);
        ArrayAdapter<String> classArmaturi_Sp_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classArmaturi);
        classArmaturi_Sp_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassArmaturi_Sp.setAdapter(classArmaturi_Sp_Adapter);

        KolvoSt_S = findViewById(R.id.KolvoSt_S_6);
        ArrayAdapter<String> kolvoSt_S_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kolvoSt);
        kolvoSt_S_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        KolvoSt_S.setAdapter(kolvoSt_S_Adapter);

        Diam_S = findViewById(R.id.Diam_S_6);
        ArrayAdapter<String> diam_S_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, diam);
        diam_S_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Diam_S.setAdapter(diam_S_Adapter);

        ClassArmaturi_S= findViewById(R.id.ClassArmaturi_S_6);
        ArrayAdapter<String> classArmaturi_S_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classArmaturi);
        classArmaturi_S_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassArmaturi_S.setAdapter(classArmaturi_S_Adapter);
    }

    @SuppressLint({"NonConstantResourceId", "CutPasteId"})
    public void Reshenie(View view) {

        classBetTxt = ClassBetona.getSelectedItem().toString();
        kolvoStTxt_Sp = KolvoSt_Sp.getSelectedItem().toString();
        kolvoStTxt_S = KolvoSt_S.getSelectedItem().toString();
        diamTxt_Sp = Diam_Sp.getSelectedItem().toString();
        diamTxt_S = Diam_S.getSelectedItem().toString();
        classArmTxt_Sp = ClassArmaturi_Sp.getSelectedItem().toString();
        classArmTxt_S = ClassArmaturi_S.getSelectedItem().toString();

        if (b_Text.getText().toString().length() == 0 || h_Text.getText().toString().length() == 0 ||
                bf_Text.getText().toString().length() == 0 || hf_Text.getText().toString().length() == 0 ||
                ap_Text.getText().toString().length() == 0 || a_Text.getText().toString().length() == 0 ||
                L_Text.getText().toString().length() == 0 || L0_Text.getText().toString().length() == 0 ||
                SigmaSp_Text.getText().toString().length() == 0 || Rbp_Text.getText().toString().length() == 0 ||
                Wet_Text.getText().toString().length() == 0 || Ared_Text.getText().toString().length() == 0 ||
                Ired_Text.getText().toString().length() == 0 || AredPow_Text.getText().toString().length() == 0 ||
                IredPow_Text.getText().toString().length() == 0 || y_Text.getText().toString().length() == 0) {

            showDialog();

        } else {

            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Radiobtn1();
            } else {
                if (radioGroup1.getCheckedRadioButtonId() == -1) {
                    Radiobtn2();
                } else {
                    Stergni_Sp = Integer.parseInt(kolvoStTxt_Sp);
                    Stergni_S = Integer.parseInt(kolvoStTxt_S);
                    Diametr_Sp = Integer.parseInt(diamTxt_Sp);
                    Diametr_S = Integer.parseInt(diamTxt_S);

                    b = Double.parseDouble(b_Text.getText().toString());
                    h = Double.parseDouble(h_Text.getText().toString());
                    bf = Double.parseDouble(bf_Text.getText().toString());
                    hf = Double.parseDouble(hf_Text.getText().toString());
                    ap = Double.parseDouble(ap_Text.getText().toString());
                    a = Double.parseDouble(a_Text.getText().toString());
                    L = Double.parseDouble(L_Text.getText().toString());
                    L0 = Double.parseDouble(L0_Text.getText().toString());
                    SigmaSp = Double.parseDouble(SigmaSp_Text.getText().toString());
                    Rbp = Integer.parseInt(Rbp_Text.getText().toString());
                    Wet = Double.parseDouble(Wet_Text.getText().toString());
                    Ared = Double.parseDouble(Ared_Text.getText().toString());
                    Ired = Double.parseDouble(Ired_Text.getText().toString());
                    AredPow = Integer.parseInt(AredPow_Text.getText().toString());
                    IredPow = Integer.parseInt(IredPow_Text.getText().toString());
                    y = Double.parseDouble(y_Text.getText().toString());

                    AlertDialog.Builder builder = new AlertDialog.Builder(Task_6.this);

                    if ((classArmTxt_Sp.equals("A240") || classArmTxt_Sp.equals("A400")) && (diamTxt_Sp.equals("15"))) {

                        builder.setTitle("Предупреждение !")
                                .setMessage("Арматура Sp класса " + classArmTxt_Sp + " не может быть диаметром " + diamTxt_Sp.toString() + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32, 36, 40.")
                                .setCancelable(false)
                                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                        AlertDialog alert = builder.create();
                        alert.show();
                    }

                    else if ((classArmTxt_Sp.equals("A500") || classArmTxt_Sp.equals("A600")) && (diamTxt_Sp.equals("15"))) {

                        builder.setTitle("Предупреждение !")
                                .setMessage("Арматура Sp класса " + classArmTxt_Sp + " не может быть диаметром " + diamTxt_Sp.toString() + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32, 36, 40.")
                                .setCancelable(false)
                                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                        AlertDialog alert = builder.create();
                        alert.show();
                    }

                    else if ((classArmTxt_Sp.equals("A800") || classArmTxt_Sp.equals("A1000")) && (diamTxt_Sp.equals("15") || diamTxt_Sp.equals("36") || diamTxt_Sp.equals("40"))) {

                        builder.setTitle("Предупреждение !")
                                .setMessage("Арматура Sp класса " + classArmTxt_Sp + " не может быть диаметром " + diamTxt_Sp.toString() + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32.")
                                .setCancelable(false)
                                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                        AlertDialog alert = builder.create();
                        alert.show();
                    }

                    else if ((classArmTxt_Sp.equals("B500")) && (diamTxt_Sp.equals("14") || diamTxt_Sp.equals("15") ||
                            diamTxt_Sp.equals("16") || diamTxt_Sp.equals("18") || diamTxt_Sp.equals("20") ||
                            diamTxt_Sp.equals("22") || diamTxt_Sp.equals("25") || diamTxt_Sp.equals("28") ||
                            diamTxt_Sp.equals("32") || diamTxt_Sp.equals("36") || diamTxt_Sp.equals("40"))) {

                        builder.setTitle("Предупреждение !")
                                .setMessage("Арматура Sp класса " + classArmTxt_Sp + " не может быть диаметром " + diamTxt_Sp.toString() + "\n\nДопустимые диаметры:\n\n10, 12.")
                                .setCancelable(false)
                                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                        AlertDialog alert = builder.create();
                        alert.show();
                    }

                    else if (classArmTxt_Sp.equals("K1400") && (!diamTxt_Sp.equals("15"))) {

                        builder.setTitle("Предупреждение !")
                                .setMessage("Арматура Sp класса " + classArmTxt_Sp + " не может быть диаметром " + diamTxt_Sp.toString() + "\n\nДопустимые диаметры:\n\n15.")
                                .setCancelable(false)
                                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                        AlertDialog alert = builder.create();
                        alert.show();
                    }

                    else if (classArmTxt_Sp.equals("K1500") && (!diamTxt_Sp.equals("12"))) {

                        builder.setTitle("Предупреждение !")
                                .setMessage("Арматура Sp класса " + classArmTxt_Sp + " не может быть диаметром " + diamTxt_Sp.toString() + "\n\nДопустимые диаметры:\n\n12.")
                                .setCancelable(false)
                                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                        AlertDialog alert = builder.create();
                        alert.show();

                    }

                    else if ((classArmTxt_S.equals("A240") || classArmTxt_S.equals("A400")) && (diamTxt_S.equals("15"))) {

                        builder.setTitle("Предупреждение !")
                                .setMessage("Арматура S' класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S.toString() + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32, 36, 40.")
                                .setCancelable(false)
                                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                        AlertDialog alert = builder.create();
                        alert.show();
                    }

                    else if ((classArmTxt_S.equals("A500") || classArmTxt_S.equals("A600")) && (diamTxt_S.equals("15"))) {

                        builder.setTitle("Предупреждение !")
                                .setMessage("Арматура S' класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S.toString() + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32, 36, 40.")
                                .setCancelable(false)
                                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                        AlertDialog alert = builder.create();
                        alert.show();
                    }

                    else if ((classArmTxt_S.equals("A800") || classArmTxt_S.equals("A1000")) && (diamTxt_S.equals("15") || diamTxt_S.equals("36") || diamTxt_S.equals("40"))) {

                        builder.setTitle("Предупреждение !")
                                .setMessage("Арматура S' класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S.toString() + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32.")
                                .setCancelable(false)
                                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                        AlertDialog alert = builder.create();
                        alert.show();
                    }

                    else if ((classArmTxt_S.equals("B500")) && (diamTxt_S.equals("14") || diamTxt_S.equals("15") ||
                            diamTxt_S.equals("16") || diamTxt_S.equals("18") || diamTxt_S.equals("20") ||
                            diamTxt_S.equals("22") || diamTxt_S.equals("25") || diamTxt_S.equals("28") ||
                            diamTxt_S.equals("32") || diamTxt_S.equals("36") || diamTxt_S.equals("40"))) {

                        builder.setTitle("Предупреждение !")
                                .setMessage("Арматура S' класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S.toString() + "\n\nДопустимые диаметры:\n\n10, 12.")
                                .setCancelable(false)
                                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                        AlertDialog alert = builder.create();
                        alert.show();
                    }

                    else if (classArmTxt_S.equals("K1400") && (!diamTxt_S.equals("15"))) {

                        builder.setTitle("Предупреждение !")
                                .setMessage("Арматура S' класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S.toString() + "\n\nДопустимые диаметры:\n\n15.")
                                .setCancelable(false)
                                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                        AlertDialog alert = builder.create();
                        alert.show();
                    }

                    else if (classArmTxt_S.equals("K1500") && (!diamTxt_S.equals("12"))) {

                        builder.setTitle("Предупреждение !")
                                .setMessage("Арматура S' класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S.toString() + "\n\nДопустимые диаметры:\n\n12.")
                                .setCancelable(false)
                                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                        AlertDialog alert = builder.create();
                        alert.show();

                    } else {

                        Ared *= Math.pow(10, AredPow);
                        Ired *= Math.pow(10, IredPow);

                        AsValue();
                        EbValue();
                        EsValue();
                        RsnValue();

                        int checkedButtonIndex = radioGroup.getCheckedRadioButtonId();
                        int checkedButtonIndex1 = radioGroup1.getCheckedRadioButtonId();

                        if (classArmTxt_Sp.equals("A600") || classArmTxt_Sp.equals("A800") || classArmTxt_Sp.equals("A1000")) {

                            switch (checkedButtonIndex) {

                                case R.id.radioButton_Mehan_6:

                                    D_SigmaSp1 = 0.1 * SigmaSp - 20;
                                    switch (checkedButtonIndex1) {

                                        case R.id.radioButton_Estestv_6_1:

                                            D_SigmaSp2 = 0.;
                                            break;

                                        case R.id.radioButton_TeplObr_6_1:

                                            D_SigmaSp2 = 1.25 * 65;
                                            break;
                                    }
                                    D_SigmaSp3 = 0.;
                                    D_SigmaSp4 = 2 / (L * 1000 + 1000) * Esp;
                                    break;

                                case R.id.radioButton_Electroterm_6:

                                    D_SigmaSp1 = 0.03 * SigmaSp;
                                    D_SigmaSp2 = 0.;
                                    D_SigmaSp3 = 0.;
                                    D_SigmaSp4 = 0.;

                                    break;
                            }

                        } else {
                            switch (checkedButtonIndex) {

                                case R.id.radioButton_Mehan_6:

                                    D_SigmaSp1 = (0.22 * SigmaSp / Rsn - 0.1) * SigmaSp;
                                    switch (checkedButtonIndex1) {

                                        case R.id.radioButton_Estestv_6_1:

                                            D_SigmaSp2 = 0.;
                                            break;

                                        case R.id.radioButton_TeplObr_6_1:

                                            D_SigmaSp2 = 1.25 * 65;
                                            break;
                                    }
                                    D_SigmaSp3 = 0.;
                                    D_SigmaSp4 = 2 / (L * 1000 + 1000) * Esp;
                                    break;

                                case R.id.radioButton_Electroterm_6:

                                    D_SigmaSp1 = 0.05 * SigmaSp;
                                    D_SigmaSp2 = 0.;
                                    D_SigmaSp3 = 0.;
                                    D_SigmaSp4 = 0.;
                                    break;
                            }
                        }

                    D_Sigma_Sp1 = D_SigmaSp1 + D_SigmaSp2 + D_SigmaSp3 + D_SigmaSp4;
                    P1 = (Asp * (SigmaSp - D_Sigma_Sp1)) / Math.pow(10, 3);
                    e0p1 = y - ap;
                    SigmaBp = ((P1 * Math.pow(10, 3)) / Ared) + (((P1 * Math.pow(10, 3)) * e0p1 * y) / Ired);

                    EbshValue();
                    switch (checkedButtonIndex1) {
                        case R.id.radioButton_Estestv_6_1:
                            D_SigmaSp5 = Ebsh * Esp;
                            break;
                        case R.id.radioButton_TeplObr_6_1:
                            D_SigmaSp5 = Ebsh * Esp * 0.85;
                            break;
                    }

                    A = bf * hf + (h - hf) * b;
                    qw = A / Math.pow(10, 6) * 25;
                    Mw = qw * Math.pow(L0, 2) / 8;
                    ysp = y - ap;
                    SigmaBp2 = ((P1 * Math.pow(10, 3)) / Ared) + ((((P1 * Math.pow(10, 3)) * e0p1 - Mw * Math.pow(10, 6)) * ysp) / Ired);

                    x1 = Integer.valueOf(classBetTxt.substring(1, 3));
                    x2 = (double) Rbp / x1;

                    if (x2 < 0.7) {
                        RbpTxt = Rbp.toString();
                        classBetTxt = "B" + RbpTxt;
                        EbValue();
                        }

                        PhibValue();

                        Alpha = Esp / Eb;
                        Musp = Asp / A;
                        switch (checkedButtonIndex1) {
                            case R.id.radioButton_Estestv_6_1:
                                D_SigmaSp6 = (0.8 * Alpha * Phib * SigmaBp2) / (1 + Alpha * Musp * (1 + (Math.pow(ysp, 2) * Ared) / Ired) * (1 + 0.8 * Phib));
                                break;
                            case R.id.radioButton_TeplObr_6_1:
                                D_SigmaSp6 = (0.8 * Alpha * Phib * SigmaBp2) / (1 + Alpha * Musp * (1 + (Math.pow(ysp, 2) * Ared) / Ired) * (1 + 0.8 * Phib));
                                break;
                        }
                        D_Sigma_Sp2 = D_SigmaSp1 + D_SigmaSp2 + D_SigmaSp3 + D_SigmaSp4 + D_SigmaSp5 + D_SigmaSp6;
                        Sigma_Sp2 = SigmaSp - D_Sigma_Sp2;
                        P = (Sigma_Sp2 * Asp) / Math.pow(10, 3);
                        e0p = y - ap;

                        Print();
                    }
                }
            }
        }
    }

    private void AsValue() {

        switch (classArmTxt_Sp){
            case "K1400":
                for (int i = 0; i < 1; i++) {
                    if (Diametr_Sp == AsNum_K1400[i][0]) Asp = AsNum_K1400[i][1] * Stergni_Sp;
                }

            case "K1500":
                for (int i = 0; i < 1; i++) {
                    if (Diametr_Sp == AsNum_K1500[i][0]) Asp = AsNum_K1500[i][1] * Stergni_Sp;
                }

            default:
                for (int i = 0; i < 12; i++) {
                    if (Diametr_Sp == AsNum[i][0]) Asp = AsNum[i][1] * Stergni_Sp;
                }

        }

        switch (classArmTxt_S){
            case "K1400":

                for (int i = 0; i < 1; i++) {
                    if (Diametr_S == AsNum_K1400[i][0]) As = AsNum_K1400[i][1] * Stergni_S;
                }

            case "K1500":

                for (int i = 0; i < 1; i++) {
                    if (Diametr_S == AsNum_K1500[i][0]) As = AsNum_K1500[i][1] * Stergni_S;
                }

            default:

                for (int i = 0; i < 12; i++) {
                    if (Diametr_S == AsNum[i][0]) As = AsNum[i][1] * Stergni_S;
                }

        }
    }

    private void EbValue() {

        switch (classBetTxt) {
            case "B10": Eb = 19000.; break;
            case "B15": Eb = 24000.; break;
            case "B20": Eb = 27500.; break;
            case "B25": Eb = 30000.; break;
            case "B30": Eb = 32500.; break;
            case "B35": Eb = 34500.; break;
            case "B40": Eb = 36000.; break;
            case "B45": Eb = 37000.; break;
            case "B50": Eb = 38000.; break;
            case "B55": Eb = 39000.; break;
            case "B60": Eb = 39500.; break;
        }
    }

    private void EsValue() {

        switch (classArmTxt_Sp) {
            case "K1400": Esp = 195000.; break;
            case "K1500": Esp = 195000.; break;
            default: Esp = 200000.; break;
        }

        switch (classArmTxt_S) {
            case "K1400": Es = 195000.; break;
            case "K1500":  Es = 195000.; break;
            default: Es = 200000.; break;
        }
    }

    private void RsnValue() {

        switch (classArmTxt_Sp) {
            case "A240": Rsn = 240.; break;
            case "A400": Rsn = 400.; break;
            case "A500": Rsn = 500.; break;
            case "A600": Rsn = 600.; break;
            case "A800": Rsn = 800.; break;
            case "A1000": Rsn = 1000.; break;
            case "B500": Rsn = 500.; break;
            case "K1400": Rsn = 1400.; break;
            case "K1500": Rsn = 1500.; break;
        }

    }

    private void EbshValue() {

        if (classBetTxt.equals("B10") || classBetTxt.equals("B15") || classBetTxt.equals("B20")|| classBetTxt.equals("B25") || classBetTxt.equals("B30") || classBetTxt.equals("B35"))
        {
            Ebsh = 0.0002;
        }

        else if (classBetTxt.equals("B40"))
        {
            Ebsh = 0.00025;
        }

        else Ebsh = 0.0003;

    }

    private void PhibValue() {

        if (Wet > 75) {
           /* Phib = 1.;
            if (classBetTxt.equals("B10")){
                Phib = 1.1;
            }*/
            switch (classBetTxt) {
                case "B10": Phib = 2.8; break;
                case "B15": Phib = 2.4; break;
                case "B20": Phib = 2.; break;
                case "B25": Phib = 1.8; break;
                case "B30": Phib = 1.6; break;
                case "B35": Phib = 1.5; break;
                case "B40": Phib = 1.4; break;
                case "B45": Phib = 1.3; break;
                case "B50": Phib = 1.2; break;
                case "B55": Phib = 1.1; break;
                case "B60": Phib = 1.; break;
            }
        }
        else if (Wet >= 40 && Wet <= 75) {
            /*Phib = 2.;
            if (classBetTxt.equals("B10")){
                Phib = 2.1;
            }*/
             switch (classBetTxt) {
                 case "B10": Phib = 3.9; break;
                 case "B15": Phib = 3.4; break;
                 case "B20": Phib = 2.8; break;
                 case "B25": Phib = 2.5; break;
                 case "B30": Phib = 2.3; break;
                 case "B35": Phib = 2.1; break;
                 case "B40": Phib = 1.9; break;
                 case "B45": Phib = 1.8; break;
                 case "B50": Phib = 1.6; break;
                 case "B55": Phib = 1.5; break;
                 case "B60": Phib = 1.4; break;
             }
        }
        else{
            /*Phib = 3.;
            if (classBetTxt.equals("B10")){
                Phib = 3.1;
            }*/
             switch (classBetTxt) {
                 case "B10": Phib = 5.6; break;
                 case "B15": Phib = 4.8; break;
                 case "B20": Phib = 4.; break;
                 case "B25": Phib = 3.6; break;
                 case "B30": Phib = 3.2; break;
                 case "B35": Phib = 3.; break;
                 case "B40": Phib = 2.8; break;
                 case "B45": Phib = 2.6; break;
                 case "B50": Phib = 2.4; break;
                 case "B55": Phib = 2.2; break;
                 case "B60": Phib = 2.; break;
             }
        }
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void Print() {

        textView_Sigma_Sp2.setText("\u03C3sp2 = " + (String.format("%.1f", + Sigma_Sp2)) + " МПа " + getString(R.string.SigmaSp2ResultText));
        textView_P.setText("P = " + (String.format("%.1f", + P)) + " кН " + getString(R.string.PResultText));
        textView_e0p.setText("e0p = " + (String.format("%.1f", + e0p)) + " мм " + getString(R.string.e0pResultText));
        textView_D_SigmaSp1.setText("\u0394\u03C3sp1 = " + (String.format("%.2f", + D_SigmaSp1)) + " МПа " + getString(R.string.DSigmaSp1ResultText));
        textView_D_SigmaSp2.setText("\u0394\u03C3sp2 = " + (String.format("%.2f", + D_SigmaSp2)) + " МПа " + getString(R.string.DSigmaSp2ResultText));
        textView_D_SigmaSp3.setText("\u0394\u03C3sp3 = " + (String.format("%.2f", + D_SigmaSp3)) + " МПа " + getString(R.string.DSigmaSp3ResultText));
        textView_D_SigmaSp4.setText("\u0394\u03C3sp4 = " + (String.format("%.2f", + D_SigmaSp4)) + " МПа " + getString(R.string.DSigmaSp4ResultText));
        textView_D_SigmaSp5.setText("\u0394\u03C3sp5 = " + (String.format("%.2f", + D_SigmaSp5)) + " МПа " + getString(R.string.DSigmaSp5ResultText));
        textView_SigmaBp.setText("\u03C3bp = " + (String.format("%.3f", + SigmaBp2)) + " МПа " + getString(R.string.SigmabpResultText));
        textView_D_SigmaSp6.setText("\u0394\u03C3sp6 = " + (String.format("%.2f", + D_SigmaSp6)) + " МПа " + getString(R.string.DSigmaSp6ResultText));

    }

    public void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_6.this);

        builder.setTitle("Предупреждение!")
                .setMessage("Введены не все данные")
                .setCancelable(false)
                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @SuppressLint("ResourceAsColor")
    public void Radiobtn1() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_6.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\nНе выбран способ натяжения арматуры.")
                .setCancelable(false)
                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @SuppressLint("ResourceAsColor")
    public void Radiobtn2() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_6.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\nНе выбрано условие твердения.")
                .setCancelable(false)
                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}