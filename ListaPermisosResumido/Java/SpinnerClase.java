package com.example.android7ed.listapermisos;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android7ed.listapermisos.ClasesFuncionales.AppUtil;
import com.example.android7ed.listapermisos.ClasesFuncionales.Permisos;

import java.util.ArrayList;
import java.util.List;

public class SpinnerClase extends AppCompatActivity {

    TextView tvDescripcionSpinner;
    Spinner spLista;
    ArrayList<Permisos> listaPermisos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent actividadPadre = getIntent();
        listaPermisos = (ArrayList<Permisos>) actividadPadre.getSerializableExtra(Principal.PermisosN);



        ArrayAdapter spinnerAdapter = new ArrayAdapter<Permisos>(this, R.layout.item,listaPermisos);


        spLista = (Spinner) findViewById(R.id.spLista);
        spLista.setAdapter(spinnerAdapter);

        tvDescripcionSpinner = (TextView) findViewById(R.id.tvDescripcionSpinner);
        spLista = (Spinner) findViewById(R.id.spLista);

        spLista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvDescripcionSpinner.setText(listaPermisos.get(position).getDescripcion());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}
