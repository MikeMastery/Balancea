package com.ed.balancea.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.ed.balancea.MainActivity;
import com.ed.balancea.R;

public class IntroSliderAdapter extends RecyclerView.Adapter<IntroSliderAdapter.SliderViewHolder> {
    private Context context;
    private ViewPager2 viewPager;  // ViewPager2 para manejar el deslizamiento
    private int[] backgrounds;
    private int[] icons;
    private String[] titles;
    private String[] descriptions;
    private String[] buttonTexts;

    // Constructor actualizado para recibir el ViewPager2
    public IntroSliderAdapter(Context context, ViewPager2 viewPager) {
        this.context = context;
        this.viewPager = viewPager;

        // Define los recursos para cada página
        backgrounds = new int[]{
                R.drawable.fondo,
                R.drawable.fondo,
                R.drawable.fondo
        };

        icons = new int[]{
                R.drawable.yoga,
                R.drawable.yoga,
                R.drawable.yoga
        };

        titles = new String[]{
                "Balancea!",
                "Medita",
                "Relájate"
        };

        descriptions = new String[]{
                "A healthy mind is a Treasure",
                "Find your inner peace",
                "Start your journey"
        };

        buttonTexts = new String[]{
                "Siguiente",
                "Siguiente",
                "Comenzar"
        };
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(context).inflate(R.layout.intro_slide, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setContent(position);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {
        private ImageView backgroundImage;
        private ImageView iconImage;
        private TextView titleText;
        private TextView descriptionText;
        private Button nextButton;

        SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            backgroundImage = itemView.findViewById(R.id.background_image);
            iconImage = itemView.findViewById(R.id.icon_image);
            titleText = itemView.findViewById(R.id.title);
            descriptionText = itemView.findViewById(R.id.descripcion);
            nextButton = itemView.findViewById(R.id.btn_next);
        }

        void setContent(final int position) {
            backgroundImage.setImageResource(backgrounds[position]);
            iconImage.setImageResource(icons[position]);
            titleText.setText(titles[position]);
            descriptionText.setText(descriptions[position]);
            nextButton.setText(buttonTexts[position]);

            // Configurar el click del botón
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position < getItemCount() - 1) {
                        // Si no es la última página, avanza a la siguiente
                        viewPager.setCurrentItem(position + 1);
                    } else {
                        // Si es la última página, inicia MainActivity
                        Intent intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);
                        ((Activity) context).finish(); // Cierra la intro
                    }
                }
            });
        }
    }
}