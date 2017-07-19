package com.example.android7ed.examenandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by android7Ed on 18/07/2017.
 */

public class DescargarImagen2 extends AsyncTask<String,Void,Bitmap>{

    Main2Activity actividad;




    public DescargarImagen2(Main2Activity actividad){
        super();
        this.actividad = actividad;

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
        actividad.onPost(bm);
    }

}
