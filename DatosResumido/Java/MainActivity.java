package com.example.android7ed.datos;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView marca;
    TextView modelo;
    TextView producto;
    TextView factura;
    TextView sdk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marca = (TextView) findViewById(R.id.marca);
        marca.setText("Brand: "+Build.BRAND);
        modelo = (TextView) findViewById(R.id.modelo);
        modelo.setText("Model: "+Build.MODEL);
        producto = (TextView) findViewById(R.id.producto);
        producto.setText("Product: "+Build.PRODUCT);
        factura = (TextView) findViewById(R.id.factura);
        factura.setText("Manufacturer: "+Build.MANUFACTURER);
        sdk = (TextView) findViewById(R.id.sdk);
        sdk.setText("SDK_INT: "+Build.VERSION.SDK_INT);

    }
}
