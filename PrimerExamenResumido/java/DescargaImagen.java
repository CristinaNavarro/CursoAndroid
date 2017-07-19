package com.example.android7ed.examenandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by android7Ed on 13/07/2017.
 */

public class DescargaImagen extends AsyncTask<String,Void,Bitmap> {

    BitmapAdapter adaptador;

    public DescargaImagen(BitmapAdapter adapterP){
        super();
        adaptador = adapterP;

    }

    public void setAdaptador(BitmapAdapter adaptador){
        this.adaptador = adaptador;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        try{
            URL url = new URL(urls[0]);
            InputStream is = url.openStream();
            Bitmap bm = BitmapFactory.decodeStream(is);
            return bm;

        }catch (MalformedURLException e){
            Log.e("Descargar","Error descarga imagen");
        }catch (IOException e){
            Log.e("Descargar","Error descarga imagen");
        }

        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bm) {
        if(bm!=null){
            adaptador.add(bm);
        }
    }
}


//puede tener 3 metodos, doInBackground, onProgressUpdate, onPostExecute
//los obligatorios son doInBackground y onPostExecute
//onProgressUpdate sirve para crear graficas por ejemplo