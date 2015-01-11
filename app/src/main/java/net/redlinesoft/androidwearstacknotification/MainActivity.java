package net.redlinesoft.androidwearstacknotification;

import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public final static String GROUP_KEY_EMAILS = "group_key_emails";
    String sender1 = "andrew.le";
    String sender2 = "anuchit.ch";
    
    public static int id=0;
    
    
    
    public void Notify(View view) {

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(),R.drawable.ic_large);
        
        Notification notification1 = new NotificationCompat.Builder(this)
                .setContentTitle("New Email from "+sender1)
                .setContentText("Emails from Andrew Lee")
                .setSmallIcon(R.drawable.ic_mail)
                .setLargeIcon(largeIcon)
                .setGroup(GROUP_KEY_EMAILS)
                .build();

        NotificationManagerCompat manager =  NotificationManagerCompat.from(this);
        manager.notify(getId(),notification1);

        Notification notification2 = new NotificationCompat.Builder(this)
                .setContentTitle("New Email from "+sender2)
                .setContentText("Emails from Anuchit")
                .setSmallIcon(R.drawable.ic_mail)
                .setLargeIcon(largeIcon)
                .setGroup(GROUP_KEY_EMAILS)
                .build();

        manager.notify(getId(),notification2);
        
    }


    public void summaryNotify(View view) {

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(),R.drawable.ic_large);
        
        Notification notification1 = new NotificationCompat.Builder(this)
                .setContentTitle("New Email from "+sender1)
                .setContentText("Emails from Andrew Lee")
                .setSmallIcon(R.drawable.ic_mail)
                .setLargeIcon(largeIcon)
                .setGroup(GROUP_KEY_EMAILS)
                .build();

        NotificationManagerCompat manager =  NotificationManagerCompat.from(this);
        
        manager.notify(getId(),notification1);

        
        Notification notification2 = new NotificationCompat.Builder(this)
                .setContentTitle("New Email from "+sender2)
                .setContentText("Emails from Anuchit")
                .setSmallIcon(R.drawable.ic_mail)
                .setLargeIcon(largeIcon)
                .setGroup(GROUP_KEY_EMAILS)
                .build();

        manager.notify(getId(),notification2);

        NotificationCompat.InboxStyle  inboxStyle = new NotificationCompat.InboxStyle()
                .addLine(sender1)
                .addLine(sender2)
                .setBigContentTitle(id + " new emails")
                .setSummaryText("info@redlinesoft.net");

        
        Notification summaryNotification = new NotificationCompat.Builder(this)
                .setContentTitle(id + " new emails")
                .setContentText("info@redlinesoft.net")
                .setSmallIcon(R.drawable.ic_mail)
                .setGroup(GROUP_KEY_EMAILS)
                .setGroupSummary(true)
                .setStyle(inboxStyle)
                .build();

        manager.notify(getId(),summaryNotification);
        id=0;

    }
    
    public int getId() {
        return ++id;
    }


}
