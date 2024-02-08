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

public class Task_3_3 extends AppCompatActivity {

    public String[] classBetona = {"B10", "B15", "B20", "B25", "B30", "B35", "B40", "B45", "B50", "B55", "B60"};
    public String[] classArmaturi = {"A240", "A400", "A500", "A600", "A800", "A1000", "B500", "K1400", "K1500"};
    public String[] kolvoSt = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

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
    public String classArmTxt;

    public Double b = 0.0;
    public Double bf = 0.0;
    public Double hf = 0.0;
    public Double M = 0.0;
    public Double Rb = 0.0;
    public Double aR = 0.0;
    public Double am = 0.0;
    public Double As = 0.0;
    public Double As1 = 0.0;
    public Double RsAs = 0.0;
    public Double Yb1 = 0.0;
    public Double Es = 0.0;
    public Double x, Ksi, KsiR, Mult, Rbbfhf;


    public Integer Rs = 0;
    public Integer Stergni = 0;
    public Integer Diametr = 0;
    public Integer a;
    public Integer a1;
    public Integer a2;
    public Integer a_, h0_, h, h0;

    public Boolean Errors = false;

    public EditText b_Text;
    public EditText bf_Text;
    public EditText h_Text;
    public EditText hf_Text;
    public EditText M_Text;

    public Spinner ClassBetona;
    public Spinner KolvoSt;
    public Spinner ClassArmaturi;

    TextView textView_As;
    TextView textView_DmTxt;
    TextView textView_Rb;
    TextView textView_Rs;
    TextView textView_am;
    TextView textView_aR;
    TextView textView_Yb1;


    RadioGroup radioGroup;

    RadioButton radioButtonYb_Dl;
    RadioButton radioButtonYb_Kr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_3_3);

        b_Text = findViewById(R.id.b_3_3);
        bf_Text = findViewById(R.id.bf_3_3);
        h_Text = findViewById(R.id.h_3_3);
        hf_Text = findViewById(R.id.hf_3_3);
        M_Text = findViewById(R.id.M_3_3);

        textView_As = findViewById(R.id.As_3_3);
        textView_DmTxt = findViewById(R.id.DmTxt_3_3);
        textView_Rb = findViewById(R.id.Rb_3_3);
        textView_Rs = findViewById(R.id.Rs_3_3);
        textView_am = findViewById(R.id.am_3_3);
        textView_aR = findViewById(R.id.aR_3_3);
        textView_Yb1 = findViewById(R.id.Yb1_3_3);

        radioGroup = findViewById(R.id.radio_group_3_3);

        radioButtonYb_Dl = findViewById(R.id.radioButton_Dl_3_3);
        radioButtonYb_Kr = findViewById(R.id.radioButton_Kr_3_3);

        ClassBetona =  findViewById(R.id.ClassBetona_3_3);
        ArrayAdapter<String> classBetonaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classBetona);
        classBetonaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassBetona.setAdapter(classBetonaAdapter);

        KolvoSt = findViewById(R.id.KolvoSt_3_3);
        ArrayAdapter<String> kolvoSt_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kolvoSt);
        kolvoSt_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        KolvoSt.setAdapter(kolvoSt_Adapter);

        ClassArmaturi = findViewById(R.id.ClassArmaturi_3_3);
        ArrayAdapter<String> classArmaturi_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classArmaturi);
        classArmaturi_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassArmaturi.setAdapter(classArmaturi_Adapter);
    }

    @SuppressLint({"NonConstantResourceId", "CutPasteId"})
    public void Reshenie(View view) {

        if (b_Text.getText().toString().length() == 0 || h_Text.getText().toString().length() == 0 ||
                bf_Text.getText().toString().length() == 0 || hf_Text.getText().toString().length() == 0 || M_Text.getText().toString().length() == 0) {

            showDialog();

        } else {
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Radiobtn();
            } else {
                classBetTxt = ClassBetona.getSelectedItem().toString();
                kolvoStTxt = KolvoSt.getSelectedItem().toString();
                classArmTxt = ClassArmaturi.getSelectedItem().toString();
                Stergni = Integer.parseInt(kolvoStTxt);

                b = Double.parseDouble(b_Text.getText().toString());
                h = Integer.parseInt(h_Text.getText().toString());
                bf = Double.parseDouble(bf_Text.getText().toString());
                hf = Double.parseDouble(hf_Text.getText().toString());
                M = Double.parseDouble(M_Text.getText().toString());

                int checkedButtonIndex = radioGroup.getCheckedRadioButtonId();

                switch (checkedButtonIndex) {

                    case R.id.radioButton_Kr_3_3:

                        Yb1 = 1.0;
                        Rb = RbValue(Rb);
                        break;

                    case R.id.radioButton_Dl_3_3:

                        Yb1 = 0.9;
                        Rb = RbValue(Rb) * Yb1;
                        break;
                }

                //Rb = RbValue(Rb);
                Rs = RsValue(Rs);

                if (Stergni > 3) a = 60;
                else a = 30;

                h0 = h - a;
                Rbbfhf = (Rb * bf * hf * (h0 - 0.5 * hf)) / Math.pow(10, 6);

                if (M <= Rbbfhf) {

                    b = bf;
                    am = (M * Math.pow(10, 6)) / (Rb * b * Math.pow(h0, 2));
                    aR = aRValue(aR);

                    if (am > aR){

                        amar_Dialog();

                    } else {

                        As = (Rb * b * h0 * (1 - Math.sqrt(1 - 2 * am))) / (Rs);
                        AsValue();

                        if(Errors.equals(false)){
                            a1a2Value();

                            if (Stergni > 3) {
                                a_ = a1 + a2 / 2 + Diametr / 2;
                            } else {

                                a_ = a1 + Diametr / 2;
                            }
                            h0_ = h - a_;
                            x = (Rs * As1) / (Rb * b);
                            Mult = (Rb * b * x * (h0 - 0.5 * x)) / Math.pow(10., 6);

                            Print();
                            if(M <= Mult){
                                Toast toast = Toast.makeText(Task_3_3.this, "Несущая способность обеспечена", Toast.LENGTH_LONG);
                                toast.show();
                            }
                            else Mult_Dialog();
                        }
                    }
                } else {

                    am = (M * Math.pow(10, 6) - Rb * (bf - b) * hf * (h0 - 0.5 * hf)) / (Rb * b * Math.pow(h0, 2));
                    aR = aRValue(aR);

                    if (am > aR){
                        amar2_Dialog();
                    } else {

                        As = (Rb * (bf - b) * hf + Rb * b * h0 * (1 - Math.sqrt(1 - 2 * am))) / Rs;
                        AsValue();
                        if(Errors.equals(false)){

                            a1a2Value();

                            if (Stergni > 3) {
                                a_ = a1 + a2 / 2 + Diametr / 2;
                            } else {

                                a_ = a1 + Diametr / 2;
                            }
                            h0_ = h - a_;
                            x = (Rs * As - Rb * (bf - b) * hf) / (Rb * b);
                            Mult = (Rb * (bf - b) * hf * (h0 - 0.5 * hf) + Rb * b * x * (h0 - 0.5 * x)) / Math.pow(10, 6);
                            Print();
                            if(M <= Mult){
                                Toast toast = Toast.makeText(Task_3_3.this, "Несущая способность обеспечена", Toast.LENGTH_LONG);
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
            case "Bp500": Rs = 415; break;
            case "K1400": Rs = 1215; break;
            case "K1500": Rs = 1300; break;
        }

        return Rs;
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

    private Double aRValue(double aR) {

        switch (classArmTxt) {
            case "A240": aR = 0.425; break;
            case "A400": aR = 0.390; break;
            case "A500": aR = 0.372; break;
            case "B500": aR = 0.376; break;
            default:
                KsiRValue();
                aR = KsiR * (1 - 0.5 * KsiR);
                break;
        }

        return aR;
    };

    private void AsValue() {
        switch (classArmTxt) {
            case "K1400":
                for (int i = 0; i < 1; i++) {
                    As1 = AsNum_K1400[i][1] * Stergni;
                    if (As1 < As) {
                        As_Dialog();
                        Errors = true;

                    } else {
                        Diametr = (int) AsNum[i][0];
                        Errors = false;
                    }
                }
                break;

            case "K1500":
                for (int i = 0; i < 1; i++) {
                    As1 = AsNum_K1500[i][1] * Stergni;
                    if (As1 < As) {
                        As_Dialog();
                        Errors = true;

                    } else {
                        Diametr = (int) AsNum[i][0];
                        Errors = false;
                    }
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

    private  void a1a2Value() {

        for (int i = 0; i < 13; i++)
        {
            if (Diametr.equals(a2Value[0][i])) a2 = a2Value [1][i];
        }

        if (Diametr > 20) a1 = Diametr;
        else a1 = 20;

    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void Print() {

        textView_As.setText("As = " + (String.format("%.0f", + As)) + " мм^2 " + getString(R.string.AsResultText_2));
        textView_DmTxt.setText("ф = " + Diametr.toString() + " мм " + getString(R.string.DiamResultText));
        textView_Rb.setText("Rb = " + String.format("%.2f", + Rb) + " МПа " + getString(R.string.RbResultText));
        textView_Rs.setText("Rs = " + Rs.toString() + " МПа " + getString(R.string.RsResultText));
        textView_am.setText("\u237Am = " + (String.format("%.3f", + am)) + " " + getString(R.string.AlphamResultText));
        textView_aR.setText("\u237AR = " + (String.format("%.3f", + aR)) + " " + getString(R.string.AlphaRResultText));
        textView_Yb1.setText("Yb1 =  " + (String.format("%.1f", + Yb1)) + " " + getString(R.string.Yb1ResultText));

    }

    public void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_3_3.this);

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
    public void amar_Dialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_3_3.this);

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
    public void amar2_Dialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_3_3.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\n\u237Am = " + String.format("%.3f", + am) + " > \u237AR = " + String.format("%.3f", + aR) + " \n\nНеобходимо изменить рамеры поперечного сеченя или увеличить классы материалов и повторить расчёт.")
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

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_3_3.this);

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

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_3_3.this);

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

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_3_3.this);

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