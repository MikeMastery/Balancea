package com.example.agenda_personal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class Dise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dise);

        // Crear y configurar el adaptador
        ArrayList<String> listaRecordatorios = obtenerListaRecordatorios();
        CustomAdapter adapter = new CustomAdapter(this, listaRecordatorios);
        ListView listView = findViewById(R.id.List_recordatorios);
        listView.setAdapter(adapter);
    }

    private ArrayList<String> obtenerListaRecordatorios() {
        // Aquí debes cargar tu lista de recordatorios desde donde sea que los obtengas
        return null;
    }

    static class CustomAdapter extends ArrayAdapter<String> {
        private final ArrayList<String> lista;
        private final Context context;

        public CustomAdapter(Context context, ArrayList<String> lista) {
            super(context, 0, lista);
            this.context = context;
            this.lista = lista;
        }

        @NonNull
        @Override
        public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.activity_dise, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.textView = convertView.findViewById(R.id.textview_item);
                viewHolder.imageViewDelete = convertView.findViewById(R.id.imageview_delete);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            // Asignar texto al TextView
            viewHolder.textView.setText(lista.get(position));

            viewHolder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Eliminar el elemento de la lista y notificar al adaptador
                    lista.remove(position);
                    notifyDataSetChanged();
                    Toast.makeText(context, "Elemento eliminado", Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }

        static class ViewHolder {
            TextView textView;
            ImageView imageViewDelete;
        }
    }
}
