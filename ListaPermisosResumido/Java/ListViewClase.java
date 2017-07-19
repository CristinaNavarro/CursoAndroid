package com.example.android7ed.listapermisos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android7ed.listapermisos.ClasesFuncionales.Permisos;

import java.util.ArrayList;
import java.util.List;

public class ListViewClase extends AppCompatActivity {

    ListView lvLista;
    TextView tvDescripcionListView;
    List<Permisos> listaPermisos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_clase);

        Intent actividadPadre = getIntent();
        listaPermisos = (ArrayList<Permisos>) actividadPadre.getSerializableExtra(Principal.PermisosN);

        lvLista = (ListView) findViewById(R.id.lvLista);
        tvDescripcionListView = (TextView) findViewById(R.id.tvDescripcionListView);

        ArrayAdapter<Permisos> adaptadorListView = new ArrayAdapter<Permisos>(this, R.layout.item,listaPermisos);
        lvLista.setAdapter(adaptadorListView);

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvDescripcionListView.setText(listaPermisos.get(position).getDescripcion());
            }
        });
    }
}
