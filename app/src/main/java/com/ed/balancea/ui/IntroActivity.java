package com.ed.balancea.ui;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.ed.balancea.R;

public class IntroActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private LinearLayout dotsLayout;
    private IntroSliderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // Ocultar ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        viewPager = findViewById(R.id.viewPager);
        dotsLayout = findViewById(R.id.layoutDots);

        adapter = new IntroSliderAdapter(this, viewPager);
        viewPager.setAdapter(adapter);

        setupIndicators();
        setupCurrentIndicator(0);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setupCurrentIndicator(position);
            }
        });
    }

    private void setupIndicators() {
        ImageView[] dots = new ImageView[adapter.getItemCount()];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(8, 0, 8, 0);

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dot_inactive));
            dots[i].setLayoutParams(params);
            dotsLayout.addView(dots[i]);
        }
    }

    private void setupCurrentIndicator(int position) {
        int childCount = dotsLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) dotsLayout.getChildAt(i);
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dot_active));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dot_inactive));
            }
        }
    }
}