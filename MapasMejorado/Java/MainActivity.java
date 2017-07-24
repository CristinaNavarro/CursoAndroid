package com.example.android7ed.mapas;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

//3A:D1:7F:86:B5:3A:0C:4A:32:DF:E1:F4:5A:C8:85:9B:3F:74:10:AA

//AIzaSyBSRP0KPb5hMg7T-BnXtwnUNNvw1Xs_0MQ (esta es la segunda que he pedido)
public class MainActivity extends AppCompatActivity implements
        OnMapReadyCallback {
    final int MY_PERMISSIONS_REQUEST_MAPS=1;

    EditText editTextAdress;
    Button bBuscar;

    GoogleMap mapa = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAdress = (EditText) findViewById(R.id.editTextAdress);
        bBuscar = (Button) findViewById(R.id.bBuscar);

        MapFragment mapFragment = (MapFragment)
                getFragmentManager().findFragmentById(R.id.map);
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


        bBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addresSS = editTextAdress.getText().toString();
                if(addresSS.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Direccion vacia",Toast.LENGTH_SHORT).show();
                } else {

                    LatLng punto = getLocationFromAddress(getApplicationContext(), editTextAdress.getText().toString());
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

    public LatLng getLocationFromAddress(Context context, String strAddress) {
        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;

        try {
            address = coder.getFromLocationName(strAddress, 5);
            if(address==null)
                return null;
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new LatLng(location.getLatitude(), location.getLongitude());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return p1;

    }
}
