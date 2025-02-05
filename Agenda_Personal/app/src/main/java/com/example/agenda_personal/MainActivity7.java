package com.example.agenda_personal;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity7 extends AppCompatActivity {

    EditText cantidadSolesEditText;
    EditText resultadoEditText;

    ImageButton eeuuImageButton;
    ImageButton mexicoImageButton;
    ImageButton japonImageButton;
    ImageButton europaImageButton;
    ImageButton reinoImageButton;
    ImageButton canadaImageButton;

    double tipoCambioUSD = 3.73;
    double tipoCambioMXN = 0.23;
    double tipoCambioJPY = 0.025;
    double tipoCambioEUR = 4.02;
    double tipoCambioGBP = 4.68;
    double tipoCambioCAD = 2.73;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        cantidadSolesEditText = findViewById(R.id.cantidadsoles);
        resultadoEditText = findViewById(R.id.result2);
        eeuuImageButton = findViewById(R.id.ibtneeuu);
        mexicoImageButton = findViewById(R.id.ibtnmx);
        japonImageButton = findViewById(R.id.ibtnjapon);
        europaImageButton = findViewById(R.id.ibtneuropa);
        reinoImageButton = findViewById(R.id.ibtnreino);
        canadaImageButton = findViewById(R.id.ibtncanada);

        eeuuImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir("USD", "$  ");
            }
        });

        mexicoImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir("MXN", "MXN$  ");
            }
        });

        japonImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir("JPY", "¥  ");
            }
        });

        europaImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir("EUR", "€  ");
            }
        });

        reinoImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir("GBP", "£  ");
            }
        });

        canadaImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir("CAD", "CAD$  ");
            }
        });
    }

    private void convertir(String monedaDestino, String simboloMoneda) {
        double cantidadSoles = Double.parseDouble(cantidadSolesEditText.getText().toString());
        double resultado;

        switch (monedaDestino) {
            case "USD":
                resultado = cantidadSoles / tipoCambioUSD;
                break;
            case "MXN":
                resultado = cantidadSoles / tipoCambioMXN;
                break;
            case "JPY":
                resultado = cantidadSoles / tipoCambioJPY;
                break;
            case "EUR":
                resultado = cantidadSoles / tipoCambioEUR;
                break;
            case "GBP":
                resultado = cantidadSoles / tipoCambioGBP;
                break;
            case "CAD":
                resultado = cantidadSoles / tipoCambioCAD;
                break;
            default:
                resultado = cantidadSoles;
                break;
        }

        DecimalFormat decimalFormat = new DecimalFormat("#,##.##");
        String resultadoFormateado = decimalFormat.format(resultado);
        resultadoEditText.setText(simboloMoneda + resultadoFormateado);
    }
}
