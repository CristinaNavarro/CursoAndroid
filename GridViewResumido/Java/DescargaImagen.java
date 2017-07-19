package com.example.android7ed.preview;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


/**
 * Created by android7Ed on 11/07/2017.
 */

public class DescargaImagen extends AsyncTask<String,Void,Bitmap> { //<parametro q se le pasa, progreso, resultado>

    final String direccion = "http://www.francisco.chicano.es/android/images/image.php?q=1";
    BitmapAdapter adaptador;
    public void setAdaptador(BitmapAdapter adaptador){
        this.adaptador = adaptador;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);  //se escribe asi y no me lo acepta
            InputStream is = url.openStream();
            Bitmap bm = BitmapFactory.decodeStream(is);
            return bm;

        } catch (MalformedURLException e) {

        } catch (IOException e) {

        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        adaptador.add(bitmap);
    }
}

////////////// Otra forma de hacerlo, con publishProgress y onProgressUpdate. Hay que cambiar el parámetro del centro de Asynctask <String,Bitmap, Void>////////
/*
protected void onProgressupodate(Bitmap... values){
    adaptador.add(values[0]);
}

protected void doInBackground(String... params){

    for(int i=01; i<=68;i++){
        publishProgress(getBitmap(params[0]+i));
    }
    return null;
}

private Bitmap  getBitmap(String params) {
 try {
            URL url = new URL(params[0]);  //se escribe asi y no me lo acepta
            InputStream is = url.openStream();
            Bitmap bm = BitmapFactory.decodeStream(is);
            return bm;

        } catch (MalformedURLException e) {

        } catch (IOException e) {

        }
        return null;
 */