package com.example.android7ed.listapermisos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android7ed.listapermisos.ClasesFuncionales.AppUtil;
import com.example.android7ed.listapermisos.ClasesFuncionales.Permisos;

import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity {

    Button bSpinner;
    Button bListView;

    public static String PermisosN = "PERMISOS";

    ArrayList<Permisos> listaPermisos;  //IMPORTANTE para pasar una lista por intent de objetos tiene que ser un ArrayList
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        listaPermisos = (ArrayList<Permisos>) AppUtil.todosPermisos(getApplicationContext());

        bSpinner = (Button) findViewById(R.id.bSpinner);
        bListView= (Button) findViewById(R.id.bListView);

        bSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SpinnerClase.class);
                intent.putExtra(PermisosN,listaPermisos);
                startActivity(intent);
            }
        });


        bListView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ListViewClase.class);
                intent.putExtra(PermisosN,listaPermisos);
                startActivity(intent);
            }
        });
    }
}
