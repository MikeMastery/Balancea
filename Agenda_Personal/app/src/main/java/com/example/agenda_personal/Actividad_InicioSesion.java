package com.example.agenda_personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Actividad_InicioSesion extends AppCompatActivity {

    EditText editTextCorreo, editTextContraseña;
    Button buttonIniciarSesion, buttonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_inicio_sesion);

        editTextCorreo = findViewById(R.id.validaCorreo);
        editTextContraseña = findViewById(R.id.validaContra);
        buttonIniciarSesion = findViewById(R.id.btningresar);
        buttonRegistrar = findViewById(R.id.btnregistrar);

        buttonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correo = editTextCorreo.getText().toString().trim();
                String contraseña = editTextContraseña.getText().toString().trim();

                if (!isValidEmail(correo) || contraseña.isEmpty() || contraseña.length() < 6) {
                    Toast.makeText(Actividad_InicioSesion.this, "Correo o contraseña no válidos", Toast.LENGTH_SHORT).show();
                    return;
                }


                iniciarSesion();
            }
        });

        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Actividad_InicioSesion.this, Actividad_registrar.class);
                startActivity(intent);
            }
        });
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void iniciarSesion() {

        Intent intent = new Intent(Actividad_InicioSesion.this, MainActivity.class);
        startActivity(intent);

        Toast.makeText(Actividad_InicioSesion.this, "BIENVENIDO MICHAEL PEÑA, A TU AGENDA PERSONAL", Toast.LENGTH_SHORT).show();
    }
}
