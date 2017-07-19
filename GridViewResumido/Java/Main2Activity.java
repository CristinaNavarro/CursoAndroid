package com.example.android7ed.preview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    private ImageView ivImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //como coger imagenes entre actividades de un intent(getParcelableExtra)
        ivImagen = (ImageView) findViewById(R.id.ivImagen);
        Bitmap bitmap = getIntent().getParcelableExtra("imagen");
        ivImagen.setImageBitmap(bitmap);
    }
}
