package com.serkanok.mortgagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class AnaEkran extends AppCompatActivity {

    int krediTutari;
    double faizOrani;
    TextView aylikOdeme5yOutput;
    TextView aylikOdeme7yOutput;
    TextView aylikOdeme10yOutput;
    TextView toplOdeme5yOutput;
    TextView toplOdeme7yOutput;
    TextView toplOdeme10yOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ana_ekran);

        krediTutari = 0;
        faizOrani = 0;
        EditText krediTutariGirdi = findViewById(R.id.kredi_tutari_input);
        EditText faizOraniGirdi = findViewById(R.id.faiz_orani_input);
        aylikOdeme5yOutput = findViewById(R.id.ayl_odm_5y_output);
        aylikOdeme7yOutput = findViewById(R.id.ayl_odm_7y_output);
        aylikOdeme10yOutput = findViewById(R.id.ayl_odm_10y_output);
        toplOdeme5yOutput = findViewById(R.id.topl_odm_5y_output);
        toplOdeme7yOutput = findViewById(R.id.topl_odm_7y_output);
        toplOdeme10yOutput = findViewById(R.id.topl_odm_10y_output);
        krediTutariGirdi.addTextChangedListener(krediTutariIzleyici);
        faizOraniGirdi.addTextChangedListener(faizOraniGirdiIzleyici);
    }

    private void sonucGoster() {
        aylikOdeme5yOutput.setText(String.format("%.2f", sonucHesapla(60)));
        toplOdeme5yOutput.setText(String.format("%.0f", sonucHesapla(60)*60));
        aylikOdeme7yOutput.setText(String.format("%.2f", sonucHesapla(84)));
        toplOdeme7yOutput.setText(String.format("%.0f", sonucHesapla(84)*84));
        aylikOdeme10yOutput.setText(String.format("%.2f", sonucHesapla(120)));
        toplOdeme10yOutput.setText(String.format("%.0f", sonucHesapla(120)*120));
    }

    private double sonucHesapla(int ay) {
        double a = Math.pow((1 + faizOrani), ay);
        return krediTutari * (faizOrani * a) / (a - 1);
    }

    private TextWatcher krediTutariIzleyici = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().length() > 0) {
                krediTutari = Integer.parseInt(s.toString());
                sonucGoster();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher faizOraniGirdiIzleyici = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().length() > 0) {
                faizOrani = Double.parseDouble(s.toString());
                sonucGoster();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
