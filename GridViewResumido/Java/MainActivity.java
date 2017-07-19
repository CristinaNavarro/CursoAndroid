package com.example.android7ed.preview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    final String [] valores = new String[]{"Maria","Paco", "Manolo", "Antonio"};

    private GridView glEstructura;
    private ArrayAdapter<String> adaptador;
    private ImageAdapter adaptadorImagenes; //Forma 4: creando una clase y teniendo las imagenes en drawable
    private BitmapAdapter bAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        glEstructura = (GridView) findViewById(R.id.glEstructura);





       // Forma 4
       /* adaptadorImagenes = new ImageAdapter(this);
        glEstructura.setAdapter(adaptadorImagenes);
       // adaptadorImagenes.add(getResources().getDrawable(R.drawable.sample_0)); //versiones anteriores a 21
          adaptadorImagenes.add(getDrawable(R.drawable.sample_0));
          adaptadorImagenes.add(getDrawable(R.drawable.sample_1));
          adaptadorImagenes.add(getDrawable(R.drawable.sample_2));
          adaptadorImagenes.add(getDrawable(R.drawable.sample_3));
          adaptadorImagenes.add(getDrawable(R.drawable.sample_4));
          adaptadorImagenes.add(getDrawable(R.drawable.sample_5));
          adaptadorImagenes.add(getDrawable(R.drawable.sample_6));
          adaptadorImagenes.add(getDrawable(R.drawable.sample_7)); //tachon rojo, en algunos dispositivos puede no funcionar, tachado, deprecated
        */
     /*    List<String> datos = new ArrayList<>();
        datos.add("Maria");
        datos.add("Paco");
        datos.add("Manolo");
        datos.add("Antonio");


        adaptador = new ArrayAdapter<String>(this, R.layout.otraentrada, R.id.tvNombre );
        glEstructura.setAdapter(adaptador);
        adaptador.addAll(datos); //Forma 2: creando array y anadiendo todos los datos (adaptador.addAll(valores))
                                //Forma 3: creando una List y anadiendole los valores*/

       /* Forma 1: anadiendo nombre a nombre

       adaptador.add("Maria");
        adaptador.add("Paco");
        adaptador.add("Manolo");
        adaptador.add("Antonio");*/

       bAdapter = new BitmapAdapter(this);
       glEstructura.setAdapter(bAdapter);
        for(int i=1; i<=68;i++) {
            DescargaImagen descarga = new DescargaImagen();
            descarga.setAdaptador(bAdapter);
            descarga.execute("http://www.francisco.chicano.es/android/images/image.php?q=" +i); //url es la direccion quie nos ha dado
        }
//////////////// Abrir actividad al hacer click en una imagen /////////////////////
        glEstructura.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bitmap bm = bAdapter.getItem(position);
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);

                intent.putExtra("imagen",bm);
                startActivity(intent);
            }
        });
    }
}
