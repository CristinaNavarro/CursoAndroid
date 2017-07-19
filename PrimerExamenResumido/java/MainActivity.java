package com.example.android7ed.examenandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etEntrada;
    private Button bImagen;
   // private ArrayList<Integer> listaNumeros = new ArrayList<>();


    /////////////////////////////////////////




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEntrada = (EditText) findViewById(R.id.etEntrada);
        bImagen = (Button) findViewById(R.id.bImagen);

        bImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etEntrada.getText().toString().matches("[0-9]+") || etEntrada.getText().toString().matches("-[0-9]+") ){
                    if(Integer.parseInt(etEntrada.getText().toString())<1 || Integer.parseInt(etEntrada.getText().toString())>68){
                        Toast.makeText(getApplicationContext(),R.string.noRango,Toast.LENGTH_LONG).show();
                    }else{
                        Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                       // listaNumeros.add(Integer.parseInt(etEntrada.getText().toString()));
                        //intent.putIntegerArrayListExtra("lista",listaNumeros);
                        intent.putExtra("numero",Integer.parseInt(etEntrada.getText().toString()));
                        startActivity(intent);
                    }
                }else{
                    Toast.makeText(getApplicationContext(),R.string.noNumero,Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
