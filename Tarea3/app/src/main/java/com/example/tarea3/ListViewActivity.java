package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private ArrayList<String> itemList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        // Obtén una referencia al ListView desde el diseño
        listView = findViewById(R.id.list);

        // Obtén una referencia al EditText para ingresar nuevas tareas
        final EditText editTask = findViewById(R.id.editl);

        // Obtén una referencia al botón para agregar tareas
        Button addButton = findViewById(R.id.botonl);

        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = editTask.getText().toString().trim();
                if (!task.isEmpty()) {
                    itemList.add(task);
                    adapter.notifyDataSetChanged();
                    editTask.setText("");
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long id) {
                // Mostrar cuadro de diálogo de confirmación al hacer clic en una tarea
                AlertDialog.Builder builder = new AlertDialog.Builder(ListViewActivity.this);
                builder.setTitle("Confirmar eliminación");
                builder.setMessage("¿Desea eliminar esta tarea?");
                builder.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        itemList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancelar", null);
                builder.show();
            }
        });
    }
}
