package com.example.tarea;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextApellido;
    private EditText editTextFechaNacimiento;
    private Spinner spinner;
    private RadioButton radioButtonSi;
    private RadioButton radioButtonNo;
    private CheckBox checkBoxJava;
    private CheckBox checkBoxPython;
    private CheckBox checkBoxJS;
    private CheckBox checkBoxC;
    private CheckBox checkBoxGo;
    private CheckBox checkBoxCSharp;
    private TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextText);
        editTextApellido = findViewById(R.id.editTextText2);
        editTextFechaNacimiento = findViewById(R.id.editTextFechaNacimiento);
        spinner = findViewById(R.id.spinnerFecha);
        radioButtonSi = findViewById(R.id.radioButtonSi);
        radioButtonNo = findViewById(R.id.radioButtonNo);
        checkBoxJava = findViewById(R.id.checkBoxJava);
        checkBoxPython = findViewById(R.id.checkBoxPython);
        checkBoxJS = findViewById(R.id.checkBoxJS);
        checkBoxC = findViewById(R.id.checkBoxC);
        checkBoxGo = findViewById(R.id.checkBoxGo);
        checkBoxCSharp = findViewById(R.id.checkBoxCSharp);
        Button buttonLimpiar = findViewById(R.id.button);

        editTextFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        String[] opciones = {"Seleccionar", "Masculino", "Femenino"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        radioButtonSi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleCheckBoxVisibility(isChecked);
            }
        });

        Button buttonEnviar = findViewById(R.id.button3);
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarYEnviar();
            }
        });

        buttonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiarCampos();
            }
        });
    }
    private void limpiarCampos() {
        editTextNombre.setText("");
        editTextApellido.setText("");
        editTextFechaNacimiento.setText("");
        spinner.setSelection(0);
        radioButtonSi.setChecked(true);
        checkBoxJava.setChecked(false);
        checkBoxPython.setChecked(false);
        checkBoxJS.setChecked(false);
        checkBoxC.setChecked(false);
        checkBoxGo.setChecked(false);
        checkBoxCSharp.setChecked(false);
        toggleCheckBoxVisibility(true);
        Toast.makeText(this, "Campos Limpios", Toast.LENGTH_SHORT).show();
    }


    private void toggleCheckBoxVisibility(boolean isChecked) {
        if (isChecked) {
            checkBoxJava.setVisibility(View.VISIBLE);
            checkBoxPython.setVisibility(View.VISIBLE);
            checkBoxJS.setVisibility(View.VISIBLE);
            checkBoxC.setVisibility(View.VISIBLE);
            checkBoxGo.setVisibility(View.VISIBLE);
            checkBoxCSharp.setVisibility(View.VISIBLE);
            //textView5.setVisibility(View.VISIBLE);
        } else {
            checkBoxJava.setVisibility(View.GONE);
            checkBoxPython.setVisibility(View.GONE);
            checkBoxJS.setVisibility(View.GONE);
            checkBoxC.setVisibility(View.GONE);
            checkBoxGo.setVisibility(View.GONE);
            checkBoxCSharp.setVisibility(View.GONE);
            //textView5.setVisibility(View.GONE);
        }
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        editTextFechaNacimiento.setText(selectedDate);
                    }
                },
                year, month, day);

        datePickerDialog.show();
    }

    private ArrayList<String> obtenerLenguajesSeleccionados() {
        ArrayList<String> lenguajesSeleccionados = new ArrayList<>();

        if (checkBoxJava.isChecked()) {
            lenguajesSeleccionados.add("Java");
        }
        if (checkBoxPython.isChecked()) {
            lenguajesSeleccionados.add("Python");
        }
        if (checkBoxJS.isChecked()) {
            lenguajesSeleccionados.add("JS");
        }
        if (checkBoxC.isChecked()) {
            lenguajesSeleccionados.add("C/C++");
        }
        if (checkBoxGo.isChecked()) {
            lenguajesSeleccionados.add("Go Land");
        }
        if (checkBoxCSharp.isChecked()) {
            lenguajesSeleccionados.add("C#");
        }

        return lenguajesSeleccionados;
    }

    private void validarYEnviar() {
        String nombre = editTextNombre.getText().toString();
        String apellido = editTextApellido.getText().toString();
        String genero = spinner.getSelectedItem().toString();
        String fechaNacimiento = editTextFechaNacimiento.getText().toString();

        // ArrayList<String> lenguajesSeleccionados = obtenerLenguajesSeleccionados();

        if (nombre.isEmpty() || apellido.isEmpty() || genero.equals("Seleccionar")|| fechaNacimiento.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            ArrayList<String> lenguajesSeleccionados = obtenerLenguajesSeleccionados();

            if (radioButtonSi.isChecked() && lenguajesSeleccionados.isEmpty()) {
                Toast.makeText(this, "Si le gusta programar, debe seleccionar al menos un lenguaje.", Toast.LENGTH_SHORT).show();
            } else {
                //Toast.makeText(this, "Datos válidos, acción deseada.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("nombre", editTextNombre.getText().toString());
                intent.putExtra("apellido", editTextApellido.getText().toString());
                intent.putExtra("sexo", spinner.getSelectedItem().toString());
                intent.putExtra("fecha", editTextFechaNacimiento.getText().toString());
                intent.putExtra("gustaProgramar", radioButtonSi.isChecked());

                intent.putStringArrayListExtra("lenguajes", lenguajesSeleccionados);

                startActivity(intent);

            }
        }
    }
}
