package com.example.agenda_personal;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity9 extends AppCompatActivity {

    private TextView resultadoTextView;
    private ImageView dadoImageView;
    private Button lanzarDadoButton;

    // Lista de recursos de las imágenes de las caras del dado
    private final int[] carasDado = {
            R.drawable.cara111,
            R.drawable.cara22,
            R.drawable.cara33,
            R.drawable.cara44,
            R.drawable.cara55,
            R.drawable.cara66
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        // Vincular vistas del diseño XML con variables de la actividad
        resultadoTextView = findViewById(R.id.resultadoTextView);
        dadoImageView = findViewById(R.id.dadoImageView);
        lanzarDadoButton = findViewById(R.id.lanzarDadoButton);

        // Configurar OnClickListener para el botón "Lanzar dado"
        lanzarDadoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarDado();
            }
        });
    }

    // Función para lanzar el dado
    private void lanzarDado() {
        // Cargar y empezar la animación de giro del dado
        dadoImageView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.animacion_dado1));

        // Seleccionar aleatoriamente una cara del dado
        int indiceCara = new Random().nextInt(carasDado.length);
        int caraSeleccionada = carasDado[indiceCara];

        // Mostrar el resultado en el TextView y en el ImageView del dado
        resultadoTextView.setText(String.valueOf(indiceCara + 1));
        dadoImageView.setImageResource(caraSeleccionada);
    }
}
