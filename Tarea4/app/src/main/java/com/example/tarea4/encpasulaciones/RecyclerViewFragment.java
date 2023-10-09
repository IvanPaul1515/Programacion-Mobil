package com.example.tarea4.encpasulaciones;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea4.R;
import com.example.tarea4.encpasulaciones.Adaptador; // Ajusta la ruta de importación según la ubicación de Adaptador

import com.example.tarea4.entidad.Tarea;

import java.util.ArrayList;
import java.util.List;



public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Tarea> listaTareas;
    private Adaptador adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview, container, false);

        listaTareas = new ArrayList<>();

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        adapter = new Adaptador(listaTareas);
        recyclerView.setAdapter(adapter);

        // Agregar aquí la lógica para agregar tareas si es necesario.

        return view;
    }

    // Resto del código del Fragment
}
