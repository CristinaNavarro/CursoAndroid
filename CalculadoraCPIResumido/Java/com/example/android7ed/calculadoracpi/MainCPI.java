package com.example.android7ed.calculadoracpi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ClasesFuncionales.CalculadoraCPI;

public class MainCPI extends AppCompatActivity {

    CalculadoraCPI cpi;
    EditText texto;
    TextView res;
    TextView secuencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cpi);
        cpi = new CalculadoraCPI();
        texto = (EditText) findViewById(R.id.entrada);
        res = (TextView) findViewById(R.id.mostrar);
        secuencia = (TextView) findViewById(R.id.secuencia);
      //  prueba1();
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.bSuma:
                secuencia.setText(secuencia.getText()+"+");
                Log.d("Suma","entra");
                cpi.suma();
                break;
            case R.id.bResta:
                secuencia.setText(secuencia.getText()+"-");
                cpi.resta();
                break;
            case R.id.bMultiplicacion:
                secuencia.setText(secuencia.getText()+"*");
                cpi.multiplica();
                break;
            case R.id.bDivide:
                secuencia.setText(secuencia.getText()+"/");
                cpi.divide();
                break;
            case R.id.bEntra:
                secuencia.setText(secuencia.getText()+texto.getText().toString());
                Log.d("Entra","entra");
                String cadena = texto.getText().toString();
                if(!cadena.isEmpty()) {
                    cpi.entra(Double.parseDouble(cadena));
                }
                break;
            case R.id.bResultado:
                Log.d("Resultado",""+cpi.getResultado());
                cpi.getResultado();
                res.setText(""+cpi.getResultado());
                break;

        }
    }

    private void prueba1 (){

        cpi.entra(3);
        cpi.entra(6);
        cpi.entra(4);
        cpi.resta();
        cpi.multiplica();
        cpi.entra(5);
        cpi.suma();
        Toast.makeText(this,"Resultado " + cpi.getResultado(),Toast.LENGTH_LONG).show();
    }


}
