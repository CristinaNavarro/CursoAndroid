package com.example.android7ed.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Spinner vacacionesDestino;
    ListView lvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vacacionesDestino = (Spinner) findViewById(R.id.vacacionesDestino);

        lvLista = (ListView) findViewById(R.id.lvLista);


     // Creando Spinner usando Array
     /*
      final String[] viaje = new String[]{"New York","Lisboa","Madrid"};      //lo que ira dentro del Spinner

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,viaje);        //Se le anade al adaptador

        vacacionesDestino.setAdapter(adaptador);        //se anade el adaptador al Spinner
     */


     //Creando Spinner usando recurso

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.opcionesVacaciones, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vacacionesDestino.setAdapter(adaptador);

        lvLista.setAdapter(adaptador);


        vacacionesDestino.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {       //posicion que el usuario ha seleccionado de ese adaptador
                //String nombre = (String) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),"Nos vamos a " +parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"ListView " +parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
            }
        });






    }
}
