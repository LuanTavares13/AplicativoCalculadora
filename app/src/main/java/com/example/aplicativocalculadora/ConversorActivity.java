package com.example.aplicativocalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ConversorActivity extends AppCompatActivity {

    EditText input;
    Spinner unit;
    TextView km, m, cm, mm, microm, nm, milha, jarda, pe, polegada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);

        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        km = findViewById(R.id.km);
        m = findViewById(R.id.m);
        cm = findViewById(R.id.cm);
        mm = findViewById(R.id.mm);
        microm = findViewById(R.id.microm);
        nm = findViewById(R.id.nm);
        milha = findViewById(R.id.milha);
        jarda = findViewById(R.id.jarda);
        pe = findViewById(R.id.pe);
        polegada = findViewById(R.id.polegada);

        String[] arr = {"Quilômetros", "Metros", "Centímetros", "Milímetros", "Micrômetros", "Nanômetros", "Milhas", "Jardas", "Pés", "Polegadas"};
        unit.setAdapter(new ArrayAdapter<>(ConversorActivity.this, android.R.layout.simple_list_item_1, arr));

        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update();
            }
        });
    }

    private void update() {
        if (!input.getText().toString().equals("") && !unit.getSelectedItem().toString().equals("")) {
            double in = Double.parseDouble(input.getText().toString());
            switch (unit.getSelectedItem().toString()) {
                case "Quilômetros":
                    setKm(in);
                    break;
                case "Metros":
                    setKm(in / 1000);
                    break;
                case "Centímetros":
                    setKm(in / 100000);
                    break;
                case "Milímetros":
                    setKm(in / 1000000);
                    break;
                case "Micrômetros":
                    setKm(in / 1000000000);
                    break;
                case "Nanômetros":
                    double d = 1000000 * 1000000;
                    setKm(in / d);
                    break;
                case "Milhas":
                    setKm(in * 1.609);
                    break;
                case "Jardas":
                    setKm(in / 1094);
                    break;
                case "Pés":
                    setKm(in / 3281);
                    break;
                case "Polegadas":
                    setKm(in / 39370);
                    break;
            }
        }
    }

    private void setKm(double km_in) {
        km.setText(String.valueOf(km_in));
        m.setText(String.valueOf(km_in * 1000));
        cm.setText(String.valueOf(km_in * 100000));
        mm.setText(String.valueOf(km_in * 1000000));
        microm.setText(String.valueOf(km_in * 1000000000));
        nm.setText(String.valueOf(km_in * 1000000 * 1000000));
        milha.setText(String.valueOf(km_in / 1.609));
        jarda.setText(String.valueOf(km_in * 1094));
        pe.setText(String.valueOf(km_in * 3281));
        polegada.setText(String.valueOf(km_in * 39370));
    }
}
