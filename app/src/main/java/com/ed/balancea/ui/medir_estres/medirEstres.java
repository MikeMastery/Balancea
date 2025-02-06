package com.ed.balancea.ui.medir_estres;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.ed.balancea.R;

public class medirEstres extends Fragment {

    private ProgressBar stressLevelProgress;
    private Button feelingButton;
    private TextView relaxationTips;
    private TextView stressTitle;

    // Para simular el cambio en el nivel de estrés
    private int stressLevel = 50; // Valor inicial del estrés

    public medirEstres() {
        // Required empty public constructor
    }

    public static medirEstres newInstance(String param1, String param2) {
        medirEstres fragment = new medirEstres();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout
        View view = inflater.inflate(R.layout.fragment_medir_estres, container, false);

        // Vincular las vistas
        stressLevelProgress = view.findViewById(R.id.stressLevelProgress);
        feelingButton = view.findViewById(R.id.feelingButton);
        relaxationTips = view.findViewById(R.id.relaxationTips);
        stressTitle = view.findViewById(R.id.stressTitle);

        // Acción cuando el usuario presiona el botón de "¿Cómo te sientes?"
        feelingButton.setOnClickListener(v -> {
            // Lógica para registrar cómo se siente el usuario
            stressLevel = (stressLevel + 10) % 100; // Aumentar el nivel de estrés (simulación)
            updateStressLevel();

            // Mostrar mensaje de feedback
            Toast.makeText(getContext(), "¡Haz tomado el primer paso para relajarte!", Toast.LENGTH_SHORT).show();
        });

        return view;
    }

    // Método para actualizar el nivel de estrés en el ProgressBar
    private void updateStressLevel() {
        stressLevelProgress.setProgress(stressLevel);

        // Cambiar el color o el mensaje de relajación según el nivel de estrés
        if (stressLevel < 30) {
            relaxationTips.setText("¡Relajado! Sigue así.");
            relaxationTips.setTextColor(getResources().getColor(R.color.green));
            stressTitle.setText("Nivel de Estrés: Bajo");
        } else if (stressLevel < 60) {
            relaxationTips.setText("Tómate un respiro.");
            relaxationTips.setTextColor(getResources().getColor(R.color.yellow));
            stressTitle.setText("Nivel de Estrés: Moderado");
        } else {
            relaxationTips.setText("Respira profundamente.");
            relaxationTips.setTextColor(getResources().getColor(R.color.red));
            stressTitle.setText("Nivel de Estrés: Alto");
        }
    }
}
