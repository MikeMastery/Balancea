package com.ed.balancea.ui;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.ed.balancea.MainActivity;
import com.ed.balancea.R;

public class IntroSliderAdapter extends RecyclerView.Adapter<IntroSliderAdapter.SliderViewHolder> {
    private Context context;
    private ViewPager2 viewPager;
    private int[] backgrounds;
    private String[] buttonTexts;

    public IntroSliderAdapter(Context context, ViewPager2 viewPager) {
        this.context = context;
        this.viewPager = viewPager;

        // Define los recursos para cada página
        backgrounds = new int[]{
                R.drawable.ini1,
                R.drawable.ini2,
                R.drawable.ini3
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
        return backgrounds.length;
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {
        private ImageView backgroundImage;
        private Button nextButton;

        SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            backgroundImage = itemView.findViewById(R.id.background_image);
            nextButton = itemView.findViewById(R.id.btn_next);
        }

        void setContent(final int position) {
            backgroundImage.setImageResource(backgrounds[position]);
            nextButton.setText(buttonTexts[position]);

            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position < getItemCount() - 1) {
                        viewPager.setCurrentItem(position + 1);
                    } else {
                        Intent intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);
                        ((Activity) context).finish();
                    }
                }
            });
        }
    }
}