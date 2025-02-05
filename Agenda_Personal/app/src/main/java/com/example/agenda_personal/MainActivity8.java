package com.example.agenda_personal;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

import BDrecordatorios.DBasignarRecordatorio;

public class MainActivity8 extends AppCompatActivity {
    TextView tv;
    Button button, mostrarrecordatorios, back;

    EditText editText_recorda;
    TextView fecha_guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main8);
        tv = findViewById(R.id.text);
        button=findViewById(R.id.guardar_recorda);
        editText_recorda=findViewById(R.id.editTextRecordatorio);
        fecha_guardar=findViewById(R.id.text);
        mostrarrecordatorios=findViewById(R.id.recorda);
        back=findViewById(R.id.regresar_recorda);


    }


    public void AbrirCalendario(View view) {
        Calendar cal = Calendar.getInstance();
        int anio = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(MainActivity8.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String fecha = dayOfMonth + "/" + month +"/"+ year;
                tv.setText(fecha);
            }

        },anio, mes, dia);
        dpd.show();

            button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBasignarRecordatorio dBasignarRecordatorio = new DBasignarRecordatorio(MainActivity8.this);
                long id = dBasignarRecordatorio.Insertarrecordatorio(editText_recorda.getText().toString(),
                        fecha_guardar.getText().toString());

                if (id > 0) {
                    Toast.makeText(MainActivity8.this, "SE A REGISTRADO CON EXITO.",
                            Toast.LENGTH_LONG).show();
                    limpiarcontroles();
                } else {
                    Toast.makeText(MainActivity8.this, "ERROR AL REGISTRARSE",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                }
            });

        mostrarrecordatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), lista_recordatorios.class);
                startActivity(intent);
            }
        });
    }



    private void limpiarcontroles() {
        editText_recorda.setText("");
        fecha_guardar.setText("");
    }
}







