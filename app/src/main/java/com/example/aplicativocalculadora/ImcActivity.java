package com.example.aplicativocalculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ImcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        EditText inputWeight = findViewById(R.id.input_weight);
        EditText inputHeight = findViewById(R.id.input_height);
        Button calculateButton = findViewById(R.id.calculate_button);
        TextView resultView = findViewById(R.id.result_text);

        calculateButton.setOnClickListener(view -> {
            String weightText = inputWeight.getText().toString();
            String heightText = inputHeight.getText().toString();

            if (weightText.isEmpty() || heightText.isEmpty()) {
                resultView.setText("Por favor, insira o peso e a altura.");
                return;
            }

            try {
                double weight = Double.parseDouble(weightText);
                double heightCm = Double.parseDouble(heightText);

                if (weight <= 0 || heightCm <= 0) {
                    resultView.setText("Insira valores válidos para peso e altura.");
                } else {
                    double height = heightCm / 100.0;

                    double imc = weight / (height * height);

                    String classification = "";
                    if (imc < 16) {
                        classification = "Magreza grave";
                    } else if (imc >= 16 && imc <= 16.9) {
                        classification = "Magreza moderada";
                    } else if (imc >= 17 && imc <= 18.5) {
                        classification = "Magreza leve";
                    } else if (imc >= 18.6 && imc <= 24.9) {
                        classification = "Peso ideal";
                    } else if (imc >= 25 && imc <= 29.9) {
                        classification = "Sobrepeso";
                    } else if (imc >= 30 && imc <= 34.9) {
                        classification = "Obesidade grau I";
                    } else if (imc >= 35 && imc <= 39.9) {
                        classification = "Obesidade grau II ou severa";
                    } else if (imc >= 40) {
                        classification = "Obesidade grau III ou mórbida";
                    }

                    resultView.setText(String.format("Seu IMC é: %.2f\nClassificação: %s", imc, classification));
                }
            } catch (NumberFormatException e) {
                resultView.setText("Erro: valores inválidos.");
            }
        });
    }
}
