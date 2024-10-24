package com.example.parcial_1_nelaton_joy;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private EditText numeroMes;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        numeroMes = findViewById(R.id.txtNumMes);
        resultado = findViewById(R.id.RespuestaMes);

        Button boton = findViewById(R.id.btnDeterminar);
        boton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(numeroMes.getText().toString());
                String mes = getMes(numero);
                resultado.setText("El mes correspondiente es: " + mes);
            }
        });

        Button btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private String getMes(int numero) {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        if (numero >= 1 && numero <= 12) {
            return meses[numero - 1];
        } else {
            return "Número inválido";
        }
    }

    /* Joy Nelaton */
}
