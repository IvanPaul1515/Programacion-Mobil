package com.example.tarea;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewSaludo = findViewById(R.id.textViewSaludo);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        String sexo = intent.getStringExtra("sexo");
        String fecha = intent.getStringExtra("fecha");
        boolean gustaProgramar = intent.getBooleanExtra("gustaProgramar", false);
        ArrayList<String> lenguajes = intent.getStringArrayListExtra("lenguajes");

        StringBuilder mensaje = new StringBuilder("Hola!, Mi Nombre es: ");
        mensaje.append(nombre).append(" ").append(apellido).append("\n\n");
        mensaje.append("Soy de sexo ").append(sexo).append(", y nací el ").append(fecha).append("\n\n");

        if (gustaProgramar) {
            mensaje.append("Me gusta Programar, Mis Lenguajes Favoritos son: ");
            for (String lenguaje : lenguajes) {
                mensaje.append(lenguaje).append(", ");
            }
        } else {
            mensaje.append("No me gusta Programar");
        }

        textViewSaludo.setText(mensaje.toString());

        Button buttonLimpiar = findViewById(R.id.button5);
        Button buttonModificar = findViewById(R.id.button4);

        buttonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiarCampos();
            }
        });

        buttonModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volverAVistaAnterior();
            }
        });
    }

    private void limpiarCampos() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        Toast.makeText(this, "Campos Limpios", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void volverAVistaAnterior() {
        Toast.makeText(this, "Modifcacion de campos", Toast.LENGTH_SHORT).show();
        finish();
    }
}
