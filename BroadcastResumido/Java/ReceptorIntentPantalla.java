package samsung.tech;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/****
 * BroadCast filtrado en la activdad
 * @author monte
 *
 */
public class ReceptorIntentPantalla extends BroadcastReceiver {

	long timeIni=0;
	long timeFin=0;
	long pantallaEncendida=0;
	long pantallaApagada=0;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		BroadcastReceiversActivity mainActivity = ((BroadCastApplication) context.getApplicationContext()).mainActivity;
		
		
		String action = intent.getAction();
        Log.i("DEBUG", action);
        
        
     
        if(  action.equalsIgnoreCase(Intent.ACTION_SCREEN_OFF)) {
            timeFin=System.currentTimeMillis();
            
            Date timeFinDate = new Date(timeFin);
            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss dd:MM:yyyy",Locale.US);
           
            
            Log.i("DEBUG", "Pantalla apagada: "+    df.format(timeFinDate));
            
            if (timeIni!=0)       {
            	Log.i("DEBUG", "Tiempo pantalla encendida "+(timeFin-timeIni)+" millisegundos");
            	 mainActivity.infoPantallaActiva.setText("Tiempo pantalla encendida "+(timeFin-timeIni)+" millisegundos");
            	
            }
            else{
            	mainActivity.infoPantallaActiva.setText("");
            }
            String datos= context.getString(R.string.PantallaApagada);
            pantallaApagada++;
            mainActivity.infoPantallaApagada.setText(datos+" "+pantallaApagada);
            
         
        }
        
        else if(  action.equalsIgnoreCase(Intent.ACTION_SCREEN_ON))  {
        	
        	timeIni=System.currentTimeMillis();
            
            Date timeIniDate = new Date(timeIni);
            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss dd:MM:yyyy",Locale.US);
            
            
            Log.i("DEBUG", "Pantalla encencida: "+    df.format(timeIniDate));
            
            String datos= context.getString(R.string.PantallaEncendida);
            pantallaEncendida++;
            mainActivity.infoPantallaEncendida.setText(datos+" "+pantallaEncendida);
            
        }
	}
	
	
}
