package com.example.android7ed.examenandroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private GridView gvEstructura;
    private ArrayList<Bitmap> listaBitmap;
    BitmapAdapter adapt;

    private static String dir = "http://www.francisco.chicano.es/android/images/image.php?q=";



    Aplicacion app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent = getIntent();

        int num = intent.getIntExtra("numero",0);


        app = (Aplicacion) getApplication();  //Asi se obtiene la aplicacion

        listaBitmap = app.getListaBitmap();

      //  listaNumeros = intent.getIntegerArrayListExtra("lista");


        gvEstructura = (GridView) findViewById(R.id.gvEstructura);
        adapt = new BitmapAdapter(this);

        ///////////// CON DESCARGAIMAGEN
        /*
        new DescargaImagen(adapt).execute(dir+num);
        gvEstructura.setAdapter(adapt);
                                        */
        //adapt.add();
        ////////////////////////////
        new DescargarImagen2(this).execute(dir+num);
        gvEstructura.setAdapter(adapt);

        /////////////////Otra forma (CON DESCARGARIMAGEN2)
     /*   for(int c: listaNumeros) {
            new DescargarImagen2(this).execute(dir + c);

        }
        gvEstructura.setAdapter(adapt);


     gvEstructura.setAdapter(adapt);
        adapt.addAll(listaBitmap);


   /*     System.out.println(listaNumeros);

        for(int c: listaNumeros) {
            DescargaImagen descarga = new DescargaImagen();
            descarga.setAdaptador(adaptador);
            descarga.execute("http://www.francisco.chicano.es/android/images/image.php?q=" + c);
        }*/

    }


    //las imagenes se les pasa al adaptador ques es el que las coloca en el gridview


    public void onPost(Bitmap bm){

        //listaBitmap.add(bm);
        app.addImagen(bm);

        //adapt.add(bm);
        adapt.addAll(app.getListaBitmap());


    }

}
