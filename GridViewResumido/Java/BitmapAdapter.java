package com.example.android7ed.preview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;


/**
 * Created by android7Ed on 11/07/2017.
 */

public class BitmapAdapter extends ArrayAdapter<Bitmap> {
    private Context contexto;

    public BitmapAdapter(Context ctx){
        super(ctx,0);
        contexto=ctx;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imagen = new ImageView(contexto);
        //determinar tamano imagenes
        int columnWidth = ((GridView)parent).getColumnWidth();
        imagen.setLayoutParams(new GridView.LayoutParams(columnWidth,columnWidth));
        imagen.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //
        Bitmap bitmap = getItem(position);
        imagen.setImageBitmap(bitmap);
        return imagen;
    }
}
