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

public class Task_1_1 extends AppCompatActivity {

    public String[] classArmaturi = {"A240", "A400", "A500", "A600", "A800", "A1000", "B500", "K1400", "K1500"};
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
    public String classArmTxt;
    public String kolvoStTxt;

    public Double b = 0.0;
    public Double h = 0.0;
    public Double M = 0.0;
    public Double Rb = 0.0;
    public Double a = 0.;
    public Double a1 = 0.;
    public Double a2 = 0.;
    public Double aR = 0.0;
    public Double As = 0.0;
    public Double As1 = 0.0;
    public Double Yb1 = 0.0;
    public Double Es = 0.0;
    public Double KsiR = 0.0;
    public Double h0, am, x, Mult;

    public Integer Rs = 0;
    public Integer Stergni = 0;
    public Integer Diametr = 0;

    public Boolean Errors = false;

    public EditText bText;
    public EditText hText;
    public EditText MText;

    public Spinner ClassBetona;
    public Spinner ClassArmaturi;
    public Spinner KolvoSt;

    TextView textView_As;
    TextView textView_DmTxt;
    TextView textView_Rb;
    TextView textView_Rs;
    TextView textView_am;
    TextView textView_aR;
    TextView textView_Yb1;
    TextView textView_Mult;
    TextView textView_h0;
    TextView textView_x;

    RadioGroup radioGroup;

    RadioButton radioButtonYb_Dl;
    RadioButton radioButtonYb_Kr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_1_1);

        bText = findViewById(R.id.b_1_1);
        hText = findViewById(R.id.h_1_1);
        MText = findViewById(R.id.M_1_1);

        textView_As = findViewById(R.id.As_1_1);
        textView_DmTxt = findViewById(R.id.DmTxt_1_1);
        textView_Rb = findViewById(R.id.Rb_1_1);
        textView_Rs = findViewById(R.id.Rs_1_1);
        textView_am = findViewById(R.id.am_1_1);
        textView_aR = findViewById(R.id.aR_1_1);
        textView_Yb1 = findViewById(R.id.Yb_1_1);
        textView_Mult = findViewById(R.id.Mult_1_1);
        textView_h0 = findViewById(R.id.h0_1_1);
        textView_x = findViewById(R.id.x_1_1);

        radioGroup = findViewById(R.id.radio_group_1_1);
        radioButtonYb_Dl = findViewById(R.id.radioButton_Dl_1_1);
        radioButtonYb_Kr = findViewById(R.id.radioButton_Kr_1_1);

        ClassBetona = findViewById(R.id.ClassBetona_1_1);
        ArrayAdapter<CharSequence> classBetonaAdapter = ArrayAdapter.createFromResource(this,R.array.ClassBetona, android.R.layout.simple_spinner_item);
        classBetonaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassBetona.setAdapter(classBetonaAdapter);

        ClassArmaturi = findViewById(R.id.ClassArmaturi_1_1);
        ArrayAdapter<String> classArmaturiAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classArmaturi);
        classArmaturiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassArmaturi.setAdapter(classArmaturiAdapter);

        KolvoSt = findViewById(R.id.KolvoSt_1_1);
        ArrayAdapter<CharSequence> kolvoStAdapter = ArrayAdapter.createFromResource(this,R.array.KolvoSt, android.R.layout.simple_spinner_item);
        kolvoStAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        KolvoSt.setAdapter(kolvoStAdapter);
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n", "DefaultLocale"})
    public void Reshenie(View view) {

        if (bText.getText().toString().length() == 0 || hText.getText().toString().length() == 0 || MText.getText().toString().length() == 0) {
            EmptyDialog();

        } else {
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Radiobtn();
            } else {
                classBetTxt = ClassBetona.getSelectedItem().toString();
                classArmTxt = ClassArmaturi.getSelectedItem().toString();
                kolvoStTxt = KolvoSt.getSelectedItem().toString();
                b = Double.parseDouble(bText.getText().toString());
                h = Double.parseDouble(hText.getText().toString());
                M = Double.parseDouble(MText.getText().toString());
                Stergni = Integer.parseInt(kolvoStTxt);

                int checkedButtonIndex = radioGroup.getCheckedRadioButtonId();
                switch (checkedButtonIndex) {
                    case R.id.radioButton_Kr_1_1:
                        Yb1 = 1.;
                        Rb = RbValue(Rb);
                        break;
                    case R.id.radioButton_Dl_1_1:
                        Yb1 = 0.9;
                        Rb = RbValue(Rb) * Yb1;
                        break;
                }
                Rs = RsValue(Rs);
                if (Stergni > 3) a = 60.;
                else a = 30.;
                h0 = h - a;
                am = (M * Math.pow(10., 6.)) / (Rb * b * Math.pow(h0, 2.));
                aR = aRValue(aR);
                if (am > aR){
                    Alpham_R_Dialog();
                }
                else{
                    As = (Rb * b * h0 * (1 - Math.sqrt(1 - (2 * am)))) / Rs;
                    AsValue();
                    if(Errors.equals(false)){
                        a1a2Value();
                        if (Stergni > 3) a = a1 + a2 / 2 + Diametr / 2;
                        else a = a1 + Diametr / 2;
                        h0 = h - a;
                        x = (Rs * As1) / (Rb * b);
                        Mult = (Rb * b * x * (h0 - 0.5 * x)) / Math.pow(10., 6);
                        Print();
                        if(M <= Mult){
                            Toast toast = Toast.makeText(Task_1_1.this, "Несущая способность обеспечена", Toast.LENGTH_LONG);
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

        switch (classArmTxt) {
            case "K1400":

                As1 = AsNum_K1400[0][1] * Stergni;
                if (As1 < As) {
                    As_Dialog();
                    Errors = true;
                } else {
                    Diametr = (int) AsNum_K1400[0][0];
                    Errors = false;
                }
                break;

            case "K1500":
                As1 = AsNum_K1500[0][1] * Stergni;
                if (As1 < As) {
                    As_Dialog();
                    Errors = true;

                } else {
                    Diametr = (int) AsNum_K1500[0][0];
                    Errors = false;
                }

                break;

            default:
                int i = 0;
                while (i < 12) {

                    As1 = AsNum[i][1] * Stergni;

                    if ((As1 < As) && i == 11) {

                        As_Dialog();
                        Errors = true;
                        break;
                    }
                    else if (As1 >= As) {
                        Diametr = (int) AsNum[i][0];
                        Errors = false;
                        break;
                    }
                    i++;
                }
        }
    }

    private void EsValue() {
        switch (classArmTxt) {
            case "K1400":
                Es = 195000.;
                break;
            case "K1500":
                Es = 195000.;
                break;
            default:
                Es = 200000.;
        }
    }

    private void KsiRValue() {

        switch (classArmTxt) {
            case "A240":
                KsiR = 0.612;
                break;
            case "A300":
                KsiR = 0.577;
                break;
            case "A400":
                KsiR = 0.531;
                break;
            case "A500":
                KsiR = 0.493;
                break;
            case "B400":
                KsiR = 0.502;
                break;
            default:
                EsValue();
                KsiR = 0.8/(1+(Rs/Es)/0.0035);
                break;
        }
    }

    private Double aRValue(double aR) {

        switch (classArmTxt) {
            case "A240":
                aR = 0.425;
                break;
            case "A400":
                aR = 0.390;
                break;
            case "A500":
                aR = 0.372;
                break;
            case "B500":
                aR = 0.376;
                break;
            default:
                KsiRValue();
                aR = KsiR * (1 - 0.5 * KsiR);
                break;
        }
        return aR;
    }

    private void a1a2Value() {

        for (int i = 0; i < 13; i++) {
            if (Diametr.equals(a2Value[0][i])) a2 = (double) a2Value[1][i];
        }

        if (Diametr > 20) a1 = (double) Diametr;
        else a1 = 20.;
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void Print() {

        textView_As.setText("As = " + (String.format("%.0f", + As)) + " мм^2 " + getString(R.string.AsResultText_1));
        textView_DmTxt.setText("ф = " + Diametr.toString() + " мм " + getString(R.string.DiamResultText));
        textView_Rb.setText("Rb = " + String.format("%.2f", + Rb) + " МПа " + getString(R.string.RbResultText));
        textView_Rs.setText("Rs = " + Rs.toString() + " МПа " + getString(R.string.RsResultText));
        textView_am.setText("\u237Am = " + (String.format("%.3f", + am)) + " " + getString(R.string.AlphamResultText));
        textView_aR.setText("\u237AR = " + (String.format("%.3f", + aR)) + " " + getString(R.string.AlphaRResultText));
        textView_Yb1.setText("Yb1 =  " + (String.format("%.1f", + Yb1)) + " " + getString(R.string.Yb1ResultText));
        textView_Mult.setText("Mult =  " + String.format("%.1f", + Mult) + " кН*м " + getString(R.string.MultResultText));
        textView_h0.setText("h0 =  " + String.format("%.0f", + h0) + " мм " + getString(R.string.h0ResultText));
        textView_x.setText("x =  " + String.format("%.1f", + x) + " мм " + getString(R.string.xResultText));
    }

    @SuppressLint("ResourceAsColor")
    public void EmptyDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_1_1.this);

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

    @SuppressLint("ResourceAsColor")
    public void Radiobtn() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_1_1.this);

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

    @SuppressLint("DefaultLocale")
    public void Alpham_R_Dialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_1_1.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\n\u237Am = " + String.format("%.3f", + am) + " > \u237AR = " + String.format("%.3f", + aR) + " \n\nНеобходимо увеличить размеры поперечного сечения элемента или повысить класс бетона и повторить расчёт.")
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
    public void As_Dialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_1_1.this);

        builder.setTitle("Предупреждение !")
                .setMessage("Подобранное значение As = " + String.format("%.1f", + As1)  + " мм^2 < As = " +  String.format("%.1f", + As) + " мм^2, полученого при расчете.\n\nНеобходимо увеличить количество стержней и повторить расчёт.")
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

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_1_1.this);

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

}