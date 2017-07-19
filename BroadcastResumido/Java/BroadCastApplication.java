package samsung.tech;

import android.app.Application;

/****
 * Necesaria para que los BroadCast accedan al UI, declarada en el Maninifiesto
 * @author monte
 *
 */
public class BroadCastApplication extends Application {

	public void onCreate() {
        super.onCreate();
    }
     
	BroadcastReceiversActivity mainActivity;
	
}
