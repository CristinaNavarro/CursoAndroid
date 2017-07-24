package com.example.android7ed.listadolocales.ClasesFuncionales;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android7ed.listadolocales.R;

import java.util.ArrayList;

/**
 * Created by android7Ed on 24/07/2017.
 */

public class LocalAdapter extends BaseAdapter {
    private Context mContext;
    int resource;
    ArrayList<Local> listp;


    public LocalAdapter(Context context,int resourceP,ArrayList<Local> list_baresP){
        mContext = context;
        resource = resourceP;
        listp = list_baresP;
    }

    @Override
    public int getCount() {
        return listp.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View gridElement=null;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) { //Nuevo es necesario crear
            gridElement = inflater.inflate(resource, null);

        } else { //Reciclado, ya creado
            gridElement = (View) view;
        }

        TextView textViewID  = (TextView) gridElement.findViewById(R.id.text_ID);
        TextView textViewName = (TextView) gridElement.findViewById(R.id.text_Nombre);


        textViewID.setText  ( ""+listp.get(i).getID());
        textViewName.setText( listp.get(i).getNombre());


        return gridElement;
    }
}
