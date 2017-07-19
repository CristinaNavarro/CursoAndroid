package samsung.tech;



import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.TextView;

public class BroadcastReceiversActivity extends Activity {
    /** Called when the activity is first created. */
	
	ReceptorIntentPantalla pantallaS;
	ReceptorConexiones Wifi;
	
	TextView infoLlamada;
	TextView infoPantallaEncendida;
	TextView infoPantallaApagada;
	TextView infoWifi;
	TextView infoPantallaActiva;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        pantallaS = new ReceptorIntentPantalla();
        Wifi = new ReceptorConexiones();
        infoLlamada = (TextView) findViewById(R.id.InfoLlamada);
        infoPantallaEncendida = (TextView) findViewById(R.id.InfoPantallaEncendida);
    	infoPantallaApagada = (TextView) findViewById(R.id.InfoPantallaApagada);
    	infoWifi = (TextView) findViewById(R.id.InfoLWifi);
    	infoPantallaActiva = (TextView) findViewById(R.id.InfoPantallaActiva);
    	
        // Estas lineas permiten al Broadcast acceder al UI
        BroadCastApplication myApplication = (BroadCastApplication) this.getApplicationContext();
        myApplication.mainActivity = this;
        
        
     
        final IntentFilter filtersRed = new IntentFilter();
        filtersRed.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(Wifi, filtersRed);
        
        final IntentFilter filters = new IntentFilter();
      
        filters.addAction(Intent.ACTION_SCREEN_ON);
        filters.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(pantallaS, filters);


		final IntentFilter filterAuricular = new IntentFilter();

		filterAuricular.addAction(Intent.ACTION_HEADSET_PLUG);
		registerReceiver(new ReceptorHeadphones(), filterAuricular);
     }
    
	
    protected void onPause() {
    	 super.onPause();

     }

    protected void onResume() {
    	 super.onResume();
     }
    
    protected void onStop() {
    	Log.i("DEBUG","onStop");
    	 super.onStop();
    	
     }
    
    protected void onStart() {
    
    	Log.i("DEBUG","onStart");
    	super.onStart();
     }
    
    protected void onRestart() {
        
    	Log.i("DEBUG","onRestart");
    	super.onRestart();
     }
    
    
  protected void onDestroy() {
        
    	Log.i("DEBUG","onDestroy");
    	super.onDestroy();
    	 unregisterReceiver(pantallaS);
      }
  
  /*******************************
   * 
   * @author monte
   *
   *Clase privada que puede acceder directamente al UI
   */
  private class ReceptorHeadphones extends BroadcastReceiver{
	  @Override
	  public void onReceive(Context context, Intent intent){
		  int state = intent.getIntExtra("state",-1);
		  String name = intent.getStringExtra("name");
		  int microphone = intent.getIntExtra("microphone",-1);

		  switch(state){
			  case 1:
				  Log.i("Auricular","Auricular enchufado");
				  break;
			  case 0:
				  Log.i("Auricular","Auricular desenchufado");
				  break;
			  default:
				  Log.i("Auricular","Estado desconocido");
				  break;
		  }

		  switch(microphone){
			  case 1:
				  Log.i("Auricular","Auricular con microfono");
				  break;
			  case 0:
				  Log.i("Auricular","Auricular sin microfono");
				  break;
			  default:
				  Log.i("Auricular","Estado desconocido");
				  break;
		  }
	  }
  }
  
  private class ReceptorConexiones extends BroadcastReceiver {

//WIFI STATUS 
	  
		@SuppressWarnings("deprecation")
		@Override
		public void onReceive(Context context, Intent intent) {
			
			String action = intent.getAction();
	        Log.i("DEBUG", action);
	        String datos= context.getString(R.string.Wifi);
	       
	    			ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
					NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		
					if (mWifi.isConnected()) {
						
						SupplicantState supState; 
						WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
						WifiInfo wifiInfo = wifiManager.getConnectionInfo();
						supState = wifiInfo.getSupplicantState();
						
						switch (supState) {
							case COMPLETED: 
								String ssid = wifiInfo.getSSID();
				             	int ip= wifiInfo.getIpAddress();
				             	 String ipS=   Formatter.formatIpAddress(ip);
		 			             infoWifi.setText(datos+" Conectada ssid:"+ssid+" ip: "+ipS);
							break;
							default: 
								infoWifi.setText(datos+" Encendida, no conectada.");
						}
					}
					else {
						
						 infoWifi.setText(datos+" Apagada ");
						
					}

	
	   }


  }
}