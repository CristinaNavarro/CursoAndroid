package com.example.android7ed.intentexplicitoversion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button actividad;
    private TextView etiqueta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actividad = (Button) findViewById(R.id.llamadaActividad);
        etiqueta = (TextView) findViewById(R.id.etiqueta);

        actividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);

                intent.putExtra("cadena1","esta es la cadena 1");
                intent.putExtra("cadena2","esta es la cadena 2");

                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == RESULT_OK){
            etiqueta.setText(data.getStringExtra("cadena"));
        }
    }
}
