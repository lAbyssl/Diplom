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

public class Task_5 extends AppCompatActivity {

    public String[] classBetona = {"B10", "B15", "B20", "B25", "B30", "B35", "B40", "B45", "B50", "B55", "B60"};
   // public String[] classArmaturi = {"A240", "A400", "A500", "A600", "A800", "A1000", "B500", "Bp500", "Bp1200", "Bp1300", "Bp1400", "Bp1500"};
    public String[] classArmaturi = {"A240", "A400", "A500", "A600", "A800", "A1000", "B500"};
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

    public double[][] PhibTable = {{99, 6.0, 8.0, 10, 12, 14, 16, 18, 20},

            {0.00, 0.930, 0.920, 0.910, 0.900, 0.890, 0.880, 0.860, 0.840},
            {0.25, 0.925, 0.915, 0.905, 0.895, 0.875, 0.850, 0.815, 0.775},
            {0.50, 0.920, 0.910, 0.900, 0.890, 0.860, 0.820, 0.770, 0.710},
            {0.75, 0.920, 0.910, 0.895, 0.880, 0.845, 0.790, 0.725, 0.655},
            {1.00, 0.920, 0.910, 0.890, 0.870, 0.830, 0.760, 0.680, 0.600}};

    public double[][] Phisb1Table = {{99, 6.0, 8.0, 10, 12, 14, 16, 18, 20},

            {0.00, 0.930, 0.920, 0.910, 0.900, 0.890, 0.880, 0.860, 0.830},
            {0.25, 0.925, 0.915, 0.910, 0.900, 0.885, 0.875, 0.845, 0.810},
            {0.50, 0.920, 0.910, 0.910, 0.900, 0.880, 0.870, 0.830, 0.790},
            {0.75, 0.920, 0.910, 0.905, 0.900, 0.880, 0.860, 0.830, 0.765},
            {1.00, 0.920, 0.910, 0.900, 0.900, 0.880, 0.850, 0.830, 0.740}};

    public double[][] Phisb2Table = {{99, 6.0, 8.0, 10, 12, 14, 16, 18, 20},

            {0.00, 0.920, 0.920, 0.910, 0.890, 0.870, 0.850, 0.820, 0.790},
            {0.25, 0.920, 0.915, 0.905, 0.885, 0.860, 0.830, 0.790, 0.750},
            {0.50, 0.920, 0.910, 0.900, 0.880, 0.850, 0.810, 0.760, 0.710},
            {0.75, 0.920, 0.910, 0.895, 0.875, 0.840, 0.790, 0.730, 0.665},
            {1.00, 0.920, 0.910, 0.890, 0.870, 0.830, 0.770, 0.700, 0.620}};

    public double[][] PhisbTable;


    public Integer Stergni = 0;
    public Integer Diametr = 0;
    public Integer Rsc = 0;
    public Integer S;
    public Integer dsw;
    public Integer a = 30;

    public Double b;
    public Double h;
    public Double L0;
    public Double N;
    public Double Nl;
    public Double Mu;
    public Double Alphas;
    public Double Alphas1;
    public Double Phi;
    public Double A;
    public Double Astot;
    public Double As1 = 0.;
    public Double MuProc = 0.;
    public Double Nult;
    public Double Rb = 0.0;
    public Double Yb3 = 0.0;
    public Double Lyambda, NlN, Phib, Phisb;
    public Double x1;
    public Double x2;
    public Double y1;
    public Double y2;
    public Double x;
    public Double scale;

    public String classBetTxt;
    public String kolvoStTxt;
    public String classArmTxt;

    public Boolean Errors = false;

    public EditText b_Text;
    public EditText h_Text;
    public EditText L0_Text;
    public EditText N_Text;
    public EditText Nl_Text;

    public Spinner ClassBetona;
    public Spinner KolvoSt;
    public Spinner ClassArmaturi;

    TextView textView_Astot;
    TextView textView_Diam;
    TextView textView_Rb;
    TextView textView_Rsc;
    TextView textView_Nult;
    TextView textView_Phi;
    TextView textView_Phib;
    TextView textView_Phisb;
    TextView textView_dswsw;
    TextView textView_Yb3;

    RadioGroup radioGroup;

    RadioButton radioButton_Vertical;
    RadioButton radioButton_Horizontal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_5);

        b_Text = findViewById(R.id.b_5);
        h_Text = findViewById(R.id.h_5);
        L0_Text = findViewById(R.id.L0_5);
        N_Text = findViewById(R.id.N_5);
        Nl_Text = findViewById(R.id.Nl_5);

        textView_Astot = findViewById(R.id.Astot_5);
        textView_Diam = findViewById(R.id.Diam_5);
        textView_Rb = findViewById(R.id.Rb_5);
        textView_Rsc = findViewById(R.id.Rsc_5);
        textView_Nult = findViewById(R.id.Nult_5);
        textView_Phi = findViewById(R.id.Phi_5);
        textView_Phib = findViewById(R.id.Phib_5);
        textView_Phisb = findViewById(R.id.Phisb_5);
        textView_dswsw = findViewById(R.id.dswsw_5);
        textView_Yb3 = findViewById(R.id.Yb3_5);

        radioGroup = findViewById(R.id.radio_group_5);

        radioButton_Vertical = findViewById(R.id.radioButton_Vertical_5);
        radioButton_Horizontal = findViewById(R.id.radioButton_Horiz_5);

        ClassBetona = findViewById(R.id.ClassBetona_5);
        ArrayAdapter<String> classBetonaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classBetona);
        classBetonaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassBetona.setAdapter(classBetonaAdapter);

        KolvoSt = findViewById(R.id.KolvoSt_5);
        ArrayAdapter<String> kolvoStAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kolvoSt);
        kolvoStAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        KolvoSt.setAdapter(kolvoStAdapter);

        ClassArmaturi = findViewById(R.id.ClassArmaturi_5);
        ArrayAdapter<String> classArmaturiAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classArmaturi);
        classArmaturiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassArmaturi.setAdapter(classArmaturiAdapter);
    }

    @SuppressLint({"NonConstantResourceId", "CutPasteId"})
    public void Reshenie(View view) {

        classBetTxt = ClassBetona.getSelectedItem().toString();
        kolvoStTxt = KolvoSt.getSelectedItem().toString();
        classArmTxt = ClassArmaturi.getSelectedItem().toString();

        if (b_Text.getText().toString().length() == 0 || h_Text.getText().toString().length() == 0 ||
                L0_Text.getText().toString().length() == 0 || N_Text.getText().toString().length() == 0 || Nl_Text.getText().toString().length() == 0) {
            showDialog();
        } else {
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Radiobtn();
            } else {
                Stergni = Integer.parseInt(kolvoStTxt);

                b = Double.parseDouble(b_Text.getText().toString());
                h = Double.parseDouble(h_Text.getText().toString());
                L0 = Double.parseDouble(L0_Text.getText().toString());
                N = Double.parseDouble(N_Text.getText().toString());
                Nl = Double.parseDouble(Nl_Text.getText().toString());

                int checkedButtonIndex = radioGroup.getCheckedRadioButtonId();

                switch (checkedButtonIndex) {

                    case R.id.radioButton_Horiz_5:

                        Yb3 = 1.;
                        Rb = RbValue(Rb);
                        break;

                    case R.id.radioButton_Vertical_5:

                        Yb3 = 0.85;
                        Rb = RbValue(Rb) * Yb3;
                        break;

                }

                Rsc = RscValue(Rsc);

                Lyambda = L0 / h;

                if (Lyambda < 6){
                    Lyambda_Dialog();

                } else{

                    NlN = Nl / N;
                    scale = Math.pow(10, 2.);//
                    NlN = Math.ceil(NlN * scale) / scale;

                    if (NlN == 0.76) {
                        NlN -= 0.01;
                    }
                    else if(NlN == 0.26){
                        NlN -= 0.01;
                    }
                    else if(NlN == 0.51){
                        NlN -= 0.01;
                    }

                    //if(NlN != 0 || NlN != 0.25 || NlN != 0.5 || NlN != 0.75 || NlN != 1){
                    if(NlN.equals(0.0) || NlN.equals(0.25) || NlN.equals(0.50) || NlN.equals(0.75) || NlN.equals(1.0)){
                        if (a < 0.15 * h) {

                            PhisbTable = Phisb1Table;

                            PhibValue();
                            PhisbValue();

                            Mu = 0.01;
                            Alphas = Mu * Rsc / Rb;

                            if (Alphas > 0.5) Phi = Phisb;
                            else Phi = Phib + 2 * (Phisb - Phib) * Alphas;
                            if (Phi > Phisb) Phi = Phisb;

                            A = b * h;

                            //Astot = ((N * Math.pow(10, 3))/(Phi * Rsc) - (Rb * A))/Rsc;
                            Astot = ((N * Math.pow(10, 3))/Phi - Rb * A)/Rsc;

                            AsValue();

                            if (Errors.equals(false)) {

                                MuProc = As1 / (b * h) * 100;
                                Alphas1 = (Rsc * As1) / (Rb * A);

                                if (Alphas1 > 0.5) Phi = Phisb;
                                else Phi = Phib + 2 * (Phisb - Phib) * Alphas1;
                                if (Phi > Phisb) Phi = Phisb;

                                Astot = ((N * Math.pow(10, 3)) / Phi - Rb * A) / Rsc;
                                AsValue();

                                Nult = (Phi * (Rb * A + Rsc * As1)) / Math.pow(10, 3);
                                dswValue();

                                if (MuProc <= 3) S = 15 * Diametr;
                                else S = 10 * Diametr;

                                Print();

                                if(N <= Nult){
                                    Toast toast = Toast.makeText(Task_5.this, "Несущая способность обеспечена", Toast.LENGTH_LONG);
                                    toast.show();
                                }
                                else Nult_Dialog();
                            }
                        }

                        else if (0.25 / h > a && a < 0.15 * h){

                            PhisbTable = Phisb2Table;

                            PhibValue();
                            PhisbValue();

                            Mu = 0.01;
                            Alphas = Mu * Rsc / Rb;

                            if (Alphas > 0.5) Phi = Phisb;
                            else Phi = Phib + 2 * (Phisb - Phib) * Alphas;
                            if (Phi > Phisb) Phi = Phisb;

                            A = b * h;

                            Astot = ((N * Math.pow(10, 3))/Phi - Rb * A)/Rsc;

                            AsValue();

                            if (Errors.equals(false)){

                                MuProc = As1 / (b * h) * 100;
                                Alphas1 = (Rsc * As1) / (Rb * A);

                                if (Alphas1 > 0.5) Phi = Phisb;
                                else Phi = Phib + 2 * (Phisb - Phib) * Alphas1;

                                if (Phi > Phisb) Phi = Phisb;

                                Astot = ((N * Math.pow(10, 3)) / Phi - Rb * A) / Rsc;
                                AsValue();

                                Nult = (Phi * (Rb * A + Rsc * As1)) / Math.pow(10, 3);
                                dswValue();

                                if (MuProc <= 3) S = 15 * Diametr;
                                else S = 10 * Diametr;

                                Print();

                                if(N <= Nult){
                                    Toast toast = Toast.makeText(Task_5.this, "Несущая способность обеспечена", Toast.LENGTH_LONG);
                                    toast.show();
                                }
                                else Nult_Dialog();
                            }

                        } else {

                            Phisb_Dialog();
                        }
                    } else {

                        NlN_Dialog();
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

    private int RscValue(int Rsc) {
        switch (classArmTxt) {
            case "A240": Rsc = 210; break;
            case "A400": Rsc = 350; break;
            case "A500": Rsc = 400; break;
            case "A600": Rsc = 400; break;
            case "A800": Rsc = 400; break;
            case "A1000": Rsc = 400; break;
            case "B500": Rsc = 380; break;
            case "Bp500": Rsc = 350; break;
            case "Bp1200": Rsc = 400; break;
            case "Bp1300": Rsc = 400; break;
            case "Bp1400": Rsc = 400; break;
            case "Bp1500": Rsc = 400; break;
        }

        return Rsc;
    }

    private void AsValue() {

        int i = 0;
        while (i < 12) {

            As1 = AsNum[i][1] * Stergni;

            if ((As1 < Astot) && i == 11) {

                As_Dialog();
                Errors = true;
                break;
            }
            else if (As1 >= Astot) {
                Diametr = (int) AsNum[i][0];
                Errors = false;
                break;
            }
            i++;
        }
    }

    private void PhibValue(){

        for(int i = 0; i < 6; i++){

            if(NlN == PhibTable[i][0]){

                for(int j = 0; j < 9; j++){

                    if(Lyambda > PhibTable[0][j] && Lyambda < PhibTable[0][j+1]){

                        x1 = PhibTable[0][j];
                        x2 = PhibTable[0][j+1];
                        y1 = PhibTable[i][j];
                        y2 = PhibTable[i][j+1];
                        x = Lyambda;
                        Phib = y1 + (x - x1) * (y2 - y1)/(x2 - x1);
                        break;
                    }
                    else if (Lyambda == PhibTable[0][j]){

                        Phib = PhibTable[i][j];
                        break;
                    }
                }
                break;
            }
        }
    }

    private void PhisbValue(){

        for(int i = 0; i < 6; i++){

            if(NlN == PhisbTable[i][0]){

                for(int j = 0; j < 9; j++){

                    if(Lyambda > PhisbTable[0][j] && Lyambda < PhisbTable[0][j+1]){

                        x1 = PhisbTable[0][j];
                        x2 = PhisbTable[0][j+1];
                        y1 = PhisbTable[i][j];
                        y2 = PhisbTable[i][j+1];
                        x = Lyambda;
                        Phisb = y1 + (x - x1) * (y2 - y1)/(x2 - x1);
                        break;
                    }
                    else if (Lyambda == PhisbTable[0][j]){

                        Phisb = PhisbTable[i][j];
                        break;
                    }
                }
                break;
            }
        }
    }

    private void dswValue() {

        switch (Diametr) {
            case 10: dsw = 3; break;
            case 12: dsw = 3; break;
            case 14: dsw = 4; break;
            case 16: dsw = 4; break;
            case 18: dsw = 5; break;
            case 20: dsw = 5; break;
            case 22: dsw = 6; break;
            case 25: dsw = 8; break;
            case 28: dsw = 8; break;
            case 32: dsw = 8; break;
            case 36: dsw = 10; break;
            case 40: dsw = 10; break;
        }
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void Print() {

        textView_Astot.setText("As,tot = " + (String.format("%.0f", + Astot)) + " мм^2 " + getString(R.string.AstotResultText));
        textView_Diam.setText("ф = " + Diametr.toString() + " мм " + getString(R.string.AstotResultText));
        textView_Rb.setText("Rb = " + (String.format("%.2f", + Rb)) + " МПа " + getString(R.string.RbResultText));
        textView_Rsc.setText("Rsc = " + Rsc.toString() + " МПа " + getString(R.string.RscResultText));
        textView_Nult.setText("Nult = " + (String.format("%.0f", + Nult)) + " кН " + getString(R.string.NultResultText));
        textView_Phi.setText("\u03C6 = " + (String.format("%.3f", + Phi)) + " " + getString(R.string.PhiResultText));
        textView_Phib.setText("\u03C6b = " + (String.format("%.3f", + Phib)) + " " + getString(R.string.PhibResultText));
        textView_Phisb.setText("\u03C6sb = " + (String.format("%.3f", + Phisb)) + " " + getString(R.string.PhisbResultText));
        textView_dswsw.setText("dsw.sw = " + dsw.toString() + "." + S.toString() + " мм " + getString(R.string.dswswResultText));
        textView_Yb3.setText("Yb3 = " + (String.format("%.2f", + Yb3)) + " " + getString(R.string.Yb3ResultText));

    }

    public void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_5.this);

        builder.setTitle("Предупреждение !")
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

    @SuppressLint("DefaultLocale")
    public void Phisb_Dialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_5.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\nНевозможно подобрать \u03C6sb.\n\nНужно увеличить размер сечения h и повторить расчет.")
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
    public void Lyambda_Dialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_5.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\n\u03BB = " + String.format("%.1f", + Lyambda) + " < 6\n\nНеобходимо увеличить значение L0.")
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

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_5.this);

        builder.setTitle("Предупреждение !")
                .setMessage("При заданном кол-ве стержей значение Astot > As при любом диаметре.\n\nУвеличьте количество стержней.")
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

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_5.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\nНе выбрано положение бетонировния.")
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
    public void Nult_Dialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_5.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\nN = " + String.format("%.1f", + N) + "кН*м > Nult = " + String.format("%.1f", + Nult) + "кН*м.\n\nНесущая способность не обеспечена.")
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
    public void NlN_Dialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_5.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\nПроверьте правильность ввода значений N и Nl")
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