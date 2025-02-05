package com.example.agenda_personal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    PrimerFragment primerFragment = new PrimerFragment();

    SegundoFragment segundoFragment = new SegundoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottonNavegationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.home) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flFragment, primerFragment).commit();
            return true;
        }

        if (item.getItemId() == R.id.bcal) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flFragment, segundoFragment).commit();
            return true;
        }
        return false;
    }
}