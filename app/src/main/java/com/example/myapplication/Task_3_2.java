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

public class Task_3_2 extends AppCompatActivity {

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

    public String classBetTxt;
    public String kolvoStTxt;
    public String diamTxt;
    public String classArmTxt;

    public Double b = 0.0;
    public Double h = 0.0;
    public Double bf = 0.0;
    public Double hf = 0.0;
    public Double M = 0.0;
    public Double Rb = 0.0;
    public Double As = 0.0;
    public Double RsAs = 0.0;
    public Double Yb1 = 0.0;
    public Double Es = 0.0;
    public Double x, h0, Ksi, KsiR, Mult, Rbbfhf;


    public Integer Rs = 0;
    public Integer Stergni = 0;
    public Integer Diametr = 0;
    public Integer a;
    public Integer a1;
    public Integer a2;

    public EditText b_Text;
    public EditText bf_Text;
    public EditText h_Text;
    public EditText hf_Text;
    public EditText M_Text;

    public Spinner ClassBetona;
    public Spinner KolvoSt;
    public Spinner Diam;
    public Spinner ClassArmaturi;

    TextView textView_Mult;
    TextView textView_h0;
    TextView textView_Rb;
    TextView textView_Rs;
    TextView textView_As;
    TextView textView_x;
    TextView textView_Ksi;
    TextView textView_KsiR;
    TextView textView_Yb1;

    RadioGroup radioGroup;

    RadioButton radioButtonYb_Dl;
    RadioButton radioButtonYb_Kr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_3_2);

        b_Text = findViewById(R.id.b_3_2);
        bf_Text = findViewById(R.id.bf_3_2);
        h_Text = findViewById(R.id.h_3_2);
        hf_Text = findViewById(R.id.hf_3_2);
        M_Text = findViewById(R.id.M_3_2);

        textView_Mult = findViewById(R.id.Mult_3_2);
        textView_h0 = findViewById(R.id.h0_3_2);
        textView_Rb = findViewById(R.id.Rb_3_2);
        textView_Rs = findViewById(R.id.Rs_3_2);
        textView_As = findViewById(R.id.As_3_2);
        textView_x = findViewById(R.id.x_3_2);
        textView_Ksi = findViewById(R.id.Ksi_3_2);
        textView_KsiR = findViewById(R.id.KsiR_3_2);
        textView_Yb1 = findViewById(R.id.Yb1_3_2);

        radioGroup = findViewById(R.id.radio_group_3_2);

        radioButtonYb_Dl = findViewById(R.id.radioButton_Dl_3_2);
        radioButtonYb_Kr = findViewById(R.id.radioButton_Kr_3_2);

        ClassBetona = findViewById(R.id.ClassBetona_3_2);
        ArrayAdapter<String> classBetonaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classBetona);
        classBetonaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassBetona.setAdapter(classBetonaAdapter);

        KolvoSt = findViewById(R.id.KolvoSt_3_2);
        ArrayAdapter<String> kolvoSt_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kolvoSt);
        kolvoSt_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        KolvoSt.setAdapter(kolvoSt_Adapter);

        Diam = findViewById(R.id.Diam_3_2);
        ArrayAdapter<String> diam_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, diam);
        diam_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Diam.setAdapter(diam_Adapter);

        ClassArmaturi = findViewById(R.id.ClassArmaturi_3_2);
        ArrayAdapter<String> classArmaturi_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classArmaturi);
        classArmaturi_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassArmaturi.setAdapter(classArmaturi_Adapter);
    }

    @SuppressLint("NonConstantResourceId")
    public void Reshenie(View view) {

        classBetTxt = ClassBetona.getSelectedItem().toString();
        kolvoStTxt = KolvoSt.getSelectedItem().toString();
        diamTxt = Diam.getSelectedItem().toString();
        classArmTxt = ClassArmaturi.getSelectedItem().toString();

        if (b_Text.getText().toString().length() == 0 || h_Text.getText().toString().length() == 0 ||
                bf_Text.getText().toString().length() == 0 || hf_Text.getText().toString().length() == 0 || M_Text.getText().toString().length() == 0) {

            showDialog();

        } else {
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Radiobtn();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(Task_3_2.this);

                if ((classArmTxt.equals("A240") || classArmTxt.equals("A400")) && (diamTxt.equals("15"))){

                    builder.setTitle("Предупреждение !")
                            .setMessage("Арматура класса " + classArmTxt + " не может быть диаметром " + diamTxt + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32, 36, 40")
                            .setCancelable(false)
                            .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }

                else if((classArmTxt.equals("A500") || classArmTxt.equals("A600")) && ( diamTxt.equals("15"))){

                    builder.setTitle("Предупреждение !")
                            .setMessage("Арматура класса " + classArmTxt + " не может быть диаметром " + diamTxt + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32, 36, 40")
                            .setCancelable(false)
                            .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }

                else if((classArmTxt.equals("A800") || classArmTxt.equals("A1000")) && (diamTxt.equals("15") || diamTxt.equals("36") || diamTxt.equals("40"))){

                    builder.setTitle("Предупреждение !")
                            .setMessage("Арматура класса " + classArmTxt + " не может быть диаметром " + diamTxt + "\n\nДопустимые диаметры:\n\n10, 12, 14, 16, 18, 20, 22, 25, 28, 32")
                            .setCancelable(false)
                            .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }

                else if((classArmTxt.equals("B500")) && (diamTxt.equals("14") || diamTxt.equals("15") || diamTxt.equals("16") ||
                        diamTxt.equals("18") || diamTxt.equals("20") || diamTxt.equals("22") || diamTxt.equals("25") ||
                        diamTxt.equals("28") || diamTxt.equals("32") || diamTxt.equals("36") || diamTxt.equals("40"))){

                    builder.setTitle("Предупреждение !")
                            .setMessage("Арматура класса " + classArmTxt + " не может быть диаметром " + diamTxt + "\n\nДопустимые диаметры:\n\n10, 12")
                            .setCancelable(false)
                            .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }

                else if(classArmTxt.equals("K1400") && (!diamTxt.equals("15"))){

                    builder.setTitle("Предупреждение !")
                            .setMessage("Арматура класса " + classArmTxt + " не может быть диаметром " + diamTxt + "\n\nДопустимые диаметры:\n\n15")
                            .setCancelable(false)
                            .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();
                }

                else if(classArmTxt.equals("K1500") && (!diamTxt.equals("12"))){

                    builder.setTitle("Предупреждение !")
                            .setMessage("Арматура класса " + classArmTxt + " не может быть диаметром " + diamTxt + "\n\nДопустимые диаметры:\n\n12")
                            .setCancelable(false)
                            .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();

                } else {

                    Stergni = Integer.parseInt(kolvoStTxt);
                    Diametr = Integer.parseInt(diamTxt);

                    b = Double.parseDouble(b_Text.getText().toString());
                    h = Double.parseDouble(h_Text.getText().toString());
                    bf = Double.parseDouble(bf_Text.getText().toString());
                    hf = Double.parseDouble(hf_Text.getText().toString());
                    M = Double.parseDouble(M_Text.getText().toString());

                    int checkedButtonIndex = radioGroup.getCheckedRadioButtonId();

                    switch (checkedButtonIndex) {

                        case R.id.radioButton_Kr_3_2:

                            Yb1 = 1.0;
                            Rb = RbValue(Rb);
                            break;

                        case R.id.radioButton_Dl_3_2:

                            Yb1 = 0.9;
                            Rb = RbValue(Rb) * Yb1;
                            break;
                    }
                    Rs = RsValue(Rs);

                    AsValue();
                    a1a2Value();

                    if (Stergni > 3) {

                        a = a1 + a2 / 2 + Diametr / 2;
                    } else {

                        a = a1 + Diametr / 2;
                    }

                    h0 = h - a;

                    RsAs = Rs * As;
                    Rbbfhf = Rb * bf * hf;

                    if (RsAs <= Rbbfhf) {

                        b = bf;
                        x = (Rs * As) / (Rb * bf);
                        Ksi = x / h0;
                        KsiRValue();

                        //  if (Ksi <= KsiR)
                        if (Ksi > KsiR) {

                            textView_Ksi.setText("\u03BE = " + (String.format("%.3f", +Ksi)) + " " + getString(R.string.KsiResultText));
                            Ksi = KsiR;
                            x = KsiR * h0;
                        } else {
                            textView_Ksi.setText("\u03BE  = " + (String.format("%.3f", +Ksi)) + " " + getString(R.string.KsiResultText));
                        }

                        Mult = (Rb * b * x * (h0 - 0.5 * x)) / Math.pow(10, 6);
                        Print();
                        if(M <= Mult){
                            Toast toast = Toast.makeText(Task_3_2.this, "Несущая способность обеспечена", Toast.LENGTH_LONG);
                            toast.show();
                        }
                        else Mult_Dialog();
                    }

                    if (RsAs > Rbbfhf) {

                        x = (Rs * As - Rb * (bf - b) * hf) / (Rb * b);
                        Ksi = x / h0;
                        KsiRValue();

                        //if (Ksi <= KsiR)
                        if (Ksi > KsiR) {

                            KsiKsiR_Dialog();
                        } else {
                            textView_Ksi.setText("\u03BE  = " + (String.format("%.3f", +Ksi)) + " " + getString(R.string.KsiResultText));
                            Mult = (Rb * (bf - b) * hf * (h0 - 0.5 * hf) + Rb * b * x * (h0 - 0.5 * x)) / Math.pow(10, 6);
                            Print();
                            if(M <= Mult){
                                Toast toast = Toast.makeText(Task_3_2.this, "Несущая способность обеспечена", Toast.LENGTH_LONG);
                                toast.show();
                            }
                            else Mult_Dialog();
                        }
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

        switch (classArmTxt) {
            case "A240": Rs = 210; break;
            case "A400": Rs = 350; break;
            case "A500": Rs = 435; break;
            case "A600": Rs = 520; break;
            case "A800": Rs = 695; break;
            case "A1000": Rs = 870; break;
            case "B500": Rs = 435; break;
            case "K1400": Rs = 1215; break;
            case "K1500": Rs = 1300; break;
        }
        return Rs;
    }

    private void AsValue() {

        switch (classArmTxt){
            case "K1400":

                for (int i = 0; i < 1; i++) {
                    if (Diametr == AsNum_K1400[i][0]) As = AsNum_K1400[i][1] * Stergni;
                }
                break;

            case "K1500":

                for (int i = 0; i < 1; i++) {
                    if (Diametr == AsNum_K1500[i][0]) As = AsNum_K1500[i][1] * Stergni;
                }
                break;

            default:

                for (int i = 0; i < 12; i++) {
                    if (Diametr == AsNum[i][0]) As = AsNum[i][1] * Stergni;
                }
                break;

        }
    }

    private  void a1a2Value() {

        for (int i = 0; i < 13; i++)
        {
            if (Diametr.equals(a2Value[0][i])) a2 = a2Value [1][i];
        }

        if (Diametr > 20) a1 = Diametr;
        else a1 = 20;
    }

    private void EsValue() {

        switch (classArmTxt) {
            case "K1400": Es = 195000.; break;
            case "K1500": Es = 195000.; break;
            default: Es = 200000.;
        }
    }

    private void KsiRValue() {

        switch (classArmTxt) {
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
        textView_Rb.setText("Rb = " + String.format("%.2f", + Rb) + " Ма " + getString(R.string.RbResultText));
        textView_As.setText("As = " + (String.format("%.0f", + As)) + " мм^2 " + getString(R.string.AsResultText_2));
        textView_Rs.setText("Rs = " + Rs.toString() + " МПа " + getString(R.string.RsResultText));
        textView_x.setText("x =  " + String.format("%.1f", + x) + " мм " + getString(R.string.xResultText));
        textView_KsiR.setText("\u03BER = " + (String.format("%.3f", + KsiR)) + " " + getString(R.string.KsiRResultText));
        textView_Yb1.setText("Yb1 =  " + (String.format("%.1f", + Yb1)) + " " + getString(R.string.Yb1ResultText));

    }

    public void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_3_2.this);

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

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_3_2.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\n\u03BE = " + String.format("%.3f", + Ksi) + " > \u03BER = " + String.format("%.3f", + KsiR) + " \n\nНеобходимо изменить размеры поперечного сечения или увеличить классы материалов и повторить расчёт.")
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

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_3_2.this);

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

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_3_2.this);

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