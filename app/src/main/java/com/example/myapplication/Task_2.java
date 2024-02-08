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
import android.widget.Toast;

public class Task_2 extends AppCompatActivity {

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

    public Integer[][] a2Value = {{10, 12, 14, 15, 16, 18, 20, 22, 25, 28, 32, 36, 40},
            {40, 50, 50, 50, 50, 50, 60, 60, 60, 70, 70, 80, 80}};

    public Integer Rs = 0;
    public Integer Rsc = 0;
    public Integer Stergni_S = 0;
    public Integer Diametr_S = 0;
    public Integer Stergni_S_ = 0;
    public Integer Diametr_S_ = 0;

    public Double b = 0.0;
    public Double h = 0.0;
    public Double M = 0.0;
    public Double a, a_, a2, a1, a1_, a2_;
    public Double Rb = 0.0;
    public Double As = 0.0;
    public Double As_ = 0.0;
    public Double Yb1 = 0.0;
    public Double Es = 0.0;
    public Double x, h0, Ksi, KsiR, Mult;

    public String classBetTxt;
    public String kolvoStTxt_S;
    public String diamTxt_S;
    public String classArmTxt_S;
    public String kolvoStTxt_S_;
    public String diamTxt_S_;
    public String classArmTxt_S_;

    public EditText bText;
    public EditText hText;
    public EditText MText;

    public Spinner ClassBetona;
    public Spinner KolvoSt_S;
    public Spinner KolvoSt_S_;
    public Spinner Diam_S;
    public Spinner Diam_S_;
    public Spinner ClassArmaturi_S;
    public Spinner ClassArmaturi_S_;

    TextView textView_Mult;
    TextView textView_h0;
    TextView textView_Rb;
    TextView textView_Rs;
    TextView textView_As;
    TextView textView_Rsc;
    TextView textView_As_;
    TextView textView_x;
    TextView textView_Yb1;

    RadioGroup radioGroup;

    RadioButton radioButtonYb_Dl;
    RadioButton radioButtonYb_Kr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_2);

        bText = findViewById(R.id.b_2);
        hText = findViewById(R.id.h_2);
        MText = findViewById(R.id.M_2);

        textView_Mult = findViewById(R.id.Mult_2);
        textView_h0 = findViewById(R.id.h0_2);
        textView_Rb = findViewById(R.id.Rb_2);
        textView_As = findViewById(R.id.As_2);
        textView_Rs = findViewById(R.id.Rs_2);
        textView_As_ = findViewById(R.id.As__2);
        textView_Rsc = findViewById(R.id.Rsc_2);
        textView_x = findViewById(R.id.x_2);
        textView_Yb1 = findViewById(R.id.Yb1_2);

        radioGroup = findViewById(R.id.radio_group_2);
        radioButtonYb_Dl = findViewById(R.id.radioButton_Dl_2);
        radioButtonYb_Kr = findViewById(R.id.radioButton_Kr_2);

        ClassBetona = findViewById(R.id.ClassBetona_2);
        ArrayAdapter<String> classBetonaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classBetona);
        classBetonaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassBetona.setAdapter(classBetonaAdapter);

        KolvoSt_S = findViewById(R.id.KolvoSt_S);
        ArrayAdapter<String> kolvoSt_S_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kolvoSt);
        kolvoSt_S_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        KolvoSt_S.setAdapter(kolvoSt_S_Adapter);

        Diam_S = findViewById(R.id.Diam_S);
        ArrayAdapter<String> diam_S_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, diam);
        diam_S_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Diam_S.setAdapter(diam_S_Adapter);

        ClassArmaturi_S = findViewById(R.id.ClassArmaturi_S);
        ArrayAdapter<String> classArmaturi_S_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classArmaturi);
        classArmaturi_S_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassArmaturi_S.setAdapter(classArmaturi_S_Adapter);

        KolvoSt_S_ = findViewById(R.id.KolvoSt_S_);
        ArrayAdapter<String> kolvoSt_S__Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kolvoSt);
        kolvoSt_S__Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        KolvoSt_S_.setAdapter(kolvoSt_S__Adapter);

        Diam_S_ = findViewById(R.id.Diam_S_);
        ArrayAdapter<String> diam_S__Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, diam);
        diam_S__Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Diam_S_.setAdapter(diam_S__Adapter);

        ClassArmaturi_S_ = findViewById(R.id.ClassArmaturi_S_);
        ArrayAdapter<String> classArmaturi_S__Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classArmaturi);
        classArmaturi_S__Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassArmaturi_S_.setAdapter(classArmaturi_S_Adapter);

    }

    @SuppressLint("NonConstantResourceId")
    public void Reshenie(View view) {

        if (bText.getText().toString().length() == 0 || hText.getText().toString().length() == 0 || MText.getText().toString().length() == 0) {
            showDialog();
        } else {
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Radiobtn();
            } else {
                classBetTxt = ClassBetona.getSelectedItem().toString();
                kolvoStTxt_S = KolvoSt_S.getSelectedItem().toString();
                kolvoStTxt_S_ = KolvoSt_S_.getSelectedItem().toString();
                diamTxt_S = Diam_S.getSelectedItem().toString();
                diamTxt_S_ = Diam_S_.getSelectedItem().toString();
                classArmTxt_S = ClassArmaturi_S.getSelectedItem().toString();
                classArmTxt_S_ = ClassArmaturi_S_.getSelectedItem().toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(Task_2.this);

                if ((classArmTxt_S.equals("A240") || classArmTxt_S.equals("A400")) && (diamTxt_S.equals("15"))){

                    builder.setTitle("Предупреждение !")
                            .setMessage("Арматура класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32, 36, 40")
                            .setCancelable(false)
                            .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }

                else if((classArmTxt_S.equals("A500") || classArmTxt_S.equals("A600")) && ( diamTxt_S.equals("15"))){

                    builder.setTitle("Предупреждение !")
                            .setMessage("Арматура класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S+ "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32, 36, 40")
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
                            .setMessage("Арматура класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32")
                            .setCancelable(false)
                            .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }

                else if((classArmTxt_S.equals("B500")) && (diamTxt_S.equals("14") || diamTxt_S.equals("15") || diamTxt_S.equals("16") ||
                        diamTxt_S.equals("18") || diamTxt_S.equals("20") || diamTxt_S.equals("22") || diamTxt_S.equals("25") ||
                        diamTxt_S.equals("28") || diamTxt_S.equals("32") || diamTxt_S.equals("36") || diamTxt_S.equals("40"))){

                    builder.setTitle("Предупреждение !")
                            .setMessage("Арматура класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S + "\n\nДопустимые диаметры:\n\n10, 12")
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
                            .setMessage("Арматура класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S + "\n\nДопустимые диаметры:\n\n15")
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
                            .setMessage("Арматура класса " + classArmTxt_S + " не может быть диаметром " + diamTxt_S + "\n\nДопустимые диаметры:\n\n12")
                            .setCancelable(false)
                            .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if ((classArmTxt_S_.equals("A240") || classArmTxt_S_.equals("A400")) && (diamTxt_S_.equals("15"))){

                    builder.setTitle("Предупреждение !")
                            .setMessage("Арматура класса " + classArmTxt_S_ + " не может быть диаметром " + diamTxt_S_ + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32, 36, 40")
                            .setCancelable(false)
                            .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }

                else if((classArmTxt_S_.equals("A500") || classArmTxt_S_.equals("A600")) && ( diamTxt_S_.equals("15"))){

                    builder.setTitle("Предупреждение !")
                            .setMessage("Арматура класса " + classArmTxt_S_ + " не может быть диаметром " + diamTxt_S_ + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32, 36, 40")
                            .setCancelable(false)
                            .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }

                else if((classArmTxt_S_.equals("A800") || classArmTxt_S_.equals("A1000")) && (diamTxt_S_.equals("15") || diamTxt_S_.equals("36") || diamTxt_S_.equals("40"))){

                    builder.setTitle("Предупреждение !")
                            .setMessage("Арматура класса " + classArmTxt_S_ + " не может быть диаметром " + diamTxt_S_ + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32")
                            .setCancelable(false)
                            .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }

                else if((classArmTxt_S_.equals("B500")) && (diamTxt_S_.equals("14") || diamTxt_S_.equals("15") || diamTxt_S_.equals("16") ||
                        diamTxt_S_.equals("18") || diamTxt_S_.equals("20") || diamTxt_S_.equals("22") || diamTxt_S_.equals("25") ||
                        diamTxt_S_.equals("28") || diamTxt_S_.equals("32") || diamTxt_S_.equals("36") || diamTxt_S_.equals("40"))){

                    builder.setTitle("Предупреждение !")
                            .setMessage("Арматура класса " + classArmTxt_S_ + " не может быть диаметром " + diamTxt_S + "\n\nДопустимые диаметры:\n\n10, 12")
                            .setCancelable(false)
                            .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }

                else if(classArmTxt_S_.equals("K1400") && (!diamTxt_S_.equals("15"))){

                    builder.setTitle("Предупреждение !")
                            .setMessage("Арматура класса " + classArmTxt_S_ + " не может быть диаметром " + diamTxt_S_ + "\n\nДопустимые диаметры:\n\n15")
                            .setCancelable(false)
                            .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }

                else if(classArmTxt_S_.equals("K1500") && (!diamTxt_S_.equals("12"))){

                    builder.setTitle("Предупреждение !")
                            .setMessage("Арматура класса " + classArmTxt_S_ + " не может быть диаметром " + diamTxt_S_ + "\n\nДопустимые диаметры:\n\n12")
                            .setCancelable(false)
                            .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();

                } else {

                    b = Double.parseDouble(bText.getText().toString());
                    h = Double.parseDouble(hText.getText().toString());
                    M = Double.parseDouble(MText.getText().toString());

                    Stergni_S = Integer.parseInt(kolvoStTxt_S);
                    Stergni_S_ = Integer.parseInt(kolvoStTxt_S_);
                    Diametr_S = Integer.parseInt(diamTxt_S);
                    Diametr_S_ = Integer.parseInt(diamTxt_S_);

                    int checkedButtonIndex = radioGroup.getCheckedRadioButtonId();

                    switch (checkedButtonIndex) {

                        case R.id.radioButton_Kr_2:

                            Yb1 = 1.0;
                            Rb = RbValue(Rb);
                            break;

                        case R.id.radioButton_Dl_2:

                            Yb1 = 0.9;
                            Rb = RbValue(Rb) * Yb1;
                            break;
                    }

                    //Rb = RbValue(Rb);
                    Rs = RsValue(Rs);
                    Rsc = RscValue(Rsc);

                    AsValue();
                    a1a2Value();

                    if (Stergni_S > 3) {

                        a = a1 + a2 / 2 + Diametr_S / 2;
                    } else {

                        a = a1 + Diametr_S / 2;
                    }

                    if (Stergni_S_ > 3) a_ = a1_ + a2 / 2 + Diametr_S / 2;
                    else a_ = a1_ + Diametr_S_ / 2;

                    h0 = h - a;
                    x = (Rs * As - Rsc * As_) / (Rb * b);
                    Ksi = x / h0;

                    KsiRValue();

                    /* if (Ksi <= KsiR)*/
                    if (Ksi > KsiR) {

                        KsiKsiR_Dialog();

                    } else {

                        Mult = (Rb * b * x * (h0 - 0.5 * x) + Rsc * As_ * (h0 - a_)) / Math.pow(10, 6);
                        Print();
                        if(M <= Mult){
                            Toast toast = Toast.makeText(Task_2.this, "Несущая способность обеспечена", Toast.LENGTH_LONG);
                            toast.show();
                        }
                        else Mult_Dialog();
                    }
                }
            }
        }
    }

    private Double RbValue(double Rb) {
        switch (classBetTxt) {
            case "B10": Rb = 6.; break;
            case "B15": Rb = 8.5; break;
            case "B20": Rb = 11.5; break;
            case "B25": Rb = 14.5; break;
            case "B30": Rb = 17.0; break;
            case "B35": Rb = 19.5; break;
            case "B40": Rb = 22.0; break;
            case "B45": Rb = 25.0; break;
            case "B50": Rb = 27.5; break;
            case "B55": Rb = 30.0; break;
            case "B60": Rb = 35.0; break;
        }

        return Rb;
    }

    private int RsValue(int Rs) {
        switch (classArmTxt_S) {
            case "A240": Rs = 210; break;
            case "A400": Rs = 350; break;
            case "A500": Rs = 435; break;
            case "A600": Rs = 520; break;
            case "A800": Rs = 695; break;
            case "A1000": Rs = 870; break;
            case "B500": Rs = 435; break;
            case "Bp500": Rs = 415; break;
            case "K1400": Rs = 1215; break;
            case "K1500": Rs = 1300; break;
        }

        return Rs;
    }

    private int RscValue(int Rsc) {
        switch (classArmTxt_S_) {
            case "A240": Rsc = 210; break;
            case "A400": Rsc = 350; break;
            case "A500": Rsc = 400; break;
            case "A600": Rsc = 400; break;
            case "A800": Rsc = 400; break;
            case "A1000": Rsc = 400; break;
            case "B500": Rsc = 380; break;
            case "Bp500": Rsc = 350; break;
        }

        return Rsc;
    }

    private void AsValue() {

        switch (classArmTxt_S){
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

        switch (classArmTxt_S_){
            case "K1400":

                for (int i = 0; i < 1; i++) {
                    if (Diametr_S_ == AsNum_K1400[i][0]) As_ = AsNum_K1400[i][1] * Stergni_S_;
                }
                break;

            case "K1500":

                for (int i = 0; i < 1; i++) {
                    if (Diametr_S_ == AsNum_K1500[i][0]) As_ = AsNum_K1500[i][1] * Stergni_S_;
                }
                break;

            default:

                for (int i = 0; i < 12; i++) {
                    if (Diametr_S_ == AsNum[i][0]) As_ = AsNum[i][1] * Stergni_S_;
                }
                break;

        }
    }

    private  void a1a2Value() {

        for (int i = 0; i < 13; i++)
        {
            if (Diametr_S.equals(a2Value[0][i])) a2 = (double) a2Value [1][i];
            if (Diametr_S_.equals(a2Value[0][i])) a2_ = (double) a2Value [1][i];
        }

        if (Diametr_S > 20) a1 = (double) Diametr_S;
        else a1 = 20.;

        if (Diametr_S_ > 20) a1_ = (double) Diametr_S_;
        else a1_ = 20.;
    }

    private void EsValue() {

        switch (classArmTxt_S) {
            case "K1400": Es = 195000.; break;
            case "K1500": Es = 195000.; break;
            default: Es = 200000.;
        }
    }

    private void KsiRValue() {

        switch (classArmTxt_S) {
            case "A240": KsiR = 0.612; break;
            case "A300": KsiR = 0.577; break;
            case "A400": KsiR = 0.531; break;
            case "A500": KsiR = 0.493; break;
            case "B400": KsiR = 0.502; break;
            default:
                EsValue();
                KsiR = 0.8/(1+(Rs/Es)/0.0035);
                break;
        }

    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void Print() {

        textView_Mult.setText("Mult =  " + String.format("%.1f", + Mult) + " кН*м " + getString(R.string.MultResultText));
        textView_h0.setText("h0 =  " + String.format("%.0f", + h0) + " мм " + getString(R.string.h0ResultText));
        textView_Rb.setText("Rb = " + String.format("%.2f", + Rb) + " МПа " + getString(R.string.RbResultText));
        textView_As.setText("As = " + (String.format("%.0f", + As)) + " мм^2 " + getString(R.string.AsResultText_2));
        textView_Rs.setText("Rs = " + Rs.toString() + " МПа " + getString(R.string.RsResultText));
        textView_As_.setText("A's = " + (String.format("%.0f", + As_)) + " мм^2 " + getString(R.string.AsResultText_));
        textView_Rsc.setText("Rs = " + Rsc.toString() + " МПа " + getString(R.string.RscResultText));
        textView_x.setText("x =  " + String.format("%.1f", + x) + " мм " + getString(R.string.xResultText));
        textView_Yb1.setText("Yb1 =  " + (String.format("%.1f", + Yb1)) + " " + getString(R.string.Yb1ResultText));
    }

    public void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_2.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\nВведены не все данные.")
                .setCancelable(false)
                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @SuppressLint("DefaultLocale")
    public void KsiKsiR_Dialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_2.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\n\u03BE = " + String.format("%.3f", + Ksi) + " > \u03BER = " + String.format("%.3f", + KsiR) + " \n\nНеобходимо увеличить площадь арматуры As' и увеличить расчёт.")
                .setCancelable(false)
                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @SuppressLint({"DefaultLocale"})
    public void Mult_Dialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_2.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\nM = " + String.format("%.1f", + M) + "кН*м > Mult = " + String.format("%.1f", + Mult) + "кН*м.\n\nНесущая способность не обеспечена.")
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
    public void Radiobtn() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_2.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\nНе выбран тип нагрузки.")
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