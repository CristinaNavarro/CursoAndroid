package com.example.android7ed.radiobutton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        tvDatos = (TextView) findViewById(R.id.tvDatos);
        tvDatos.setText(intent.getStringExtra("nombre")+" " +intent.getStringExtra("apellidos") +" " +intent.getStringExtra("sexo"));
    }
}
