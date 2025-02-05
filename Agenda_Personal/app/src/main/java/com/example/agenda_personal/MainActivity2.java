package com.example.agenda_personal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.btncerrarSesión);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividadcerrar = new Intent(getApplicationContext(), Actividad_InicioSesion.class);
                startActivity(actividadcerrar);

                Toast.makeText(MainActivity2.this, "Has cerrado sesión", Toast.LENGTH_SHORT).show();
            }
        });
    }
}