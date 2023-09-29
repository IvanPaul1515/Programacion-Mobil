package com.example.tarea3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Tarea> listaTareas; // Cambiamos el tipo de datos a Tarea
    private Adaptador adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        listaTareas = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Adaptador(listaTareas);
        recyclerView.setAdapter(adapter);

        Button botonAgregar = findViewById(R.id.botonR);
        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editR);
                String nombreTarea = editText.getText().toString();

                if (nombreTarea.isEmpty()) {
                    Toast.makeText(RecyclerViewActivity.this, "Debes escribir una tarea", Toast.LENGTH_SHORT).show();
                } else {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);

                    // Agregar una nueva tarea con una imagen de ejemplo (debes proporcionar tus propias imágenes)
                    Tarea nuevaTarea = new Tarea(nombreTarea, R.drawable.ing);
                    listaTareas.add(nuevaTarea);

                    adapter.notifyDataSetChanged();

                    editText.setText("");
                }
            }
        });

    }

    private class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
        private List<Tarea> tareas; // Cambiamos el tipo de datos a Tarea

        public Adaptador(List<Tarea> tareas) {
            this.tareas = tareas;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Tarea tarea = tareas.get(position);
            holder.textView.setText(tarea.getNombre());
            holder.imageView.setImageResource(tarea.getImagenResId()); // Establecer la imagen

            holder.botonEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tareas.remove(position);
                    notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            return tareas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView textView;
            public Button botonEliminar;
            public ImageView imageView;

            public ViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.name);
                botonEliminar = itemView.findViewById(R.id.borrar);
                imageView = itemView.findViewById(R.id.image);
            }
        }
    }
}
