package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Task_3_1 extends AppCompatActivity {

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

    public Double b;
    public Double bf;
    public Double h;
    public Double hf;
    public Double a;
    public Double ap;
    public Double  As, Asp, Alphap, Eb, Esp, Es, Ared, y1, y2, y3, y4, Sred, y, I1, I2, I3, I4, Ired, Wred, r;

    public String classBetTxt;
    public String kolvoStTxt_Sp;
    public String diamTxt_Sp;
    public String classArmTxt_Sp;
    public String kolvoStTxt_S;
    public String diamTxt_S;
    public String classArmTxt_S;

    public EditText b_Text;
    public EditText bf_Text;
    public EditText h_Text;
    public EditText hf_Text;
    public EditText ap_Text;
    public EditText a_Text;

    public Spinner ClassBetona;
    public Spinner KolvoSt_Sp;
    public Spinner KolvoSt_S;
    public Spinner Diam_Sp;
    public Spinner Diam_S;
    public Spinner ClassArmaturi_Sp;
    public Spinner ClassArmaturi_S;

    TextView textView_Asp;
    TextView textView_As_;
    TextView textView_Ared;
    TextView textView_y;
    TextView textView_Ired;
    TextView textView_Wred;
    TextView textView_r;
    TextView textView_Eb;
    TextView textView_Esp;
    TextView textView_Es;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_3_1);

        b_Text = findViewById(R.id.b_3_1);
        bf_Text = findViewById(R.id.bf_3_1);
        h_Text = findViewById(R.id.h_3_1);
        hf_Text = findViewById(R.id.hf_3_1);
        ap_Text = findViewById(R.id.ap_3_1);
        a_Text = findViewById(R.id.a_3_1);

        textView_Asp = findViewById(R.id.Asp_3_1);
        textView_As_ = findViewById(R.id.As__3_1);
        textView_Ared = findViewById(R.id.Ared_3_1);
        textView_y = findViewById(R.id.y_3_1);
        textView_Ired = findViewById(R.id.Ired_3_1);
        textView_Wred = findViewById(R.id.Wred_3_1);
        textView_r = findViewById(R.id.r_3_1);
        textView_Eb = findViewById(R.id.Eb_3_1);
        textView_Esp = findViewById(R.id.Esp_3_1);
        textView_Es = findViewById(R.id.Es_3_1);

        ClassBetona = findViewById(R.id.ClassBetona_3_1);
        ArrayAdapter<String> classBetonaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classBetona);
        classBetonaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassBetona.setAdapter(classBetonaAdapter);

        KolvoSt_Sp = findViewById(R.id.KolvoSt_Sp_3_1);
        ArrayAdapter<String> kolvoSt_Sp_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kolvoSt);
        kolvoSt_Sp_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        KolvoSt_Sp.setAdapter(kolvoSt_Sp_Adapter);

        ClassArmaturi_Sp = findViewById(R.id.ClassArmaturi_Sp_3_1);
        ArrayAdapter<String> classArmaturi_Sp_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classArmaturi);
        classArmaturi_Sp_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassArmaturi_Sp.setAdapter(classArmaturi_Sp_Adapter);

        Diam_Sp = findViewById(R.id.Diam_Sp_3_1);
        ArrayAdapter<String> diam_Sp_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, diam);
        diam_Sp_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Diam_Sp.setAdapter(diam_Sp_Adapter);

        KolvoSt_S = findViewById(R.id.KolvoSt_S_3_1);
        ArrayAdapter<String> kolvoSt_S_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kolvoSt);
        kolvoSt_S_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        KolvoSt_S.setAdapter(kolvoSt_S_Adapter);

        ClassArmaturi_S= findViewById(R.id.ClassArmaturi_S_3_1);
        ArrayAdapter<String> classArmaturi_S_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classArmaturi);
        classArmaturi_S_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassArmaturi_S.setAdapter(classArmaturi_S_Adapter);

        Diam_S = findViewById(R.id.Diam_S_3_1);
        ArrayAdapter<String> diam_S_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, diam);
        diam_S_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Diam_S.setAdapter(diam_S_Adapter);
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
                ap_Text.getText().toString().length() == 0 || a_Text.getText().toString().length() == 0) {
            showDialog();
        } else {

            b = Double.parseDouble(b_Text.getText().toString());
            h = Double.parseDouble(h_Text.getText().toString());
            bf = Double.parseDouble(bf_Text.getText().toString());
            hf = Double.parseDouble(hf_Text.getText().toString());
            ap = Double.parseDouble(ap_Text.getText().toString());
            a = Double.parseDouble(a_Text.getText().toString());

            Stergni_Sp = Integer.parseInt(kolvoStTxt_Sp);
            Stergni_S = Integer.parseInt(kolvoStTxt_S);
            Diametr_Sp = Integer.parseInt(diamTxt_Sp);
            Diametr_S = Integer.parseInt(diamTxt_S);

            AlertDialog.Builder builder = new AlertDialog.Builder(Task_3_1.this);

            if ((classArmTxt_Sp.equals("A240") || classArmTxt_Sp.equals("A400")) && (diamTxt_Sp.equals("15"))){

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

            else if((classArmTxt_Sp.equals("A500") || classArmTxt_Sp.equals("A600")) && (diamTxt_Sp.equals("15"))){

                builder.setTitle("Предупреждение !")
                        .setMessage("Арматура Sp класса " + classArmTxt_Sp + " не может быть диаметром " + diamTxt_Sp.toString() + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32, 36, 40")
                        .setCancelable(false)
                        .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }

            else if((classArmTxt_Sp.equals("A800") || classArmTxt_Sp.equals("A1000")) && (diamTxt_Sp.equals("15") || diamTxt_Sp.equals("36") || diamTxt_Sp.equals("40"))){

                builder.setTitle("Предупреждение !")
                        .setMessage("Арматура Sp класса " + classArmTxt_Sp + " не может быть диаметром " + diamTxt_Sp.toString() + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32")
                        .setCancelable(false)
                        .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }

            else if((classArmTxt_Sp.equals("B500")) && (diamTxt_Sp.equals("14") || diamTxt_Sp.equals("15") ||
                    diamTxt_Sp.equals("16") || diamTxt_Sp.equals("18") || diamTxt_Sp.equals("20") ||
                    diamTxt_Sp.equals("22") || diamTxt_Sp.equals("25") || diamTxt_Sp.equals("28") ||
                    diamTxt_Sp.equals("32") || diamTxt_Sp.equals("36") || diamTxt_Sp.equals("40"))){

                builder.setTitle("Предупреждение !")
                        .setMessage("Арматура Sp класса " + classArmTxt_Sp + " не может быть диаметром " + diamTxt_Sp.toString() + "\n\nДопустимые диаметры:\n\n10, 12")
                        .setCancelable(false)
                        .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }

            else if(classArmTxt_Sp.equals("K1400") && (!diamTxt_Sp.equals("15"))){

                builder.setTitle("Предупреждение !")
                        .setMessage("Арматура Sp класса " + classArmTxt_Sp + " не может быть диаметром " + diamTxt_Sp.toString() + "\n\nДопустимые диаметры:\n\n15")
                        .setCancelable(false)
                        .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }

            else if(classArmTxt_Sp.equals("K1500") && (!diamTxt_Sp.equals("12"))){

                builder.setTitle("Предупреждение !")
                        .setMessage("Арматура Sp класса " + classArmTxt_Sp + " не может быть диаметром " + diamTxt_Sp.toString() + "\n\nДопустимые диаметры:\n\n12")
                        .setCancelable(false)
                        .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();

            }

            else if ((classArmTxt_S.equals("A240") || classArmTxt_S.equals("A400")) && ( diamTxt_S.equals("15"))){

                builder.setTitle("Предупреждение !")
                        .setMessage("Арматура S' класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S.toString() + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32, 36, 40")
                        .setCancelable(false)
                        .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }

            else if((classArmTxt_S.equals("A500") || classArmTxt_S.equals("A600")) && (diamTxt_S.equals("15"))){

                builder.setTitle("Предупреждение !")
                        .setMessage("Арматура S' класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S.toString() + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32, 36, 40")
                        .setCancelable(false)
                        .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }

            else if((classArmTxt_S.equals("A800") || classArmTxt_S.equals("A1000")) && (diamTxt_S.equals("15") || diamTxt_S.equals("36") || diamTxt_S.equals("40"))){

                builder.setTitle("Предупреждение !")
                        .setMessage("Арматура S' класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S.toString() + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32")
                        .setCancelable(false)
                        .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }

            else if((classArmTxt_S.equals("B500")) && (diamTxt_S.equals("14") || diamTxt_S.equals("15") ||
                    diamTxt_S.equals("16") || diamTxt_S.equals("18") || diamTxt_S.equals("20") ||
                    diamTxt_S.equals("22") || diamTxt_S.equals("25") || diamTxt_S.equals("28") ||
                    diamTxt_S.equals("32") || diamTxt_S.equals("36") || diamTxt_S.equals("40"))){

                builder.setTitle("Предупреждение !")
                        .setMessage("Арматура S' класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S.toString() + "\n\nДопустимые диаметры:\n\n10, 12")
                        .setCancelable(false)
                        .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }

            else if(classArmTxt_S.equals("K1400") && (!diamTxt_S.equals("15"))){

                builder.setTitle("Предупреждение !")
                        .setMessage("Арматура S' класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S.toString() + "\n\nДопустимые диаметры:\n\n15")
                        .setCancelable(false)
                        .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }

            else if(classArmTxt_S.equals("K1500") && (!diamTxt_S.equals("12"))){

                builder.setTitle("Предупреждение !")
                        .setMessage("Арматура S' класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S.toString() + "\n\nДопустимые диаметры:\n\n12")
                        .setCancelable(false)
                        .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();

            } else{

                EbValue();
                EsValue();
                AsValue();

                textView_Asp.setText("Asp = " + (String.format("%.1f", + Asp)) + " мм^2 " + getString(R.string.AspResultText));
                textView_As_.setText("As' = " + (String.format("%.1f", + As)) + " мм^2 " + getString(R.string.AsResultText__2));

                b /= 10;
                bf /= 10;
                h /= 10;
                hf /= 10;
                ap /= 10;
                a /= 10;Asp /= 100;
                As /= 100;

                Alphap = Es / Eb;
                Ared = bf * hf + b * (h - hf) + Alphap * Asp + Alphap * As;
                y1 = h - hf / 2;
                y2 = (h - hf) / 2;
                y3 = Alphap;
                y4 = h - a;
                Sred = bf * hf * y1 + b * (h - hf) * y2 + Alphap * Asp * y3 + Alphap * As * y4;
                y = Sred / Ared;
                I1 = bf * Math.pow(hf, 3) / 12 + bf * hf * Math.pow(Math.abs((h - hf / 2) - y), 2);
                I2 = b * Math.pow((h - hf), 3) / 12 + b * (h - hf) * Math.pow(Math.abs(y - (h - hf) / 2), 2);
                I3 = Alphap * Asp * Math.pow((y - ap), 2);
                I4 = Alphap * As * Math.pow(Math.abs((h - a) - y), 2);
                Ired = I1 + I2 + I3 + I4;
                Wred = Ired / y;
                r = Wred / Ared;

                Print();
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
            default: Esp = 200000.;
        }

        switch (classArmTxt_S) {
            case "K1400": Es = 195000.; break;
            case "K1500": Es = 195000.; break;
            default: Es = 200000.;
        }
    }

    private void AsValue() {

        switch (classArmTxt_Sp) {
            case "K1400":
                for (int i = 0; i < 1; i++) {
                    if (Diametr_Sp == AsNum_K1400[i][0]) Asp = AsNum_K1400[i][1] * Stergni_Sp;
                }
                break;
            case "K1500":
                for (int i = 0; i < 1; i++) {
                    if (Diametr_Sp == AsNum_K1500[i][0]) Asp = AsNum_K1500[i][1] * Stergni_Sp;
                }
                break;
            default:
                for (int i = 0; i < 12; i++) {
                    if (Diametr_Sp == AsNum[i][0]) Asp = AsNum[i][1] * Stergni_Sp;
                }
                break;
        }

        switch (classArmTxt_S) {
            case "K1400":
                for (int i = 0; i < 1; i++) {
                    if (Diametr_S == AsNum_K1400[i][0]) As = AsNum_K1400[i][1] * Stergni_S;
                }
                break;
            case "K1500":
                for (int i = 0; i < 1; i++) {
                    if (Diametr_S == AsNum_K1500[i][0]) As = AsNum_K1500[i][1] * Stergni_S;
                }
                break;
            default:
                for (int i = 0; i < 12; i++) {
                    if (Diametr_S == AsNum[i][0]) As = AsNum[i][1] * Stergni_S;
                }
                break;
        }

    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void Print() {

        if(Ared >= 1000){
            Ared /= Math.pow(10,4);
            textView_Ared.setText("Ared = " + (String.format("%.4f", + Ared)) + "E+6 см^2 " + getString(R.string.AredResultText));
        }
        else{
            Ared /= Math.pow(10,3);
            textView_Ared.setText("Ared = " + (String.format("%.4f", + Ared)) + "E+5 см^2 " + getString(R.string.AredResultText));
        }

        if(Ired >= 1000000){
            Ired /= Math.pow(10, 7);
            textView_Ired.setText("Ired = " + (String.format("%.4f", + Ired)) + "E+11 см^4 " + getString(R.string.IredResultText));
        }
        else{
            Ired /= Math.pow(10, 6);
            textView_Ired.setText("Ired = " + (String.format("%.4f", + Ired)) + "E+10 см^2 " + getString(R.string.IredResultText));
        }

        if(Wred >= 10000){
            Wred /= Math.pow(10, 5);
            textView_Wred.setText("Wred = " + (String.format("%.4f", + Wred)) + "E+8 см^3 " + getString(R.string.WredResultText));
        }
        else{
            Wred /= Math.pow(10, 4);
            textView_Wred.setText("Wred = " + (String.format("%.4f", + Wred)) + "E+7 см^3 " + getString(R.string.WredResultText));
        }

        textView_y.setText("y = " + (String.format("%.1f", + (y * 10))) + " мм " + getString(R.string.yResultText));
        textView_r.setText("r = " + (String.format("%.2f", + (r * 10))) + " см " + getString(R.string.rResultText));
        textView_Eb.setText("Eb = " + (String.format("%.4f", + Eb/Math.pow(10,5))) + "E+5 МПа " + getString(R.string.EbResultText));
        textView_Esp.setText("Esp = " + (String.format("%.4f", + Esp/Math.pow(10,6))) + "E+6 МПа " + getString(R.string.EspResultText));
        textView_Es.setText("Es = " + (String.format("%.4f", + Es/Math.pow(10,6))) + "E+6 МПа " + getString(R.string.EsResultText));

    }

    public void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_3_1.this);

        builder.setTitle("Ошибка!")
                .setMessage("Введены не все данные.")
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