package com.example.android7ed.radiobutton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rbMujer;
    RadioButton rbHombre;
    Button bCancelar;
    Button bAceptar;
    EditText etNombre;
    EditText etApellidos;
    RadioGroup rgSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbMujer = (RadioButton) findViewById(R.id.rbMujer);
        rbHombre = (RadioButton) findViewById(R.id.rbHombre);
        bCancelar = (Button) findViewById(R.id.bCancelar);
        bAceptar = (Button) findViewById(R.id.bAceptar);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellidos = (EditText) findViewById(R.id.etApellidos);
        rgSexo = (RadioGroup) findViewById(R.id.rgSexo);


        rbMujer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Se ha seleccionado MUJER", Toast.LENGTH_LONG).show();
            }
        });

        rbHombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Se ha seleccionado HOMBRE", Toast.LENGTH_LONG).show();
            }
        });

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

        bAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("nombre",etNombre.getText().toString());
                intent.putExtra("apellidos",etApellidos.getText().toString());
                rgSexo.getCheckedRadioButtonId();
                RadioButton asd = (RadioButton) findViewById(rgSexo.getCheckedRadioButtonId());
                intent.putExtra("sexo",asd.getText().toString());
                startActivityForResult(intent,0);
            }
        });

    }
}
