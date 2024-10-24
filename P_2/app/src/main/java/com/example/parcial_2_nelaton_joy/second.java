package com.example.parcial_2_nelaton_joy;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;

public class second extends AppCompatActivity {
    private ImageButton botonAnterior; //Declaración de las variables
    private TextView textviewCliente;
    private RadioGroup radioGroupPelis;
    private TextView textViewPrecio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        int edad = intent.getIntExtra("edad", 0); // Vinculación de las variables del activity main

        Toast.makeText(this, "Nombre: " + nombre + ", Apellido: " + apellido + ", Edad: " + edad, Toast.LENGTH_SHORT).show();

        botonAnterior = findViewById(R.id.botonAnterior); // Vinculacion de las variables con sus ids

        textviewCliente = findViewById(R.id.textViewCliente);

        textviewCliente.setText(MessageFormat.format("Nombre: {0}, Apellido: {1}, Edad: {2}", nombre, apellido, edad));

        radioGroupPelis = findViewById(R.id.RadioGroupPeliculas);
        textViewPrecio = findViewById(R.id.textViewPrecio);



        radioGroupPelis.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            public void onCheckedChanged(RadioGroup group, int checkedId) {

                ImageView imageView1 = findViewById(R.id.ImageViewBatman);
                ImageView imageView2 = findViewById(R.id.ImageViewGladiator);
                ImageView imageView3 = findViewById(R.id.ImageViewHappy);
                // Cuando se seleccione una opcion la imagen asociada a la pelicula
                // mantiene su opacidad, mientras que las demas se oscurecen
                // ademas se imprime el precio vinculado en el textview
                if (checkedId == R.id.Radio_Button_Peli_1) {
                    textViewPrecio.setText("Precio: $7.00");
                    imageView1.setAlpha(1.0f); // Brilla
                    imageView2.setAlpha(0.5f); // Opaque
                    imageView3.setAlpha(0.5f); // Opaque

                } else if (checkedId == R.id.Radio_Button_Peli_2) {
                    textViewPrecio.setText("Precio: $6.00");
                    imageView1.setAlpha(0.5f); // Opaque
                    imageView2.setAlpha(1.0f); // Brilla
                    imageView3.setAlpha(0.5f); // Opaque

                } else if (checkedId == R.id.Radio_Button_Peli_3) {
                    textViewPrecio.setText("Precio: $4.00");
                    imageView1.setAlpha(0.5f); // Opaque
                    imageView2.setAlpha(0.5f); // Opaque
                    imageView3.setAlpha(1.0f); // Brilla
                }
            }
        });  // Validamos la selección de la película



        botonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(second.this, MainActivity.class);
                startActivity(intent);
            } // Evento que nos dirigue al activity anterior
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

/* Joy Nelaton */