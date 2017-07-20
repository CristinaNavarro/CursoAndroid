package com.example.android7ed.banderas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    GridView gvEstructura;

    Button bPrimero;
    Button bSegundo;
    Button bTercero;
    Button bCuarto;
    Button bPintar;

    EditText etPintar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gvEstructura = (GridView) findViewById(R.id.gvEstructura);


        bPrimero = (Button) findViewById(R.id.bPrimero);
        bSegundo = (Button) findViewById(R.id.bSegundo);
        bTercero = (Button) findViewById(R.id.bTercero);
        bCuarto = (Button) findViewById(R.id.bCuarto);
        bPintar = (Button) findViewById(R.id.bPintar);
        etPintar = (EditText) findViewById(R.id.edPintar);


      /* String[] values = new String[]{"brazil", "canada", "china", "france", "germany", "india", "italy", "japan",
                "korea", "mexico", "netherlands", "portugal", "spain", "turkey", "united_kingdom", "united_states"};*/

// references to our images
         Integer[] mThumbIds = {
                R.drawable.brazil, R.drawable.canada,
                R.drawable.china, R.drawable.france,
                R.drawable.germany, R.drawable.india,
                R.drawable.italy, R.drawable.japan,
                R.drawable.korea, R.drawable.mexico,
                R.drawable.netherlands, R.drawable.portugal,
                R.drawable.spain, R.drawable.turkey,
                R.drawable.united_kingdom, R.drawable.united_states
        };

        String[] mThumbDes = new String[]{"brazil", "canada", "china", "france", "germany", "india", "italy", "japan",
                "korea", "mexico", "netherlands", "portugal", "spain", "turkey", "united_kingdom", "united_states"};


      /*  final ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }


        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        */


        gvEstructura.setAdapter(new ImageAdapter(this, R.layout.gridlayout,mThumbIds,mThumbDes));


        bPrimero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gvEstructura.setNumColumns(1);
            }
        });

        bSegundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gvEstructura.setNumColumns(2);
            }
        });

        bTercero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gvEstructura.setNumColumns(3);
            }
        });

        bCuarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gvEstructura.setNumColumns(4);
            }
        });

    }                                                                               //se podrian cambiar los array de String e Integer por las clases Pais y Bandera si las creamos

    private class ImageAdapter extends BaseAdapter {
        private Context mContext;

        Integer[] mThumbIds;
        String[] mThumbDes;
        int layout_resource;

        public ImageAdapter(Context c,int layout_resource, Integer[] imagenes, String[] texto) { //Constructor
            mContext = c;
            mThumbIds = imagenes;
            mThumbDes = texto;
            this.layout_resource = layout_resource;
        }

        public int getCount() {
            return mThumbIds.length; //Numero de banderas, modificar
        }

        public Object getItem(int position) { //No utilizado
            return null;
        }

        public long getItemId(int position) { //No utilizado
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View gridElement=null;
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //mostrar un layout xml de forma dinamica
            if (convertView == null) { //Nuevo es necesario crear
                gridElement = inflater.inflate(layout_resource, null);
                TextView textView = (TextView) gridElement.findViewById(R.id.grid_text);
                ImageView image = (ImageView)gridElement.findViewById(R.id.grid_image);
                textView.setText(mThumbDes[position]);
                image.setImageResource(mThumbIds[position]);
            } else { //Reciclado, ya creado
                gridElement = (View) convertView;
            }
            return gridElement;
        }




    }

}
