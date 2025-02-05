package com.example.agenda_personal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

import BDrecordatorios.BDrecord;
import BDrecordatorios.DBasignarRecordatorio;

public class lista_recordatorios extends AppCompatActivity {

    ListView listView;
    ArrayList<String> lista;
    Dise.CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_recordatorios);
        listView=findViewById(R.id.List_recordatorios);
        cargarlista();
        configurarAdaptador();
    }
    public void cargarlista(){
        DBasignarRecordatorio dbCliente = new DBasignarRecordatorio(lista_recordatorios.this);
        lista=dbCliente.listarRecordatorios();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, lista);

        listView.setAdapter(adapter);
    }

    private void configurarAdaptador() {
        adapter = new Dise.CustomAdapter(this, lista);
        listView.setAdapter(adapter);
    }
}
