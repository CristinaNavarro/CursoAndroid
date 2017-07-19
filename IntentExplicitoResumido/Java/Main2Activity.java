package com.example.android7ed.intentexplicitoversion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button finalizar;
    private EditText entrada1;
    private EditText entrada2;
    private Button qr;
    private Button scan;

    private CheckBox check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        entrada1 = (EditText) findViewById(R.id.entrada1);
        entrada2 = (EditText) findViewById(R.id.entrada2);
        check = (CheckBox) findViewById(R.id.checkBox);
        qr = (Button) findViewById(R.id.qr);
        scan = (Button) findViewById(R.id.escanear);

        entrada1.setText(intent.getStringExtra("cadena1"));
        entrada2.setText(intent.getStringExtra("cadena2"));

        finalizar = (Button) findViewById(R.id.finalizar);
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.google.string.cliente.android.ENCODE");
                intent.putExtra("ENCODE_FORMAT","QR_CODE");
                intent.putExtra("ENCODE_TYPE","TEXT_TYPE");
                intent.putExtra("ENCODE_DATA", entrada1.getText().toString());
                intent.putExtra("ENCODE_SHOW_COMPONENTS",true);

                startActivity(intent);
            }
        });

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("com.google.string.cliente.android.SCAN");
                i.putExtra("SCAN_CODE", "QR_CODE_MODE");
                startActivityForResult(i,0);
            }
        });



    }

    @Override
    public void finish(){
        String resultado = entrada1.getText().toString() + " " + entrada2.getText().toString() + " " + (check.isChecked() ? "checked " :  "unchecked");
        Intent intent = new Intent();
        intent.putExtra("cadena", resultado);
        setResult(RESULT_OK,intent);
        Toast.makeText(getApplicationContext(),resultado,Toast.LENGTH_LONG).show();
        super.finish();
    }

    public void setActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            entrada2.setText(data.getStringExtra("SCAN_RESULT"));
        }
    }
}
//me ha faltado que en etiqueta se ponga el texto de los dos edittext y del check (no funciona)

//tampoco funciona lo del QR