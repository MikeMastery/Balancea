package com.example.agenda_personal;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity4 extends AppCompatActivity {

    private EditText radioEditText;
    private Button calcularButton;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        radioEditText = findViewById(R.id.radioEditText);
        calcularButton = findViewById(R.id.calcularButton);
        resultadoTextView = findViewById(R.id.resultadoTextView);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularArea();
            }
        });
    }

    private void calcularArea() {
        String radioText = radioEditText.getText().toString().trim();
        if (!radioText.isEmpty()) {
            double radio = Double.parseDouble(radioText);
            double area = calcularAreaCirculo(radio);
            DecimalFormat formato = new DecimalFormat("#.##");
            resultadoTextView.setText("El área del círculo es: " + formato.format(area));
        } else {
            resultadoTextView.setText("Por favor, ingresa el radio del círculo");
        }
    }

    private double calcularAreaCirculo(double radio) {
        return Math.PI * radio * radio;
    }
}
