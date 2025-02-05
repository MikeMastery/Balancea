package com.example.agenda_personal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SegundoFragment extends Fragment {
    private EditText etNumero1;
    private EditText etNumero2;
    private EditText etResultado;

    public SegundoFragment() {
        // Required empty public constructor
    }

    public static SegundoFragment newInstance() {
        SegundoFragment fragment = new SegundoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_segundo, container, false);


        etNumero1 = view.findViewById(R.id.etnumero1);
        etNumero2 = view.findViewById(R.id.etnumero2);
        etResultado = view.findViewById(R.id.etResultado);




        ImageView iconoSuma = view.findViewById(R.id.operation_icon_sum);
        iconoSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateImage(v);
                if (validateInputs()) {
                    realizarOperacion('+');
                }
            }
        });


        ImageView iconoResta = view.findViewById(R.id.operation_icon_res);
        iconoResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateImage(v);
                if (validateInputs()) {
                    realizarOperacion('-');
                }
            }
        });


        ImageView iconoMultipli = view.findViewById(R.id.operation_icon_mul);
        iconoMultipli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateImage(v);
                if (validateInputs()) {
                    realizarOperacion('*');
                }
            }
        });


        ImageView iconoDivi = view.findViewById(R.id.operation_icon_div);
        iconoDivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateImage(v);
                if (validateInputs()) {
                    realizarOperacion('/');
                }
            }
        });


        return view;
    }


    private void realizarOperacion(char operador) {
        int numero1 = Integer.parseInt(etNumero1.getText().toString());
        int numero2 = Integer.parseInt(etNumero2.getText().toString());
        int resultado = 0;

        switch (operador) {
            case '+':
                resultado = numero1 + numero2;
                break;
            case '-':
                resultado = numero1 - numero2;
                break;
            case '*':
                resultado = numero1 * numero2;
                break;
            case '/':
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {

                    Toast.makeText(getContext(), "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                }
                break;
        }

        // Mostrar resultado en el EditText
        etResultado.setText(String.valueOf(resultado));
    }
    private boolean validateInputs() {
        String numero1Str = etNumero1.getText().toString().trim();
        String numero2Str = etNumero2.getText().toString().trim();

        if (numero1Str.isEmpty() || numero2Str.isEmpty()) {

            Toast.makeText(getContext(), "Por favor, introduce números en ambos campos.", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }


    private void animateImage(View view) {
        Animation anim = new ScaleAnimation(
                1f, 0.9f,
                1f, 0.9f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        anim.setFillAfter(true);
        anim.setDuration(100);
        view.startAnimation(anim);
    }
}
