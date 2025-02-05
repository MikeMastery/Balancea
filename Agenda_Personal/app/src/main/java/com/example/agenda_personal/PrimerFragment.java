package com.example.agenda_personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Handler;

import androidx.fragment.app.Fragment;

public class PrimerFragment extends Fragment {

    Button  btncambioMoneda;

    public PrimerFragment() {
        // Required empty public constructor
    }

    public static PrimerFragment newInstance(String param1, String param2) {
        PrimerFragment fragment = new PrimerFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primer, container, false);

        ImageView ajustesImageView = view.findViewById(R.id.ajustes);
        ImageView menuImageView = view.findViewById(R.id.menu);
        ImageView Acirculo = view.findViewById(R.id.aCirculo);
        ImageView Usuario = view.findViewById(R.id.usuario);
        ImageView Atriangulo = view.findViewById(R.id.aTriangulo);
        ImageView cambioMoneda = view.findViewById(R.id.Tcambio);
        ImageView Calendario = view.findViewById(R.id.calendario);
        ImageView juegoDados = view.findViewById(R.id.dado);



        ajustesImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateImage(v);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent actividad2ajustes = new Intent(getContext(), MainActivity2.class);
                        startActivity(actividad2ajustes);
                    }
                }, 350); //
            }
        });

        menuImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateImage(v);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent actividad3menu = new Intent(getContext(), MainActivity3.class);
                        startActivity(actividad3menu);
                    }
                }, 350); //
            }
        });

        Acirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateImage(v);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent actividad4Acirculo = new Intent(getContext(), MainActivity4.class);
                        startActivity(actividad4Acirculo);
                    }
                }, 350); //
            }
        });

        Usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateImage(v);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent actividad5Usuario = new Intent(getContext(), MainActivity5.class);
                        startActivity(actividad5Usuario);
                    }
                }, 350); //
            }
        });


        Atriangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateImage(v);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent actividad6ATriangulo = new Intent(getContext(), MainActivity6.class);
                        startActivity(actividad6ATriangulo);
                    }
                }, 350); //
            }
        });


        cambioMoneda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateImage(v);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent actividad7cambio = new Intent(getContext(), MainActivity7.class);
                        startActivity(actividad7cambio);
                    }
                }, 350); //
            }
        });


        Calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateImage(v);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent actividad8calendario = new Intent(getContext(), MainActivity8.class);
                        startActivity(actividad8calendario);


                    }
                }, 350); //
            }
        });


        juegoDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateImage(v);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent actividad9dados = new Intent(getContext(), MainActivity9.class);
                        startActivity(actividad9dados);
                    }
                }, 350); //
            }
        });




        return view;
    }

    private void animateImage(View view) {
        Animation anim = new ScaleAnimation(
                1f, 0.9f,
                1f, 0.9f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        anim.setFillAfter(true);
        anim.setDuration(350); //
        view.startAnimation(anim);
    }
}
