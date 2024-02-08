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
import android.widget.Toast;

public class Task_4_2 extends AppCompatActivity {

    public String[] classBetona = {"B10", "B15", "B20", "B25", "B30", "B35", "B40", "B45", "B50", "B55", "B60"};
    public String[] classArmaturi = {"A240", "A400", "A500", "B500"};
    public String[] kolvoSt = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public String[] diam = {"6", "8", "10", "12", "14", "16", "18", "20", "22", "25", "28", "32", "36", "40"};

    public double[][] AsNum = {{6., 28.3},
            {8., 50.3},
            {10., 78.5},
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

    public Integer Stergni = 0;
    public Integer Diametr = 0;
    public Integer Rsw;
    public Integer Es;
    public Integer Eb;
    public Integer sw;
    public Integer a;
    public Integer h0;
    public Integer h;
    public Integer a1;
    public Integer a2;

    public Double b;
    public Double bf;
    public Double hf;
    public Double q1;
    public Double P;
    public Double Qmax, Qb, Qsw, Qult, Q, Qbp;
    public Double Rb = 0.0;
    public Double Yb1 = 0.0;
    public Double Rbt;
    public Double Qsigman;
    public Double Asw;
    public Double Phin;
    public Double qsw;
    public Double qswRbtb;
    public Double A1;
    public Double Mb;
    public Double Uravn;
    public Double c, c0;

    public String classBetTxt;
    public String kolvoStTxt;
    public String diamTxt;
    public String classArmTxt;

    public EditText b_Text;
    public EditText h_Text;
    public EditText bf_Text;
    public EditText hf_Text;
    public EditText h0_Text;
    public EditText sw_Text;
    public EditText q1_Text;
    public EditText Qmax_Text;
    public EditText P_Text;

    public Spinner ClassBetona;
    public Spinner KolvoSt;
    public Spinner Diam;
    public Spinner ClassArmaturi;

    TextView textView_Qbp;
    TextView textView_Qb;
    TextView textView_Qsw;
    TextView textView_Mb;
    TextView textView_qsw;
    TextView textView_c;
    TextView textView_c0;
    TextView textView_Rb;
    TextView textView_Rbt;
    TextView textView_Phin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_4_2);

        b_Text = findViewById(R.id.b_4_2);
        h_Text = findViewById(R.id.h_4_2);
        bf_Text = findViewById(R.id.bf_4_2);
        hf_Text = findViewById(R.id.hf_4_2);
        h0_Text = findViewById(R.id.h0_4_2);
        sw_Text = findViewById(R.id.sw_4_2);
        q1_Text = findViewById(R.id.q1_4_2);
        Qmax_Text = findViewById(R.id.Qmax_4_2);
        P_Text = findViewById(R.id.P_4_2);

        textView_Qbp = findViewById(R.id.Qbp_4_2);
        textView_Qb = findViewById(R.id.Qb_4_2);
        textView_Qsw = findViewById(R.id.Qsw_4_2);
        textView_Mb = findViewById(R.id.Mb_4_2);
        textView_qsw = findViewById(R.id.qsw_4_2);
        textView_c = findViewById(R.id.c_4_2);
        textView_c0 = findViewById(R.id.c0_4_2);
        textView_Rb = findViewById(R.id.Rb_4_2);
        textView_Rbt = findViewById(R.id.Rbt_4_2);
        textView_Phin = findViewById(R.id.Phin_4_2);

        ClassBetona = findViewById(R.id.ClassBetona_4_2);
        ArrayAdapter<String> classBetonaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classBetona);
        classBetonaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassBetona.setAdapter(classBetonaAdapter);

        KolvoSt = findViewById(R.id.KolvoSt_4_2);
        ArrayAdapter<String> kolvoStAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kolvoSt);
        kolvoStAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        KolvoSt.setAdapter(kolvoStAdapter);

        Diam = findViewById(R.id.Diam_4_2);
        ArrayAdapter<String> diamAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, diam);
        diamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Diam.setAdapter(diamAdapter);

        ClassArmaturi = findViewById(R.id.ClassArmaturi_4_2);
        ArrayAdapter<String> classArmaturiAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classArmaturi);
        classArmaturiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassArmaturi.setAdapter(classArmaturiAdapter);
    }

    @SuppressLint({"NonConstantResourceId", "CutPasteId"})
    public void Reshenie(View view) {

        classBetTxt = ClassBetona.getSelectedItem().toString();
        kolvoStTxt = KolvoSt.getSelectedItem().toString();
        diamTxt = Diam.getSelectedItem().toString();
        classArmTxt = ClassArmaturi.getSelectedItem().toString();

        if (b_Text.getText().toString().length() == 0 || h_Text.getText().toString().length() == 0 ||
                bf_Text.getText().toString().length() == 0 || hf_Text.getText().toString().length() == 0 || h0_Text.getText().toString().length() == 0 ||
                sw_Text.getText().toString().length() == 0 || q1_Text.getText().toString().length() == 0 || Qmax_Text.getText().toString().length() == 0 || P_Text.getText().toString().length() == 0) {

            showDialog();

        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(Task_4_2.this);

            if((classArmTxt.equals("B500")) && (diamTxt.equals("14") || diamTxt.equals("15") || diamTxt.equals("16") ||
                    diamTxt.equals("18") || diamTxt.equals("20") || diamTxt.equals("22") || diamTxt.equals("25") ||
                    diamTxt.equals("28") || diamTxt.equals("32") || diamTxt.equals("36") || diamTxt.equals("40"))){

                builder.setTitle("Предупреждение !")
                        .setMessage("Арматура класса " + classArmTxt + " не может быть диаметром " + diamTxt + "\n\nДопустимые диаметры:\n\n6, 8, 10, 12")
                        .setCancelable(false)
                        .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }

            else {

                Stergni = Integer.parseInt(kolvoStTxt);
                Diametr = Integer.parseInt(diamTxt);

                b = Double.parseDouble(b_Text.getText().toString());
                h = Integer.parseInt(h_Text.getText().toString());
                bf = Double.parseDouble(bf_Text.getText().toString());
                hf = Double.parseDouble(hf_Text.getText().toString());
                h0 = Integer.parseInt(h0_Text.getText().toString());
                sw = Integer.parseInt(sw_Text.getText().toString());
                q1 = Double.parseDouble(q1_Text.getText().toString());
                Qmax = Double.parseDouble(Qmax_Text.getText().toString());
                P = Double.parseDouble(P_Text.getText().toString());

                Rb = RbValue(Rb);
                RbtValue();
                RswValue();
                EsValue();
                EbValue();
                AswValue();

                //h0 = h - a;

                Qbp = (0.3 * Rb * h0 * b) / Math.pow(10, 3);

                if (Qmax > Qbp) {
                    QmaxQbp_Dialog();
                }

                else {
                    A1 = (b * h) / 100;
                    Phin = 1 + 1.6 * P / (Rb * (A1 / 10)) - 1.16 * Math.pow((P / (Rb * (A1 / 10))), 2);
                    Mb = (1.5 * Rbt * Phin * b * Math.pow(h0, 2)) / Math.pow(10, 6);

                    qsw = (Rsw * Asw) / sw;
                    qswRbtb = qsw / (Rbt * Phin * b);

                    if (qswRbtb < 0.25) {

                        Mb = (6 * Math.pow(h0, 2) * qsw) / Math.pow(10, 6);
                        c0 = (double) 2 * h0;
                    }

                    c = Math.sqrt((Mb * Math.pow(10, 6)) / q1);
                    Uravn = (2 * h0) / (1 - 0.5 * qsw / (Rbt * b));

                    if (qswRbtb > 2 || c < Uravn) {

                        c = Math.sqrt((Mb * Math.pow(10, 6)) / (q1 + 0.75 * qsw));
                    }

                    if (c >= 3 * h0) c = (double) (3 * h0);
                    c0 = c;
                    if (c0 <= h0) c0 = (double) h0;
                    else {
                        if (c0 >= 2 * h0) c0 = (double) 2 * h0;
                        else c0 = c;
                    }

                    Qsw = (0.75 * qsw * c0) / Math.pow(10, 3);

                    Qb = ((Mb * Math.pow(10, 6)) / c) / Math.pow(10, 3);

                    if (Qb >= (2.5 * Rbt * b * h0) / Math.pow(10, 3)){

                        Qb = (2.5 * Rbt * b * h0) / Math.pow(10, 3);
                    }

                    else if (Qb <= (0.5 * Rbt * b * h0) / Math.pow(10, 3)){

                        Qb = (0.5 * Rbt * b * h0) / Math.pow(10, 3);
                    }

                    Qult = Qb + Qsw;
                    Q = Qmax - (q1 * c) / Math.pow(10, 3);
                    Print();

                    if(Q <= Qult){
                        Toast toast = Toast.makeText(Task_4_2.this, "Несущая способность обеспечена", Toast.LENGTH_LONG);
                        toast.show();
                    }
                    else Qult_Dialog();
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

    private void RbtValue() {

        switch (classBetTxt) {
            case "B10": Rbt = 0.56; break;
            case "B15": Rbt = 0.5; break;
            case "B20": Rbt = 0.9; break;
            case "B25": Rbt = 1.05; break;
            case "B30": Rbt = 1.15; break;
            case "B35": Rbt = 1.3; break;
            case "B40": Rbt = 1.4; break;
            case "B45": Rbt = 1.5; break;
            case "B50": Rbt = 1.6; break;
            case "B55": Rbt = 1.7; break;
            case "B60": Rbt = 1.8; break;
        }
    }

    private void RswValue() {

        switch (classArmTxt) {
            case "A240": Rsw = 170; break;
            case "A400": Rsw = 280; break;
            case "A500": Rsw = 300; break;
            case "B500": Rsw = 300; break;
            case "Bp500": Rsw = 300; break;
        }
    }

    private void EsValue() {

        switch (classArmTxt) {
            case "K1400": Es = 195000; break;
            case "K1500": Es = 195000; break;
            default: Es = 200000;
        }
    }

    private void EbValue() {

        switch (classBetTxt) {
            case "B10": Eb = 19000; break;
            case "B15": Eb = 24000; break;
            case "B20": Eb = 27500; break;
            case "B25": Eb = 30000; break;
            case "B30": Eb = 32500; break;
            case "B35": Eb = 34500; break;
            case "B40": Eb = 36000; break;
            case "B45": Eb = 37000; break;
            case "B50": Eb = 38000; break;
            case "B55": Eb = 39000; break;
            case "B60": Eb = 39500; break;
        }
    }

    private void AswValue() {

        for (int i = 0; i < 14; i++)
        {
            if (Diametr == AsNum[i][0]) Asw = AsNum[i][1] * Stergni;
        }
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void Print() {

        textView_Qbp.setText("Qбп = " + (String.format("%.1f", + Qbp)) + " кН " + getString(R.string.QbpResultText));
        textView_Qb.setText("Qb = " + (String.format("%.2f", + Qb)) + " кН " + getString(R.string.QbResultText));
        textView_Qsw.setText("Qsw = " + (String.format("%.2f", + Qsw)) + " кН " + getString(R.string.QswResultText));
        textView_Mb.setText("Mb = " + (String.format("%.2f", + Mb)) + " кН*м " + getString(R.string.MbResultText));
        textView_qsw.setText("qsw = " + (String.format("%.2f", + qsw)) + " кН/м " + getString(R.string.qswResultText));
        textView_c.setText("c = " + (String.format("%.0f", + c)) + " мм " + getString(R.string.cResultText));
        textView_c0.setText("c0 = " + (String.format("%.0f", + c0)) + " мм " + getString(R.string.c0ResultText));
        textView_Rb.setText("Rb = " + (String.format("%.2f", + Rb)) + " МПа " + getString(R.string.RbResultText));
        textView_Rbt.setText("Rbt = " + (String.format("%.2f", + Rbt)) + " МПа " + getString(R.string.RbtResultText));
        textView_Phin.setText("\u03C6n = " + (String.format("%.3f", + Phin)) + " МПа " + getString(R.string.PhinResultText));
    }

    public void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_4_2.this);

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
    public void QmaxQbp_Dialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_4_2.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\nQmax = " + String.format("%.1f", + Qmax) + " > Q\u03C3n = " + String.format("%.1f", + Qbp) + " \n\nНеобходиом увеличить размеры поперечного сечения элемента или увеличить класс бетона и повторить расчет.")
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
    public void Qult_Dialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Task_4_2.this);

        builder.setTitle("Предупреждение !")
                .setMessage("\nQ = " + String.format("%.1f", + Q) + "кН*м > Qult = " + String.format("%.1f", + Qult) + "кН*м.\n\nНесущая способность не обеспечена.")
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