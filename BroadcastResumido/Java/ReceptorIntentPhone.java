package samsung.tech;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
//import android.telephony.TelephonyManager;
import android.util.Log;

/***************
 * BroadCast filtrado en el manifiesto
 * @author monte
 *
 */
public class ReceptorIntentPhone extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
        
		BroadcastReceiversActivity mainActivity = ((BroadCastApplication) context.getApplicationContext()).mainActivity;
		String datos= context.getString(R.string.Llamada);
        
		
		Log.i("DEBUG",intent.toString());
		
		Bundle extras = intent.getExtras();
		
		if (extras != null) {
			
			String state = extras.getString(TelephonyManager.EXTRA_STATE);
			if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
				String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
				
				mainActivity.infoLlamada.setText(datos+" "+phoneNumber);
				
				for (String key : extras.keySet())
				    {
				    	Log.i("DEBUG",key);
				    	Log.i("DEBUG"," => ");
				    	Log.i("DEBUG",extras.get(key).toString());
				    }
					
			}	
	
		}
	 
	}
	
}
