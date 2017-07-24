package com.example.android7ed.listadolocales;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android7ed.listadolocales.ClasesFuncionales.Local;
import com.example.android7ed.listadolocales.ClasesFuncionales.LocalAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    final int MY_PERMISSIONS_REQUEST_MAPS=1;
    GoogleMap mapa = null;
    ListView locales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Local> listaLocales = new ArrayList<>();


        locales = (ListView) findViewById(R.id.lvListado);
        LocalAdapter adaptador;


        //CREACION VISTA

        String[][] tm1 = new String[][]  {{"-4.40144", "36.722614","pub","O' Donnell's"},
            {"-4.40724","36.722904","pub","Morrissey's"},
            {"-4.43576","36.6768659","pub","O'Learys Bar"},
            {"-4.40204","36.71991","bar","La Taberna Del Obispo"},
            {"-4.489788","36.7220033","bar","Casa Lola"},
            {"-4.459611","36.7297922","bar","Universitas Cafe"}};





        Local temp;
        for(int i=0; i<tm1.length;i++){
            temp = new Local(i,tm1[i][3]);
            temp.setLongitude(Double.parseDouble(tm1[i][0]));
            temp.setLatitude(Double.parseDouble(tm1[i][1]));
            temp.setTipo(tm1[i][2]);
            listaLocales.add(temp);
        }

        adaptador = new LocalAdapter(this, R.layout.local_item,listaLocales);


        locales.setAdapter(adaptador);

        //COMPROBACION PERMISOS MAPA

        MapFragment mapFragment = (MapFragment)
                getFragmentManager().findFragmentById(R.id.fMap);
        mapFragment.getMapAsync(this); //llama al metodo implementado

        //Comprueba si hay permisos
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"SIN permisos",Toast.LENGTH_LONG).show();
            //Si no los hay se le pide al usuario
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},
                    MY_PERMISSIONS_REQUEST_MAPS);
        } else {
            //Si los hay
            Toast.makeText(this, "Permisos concedidos", Toast.LENGTH_LONG).show();
        }











        //ANADIR EVENTO A LISTVIEW
        locales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String addresSS = listaLocales.get(position).getNombre();
                Toast.makeText(getApplicationContext(),addresSS,Toast.LENGTH_SHORT).show();

                if(addresSS.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Direccion vacia",Toast.LENGTH_SHORT).show();
                } else {

                    LatLng punto = new LatLng(listaLocales.get(position).getLatitude(),listaLocales.get(position).getLongitude());
                    if(punto!=null & mapa!= null) {
                        // map.setMyLocationEnabled(true);
                        mapa.clear();       //para ir quitando las marcas del mapa de busquedas anteriores
                        int zoom = 17;
                        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(punto, zoom));      //posicionar la camara en la zona del punto
                        mapa.addMarker(new MarkerOptions().title(addresSS)                //anadir la marca del punto (title = titulo,
                                .snippet("Subtitulo")                                         //snippet = lo que viene debajo del titulo(subtitulo),p position = latitud y longitud)
                                .position(punto));
                    }else{
                        Log.d("MAPAS","El punto es null");
                    }
                }
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap map) {     //sin este metodo no se puede acceder al mapa (al implementar OnMapReady..)
        mapa = map;
    }

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_MAPS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this,"Permisos concedidos",
                            Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this,
                            "SIN permisos", Toast.LENGTH_LONG).show();

            }
        }
    }


}

