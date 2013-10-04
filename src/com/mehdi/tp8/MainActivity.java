package com.mehdi.tp8;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private NotificationManager notificationmanager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(this);
        notificationmanager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Notification notification = new Notification(R.drawable.ic_launcher,"mon application", System.currentTimeMillis());
		Intent intentnotification = new Intent(Intent.ACTION_VIEW, Uri.parse("tel: 222 333344"));
		PendingIntent pendingintent = PendingIntent.getActivity(this, 0, intentnotification, 0);
		notification.setLatestEventInfo(this, "Ma notification", "Detail notification: passer un appel", pendingintent);
		notificationmanager.notify(1, notification);
		
	}
    
}
