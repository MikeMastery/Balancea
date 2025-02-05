package com.example.agenda_personal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import BD.DBCliente;

public class Actividad_registrar extends AppCompatActivity {
    EditText etnombre, etciudad, ettelefono, etcorreo, etcontras;
    Button btn, btnretroceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_registrar);
        etnombre=findViewById(R.id.txtnc);
        etciudad=findViewById(R.id.txtcd);
        ettelefono=findViewById(R.id.txttc);
        etcorreo=findViewById(R.id.txtcorrc);
        etcontras=findViewById(R.id.txtcontraseña);
        btn=findViewById(R.id.btnagregar);
        btnretroceder=findViewById(R.id.btnregresar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBCliente dbCliente= new DBCliente(Actividad_registrar.this);
                long id =dbCliente.InsertarCliente(etnombre.getText().toString(),
                        etciudad.getText().toString(),
                        ettelefono.getText().toString(),
                        etcorreo.getText().toString(),
                        etcontras.getText().toString());

                if (id>0){
                    Toast.makeText(Actividad_registrar.this, "SE A REGISTRADO CON EXITO.",
                            Toast.LENGTH_LONG).show();
                    limpiarcontroles();
                }else {
                    Toast.makeText(Actividad_registrar.this, "ERROR AL REGISTRARSE",
                            Toast.LENGTH_LONG).show();

                }

            }
        });

        btnretroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Actividad_registrar.this, Actividad_InicioSesion.class);
                startActivity(intent);

            }
        });



    }
    private void limpiarcontroles(){
        etnombre.setText("");
        etciudad.setText("");
        ettelefono.setText("");
        etcorreo.setText("");
        etcontras.setText("");
        etnombre.requestFocus();
    }
}