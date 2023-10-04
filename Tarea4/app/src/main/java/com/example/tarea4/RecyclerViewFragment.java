package com.example.tarea4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import com.example.tarea4.;


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
