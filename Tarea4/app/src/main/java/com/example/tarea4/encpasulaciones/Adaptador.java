import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea4.R;
import com.example.tarea4.entidad.Tarea;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    private List<Tarea> tareas;

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
        holder.imageView.setImageResource(tarea.getImagenResId());

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
