package com.example.agenda_personal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity6 extends AppCompatActivity {
    TextView area;
    EditText base,altura;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);

        base=(EditText)findViewById(R.id.base);
        altura=(EditText)findViewById(R.id.altura);
        area=(TextView) findViewById(R.id.area);
        btnCalcular=(Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float b= Float.valueOf(base.getText().toString());
                float h= Float.valueOf(altura.getText().toString());
                float a= (b*h)/2;
                area.setText(String.valueOf(a));
            }
   });
}
}