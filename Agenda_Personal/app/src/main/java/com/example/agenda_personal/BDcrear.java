package com.example.agenda_personal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import BD.DBHELPER;
import BDrecordatorios.BDrecord;

public class BDcrear extends AppCompatActivity {
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdcrear);
        button = findViewById(R.id.btncrear);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BDrecord bDrecord = new BDrecord(BDcrear.this);
                SQLiteDatabase db = bDrecord.getWritableDatabase();
                if (db != null) {
                    Toast.makeText(BDcrear.this, "BD CREADA CON EXITO",
                            Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(BDcrear.this, "ERROR AL CREAR AL BD",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
