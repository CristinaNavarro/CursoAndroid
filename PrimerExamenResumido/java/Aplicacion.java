package com.example.android7ed.examenandroid;

import android.app.Application;
import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by android7Ed on 18/07/2017.
 */

public class Aplicacion extends Application {

    private ArrayList<Bitmap> listaBitmap;

    @Override
    public void onCreate(){
        super.onCreate();

        listaBitmap = new ArrayList<>();


    }

    public ArrayList<Bitmap> getListaBitmap(){
        return listaBitmap;
    }

    public void addImagen(Bitmap bm){
        listaBitmap.add(bm);
    }
}
