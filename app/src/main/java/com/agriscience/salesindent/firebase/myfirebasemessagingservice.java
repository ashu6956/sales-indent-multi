package com.agriscience.salesindent.firebase;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.agriscience.salesindent.AppSharedPreferences;
import com.agriscience.salesindent.LoginActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import com.agriscience.salesindent.R;


public class myfirebasemessagingservice extends FirebaseMessagingService {
    private NotificationManager notifManager;
    Intent intent;
    AppSharedPreferences sessionManager;
    int notify_id;


    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        Log.e("NEW_TOKEN",s);
        SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences(getString(R.string.FCM_PRE), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(getString(R.string.FCM_TOKEN),s);
        editor.apply();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        sessionManager = new AppSharedPreferences(this);
        Log.e("firebase",remoteMessage.getNotification().getBody());
        String title = remoteMessage.getNotification().getTitle();
        String message = remoteMessage.getNotification().getBody();

        Log.d("Stringggggggg","----------notification-----tit-----"+title);
        Log.d("Stringggggggg","----------notification-----msg----"+message);
//        showNotification(message);
      //  notification11(title,message);
        createNotification(message,this,title);
////        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
////        int icon = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? R.mipmap.saleslogos: R.drawable.saleslogo;
//
//       /* db = openOrCreateDatabase("NIPM_db", Context.MODE_PRIVATE, null);
//        try {
//            Cursor c1 = db.rawQuery("SELECT * FROM user_id", null);
//            if (c1.moveToFirst()) {
//                user_id = c1.getString(0);
//                intent = new Intent(this, Events.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra("dash", "5");
//            } else {
//                intent = new Intent(this, Admin_dash.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            }
//        } catch (Exception e) {
//            e.getStackTrace();
//            intent = new Intent(this, Admin_dash.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        }
//        db.close();*/

        if (sessionManager.get_notify_count()== 0){
//            notification(message ,title);
//            notification11(title,message);

            createNotification(message,this,title);
        }else {
//            notification1(message ,title);
//            notification11(title,message);

            createNotification(message,this,title);
        }


    }

    private void notification(String message ,String title) {

        sessionManager.put_notify_data(title+": "+message);
        sessionManager.put_notify_count(1);
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//        stackBuilder.addParentStack(MainActivity.class);
//        stackBuilder.addNextIntent(intent);
//        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent del_intent = PendingIntent.getBroadcast(this, 0, new Intent(this, NotificationDeleteReceiver.class), 0);
        Notification notification = new Notification.Builder(this)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.saleslogo)
                .setTicker(title).setWhen(0)
                .setContentIntent(pendingIntent)
                   .setContentTitle(title)
//                    .setSmallIcon(icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.saleslogo))
                .setContentText(message)
                .setDeleteIntent(del_intent)
                .setLights(Color.BLUE, 3000, 3000)
                .setVibrate(new long[]{1000, 1000})
                .setSound(uri)
                .build();
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }

//    private void notification1(String message ,String title) {
//        notify_id++;
//        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//
//        intent = new Intent(this, LoginActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
////        stackBuilder.addParentStack(MainActivity.class);
////        stackBuilder.addNextIntent(intent);
////        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        PendingIntent del_intent = PendingIntent.getBroadcast(this, 0, new Intent(this, NotificationDeleteReceiver.class), 0);
//        Notification notification = new Notification.Builder(this)
//                .setAutoCancel(true)
//                .setSmallIcon(R.mipmap.saleslogos)
//                .setTicker(title).setWhen(0)
//                .setContentIntent(pendingIntent)
//                .setContentTitle(title)
////                    .setSmallIcon(icon)
//                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.saleslogos))
//                .setContentText(message)
//                .setDeleteIntent(del_intent)
//                .setLights(Color.BLUE, 3000, 3000)
//                .setVibrate(new long[]{1000, 1000})
//                .setSound(uri)
//                .build();
//        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(notify_id, notification);
//
//
//
////        NotificationCompat.Builder mBuilder = new  NotificationCompat.Builder(getApplicationContext());
////        mBuilder.setSmallIcon(R.drawable.saleslogo);
////        mBuilder.setContentTitle("Sales Indent");
////        mBuilder.setContentText(new String(message.getPayload()));
////        mBuilder.setAutoCancel(true);
////        mBuilder.mNumber = 1;//get your number of notification from where you have save notification
////
////        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
////        mNotifyMgr.notify(notify_id, mBuilder.build());
//
//
//    }
//    public void showNotification(String message) {
//        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, NotificationDeleteReceiver.class), 0);
//        Resources r = getResources();
//        Notification notification = new NotificationCompat.Builder(this)
//                .setTicker(r.getString(R.string.notification_title))
//                .setSmallIcon(android.R.drawable.ic_menu_report_image)
//                .setContentTitle(r.getString(R.string.notification_title))
//                .setContentText(message)
//                .setContentIntent(pi)
//                .setAutoCancel(true)
////                .setLights(Color.BLUE, 3000, 3000)
////                .setVibrate(new long[]{1000, 1000})
//                .build();
//
//        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        notificationManager.notify(0, notification);
//    }
//
//
//    private  void notification11(String title,String msg)
//    {
//        notify_id++;
//        NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//        Notification notify=new Notification.Builder
//                (getApplicationContext()).setContentTitle("Sales Intent").setContentText(msg).
//                setContentTitle(title).setSmallIcon(R.mipmap.saleslogos).build();
//
//        notify.flags |= Notification.FLAG_AUTO_CANCEL;
//        notif.notify(notify_id, notify);
//
//
//
//    }

    public void createNotification(String aMessage, Context context,String title) {

       notify_id++; // ID of notification
        String id = ""; // default_channel_id
//         title = "Sales Intent"; // Default Channel
        Intent intent;
        PendingIntent pendingIntent;
        NotificationCompat.Builder builder;
        if (notifManager == null) {
            notifManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = notifManager.getNotificationChannel(id);
            if (mChannel == null) {
                mChannel = new NotificationChannel(id, title, importance);
                mChannel.enableVibration(true);
                mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                notifManager.createNotificationChannel(mChannel);
            }
            builder = new NotificationCompat.Builder(context, id);
            intent = new Intent(context, NotificationDeleteReceiver.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            builder.setContentTitle(aMessage)                            // required
                    .setSmallIcon(R.mipmap.saleslogos)   // required
                    .setContentText(title) // required
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setTicker(aMessage)
                    .setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        }
        else {
            builder = new NotificationCompat.Builder(context, id);
            intent = new Intent(context, NotificationDeleteReceiver.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            builder.setContentTitle(aMessage)                            // required
                    .setSmallIcon(R.mipmap.saleslogos)   // required
                    .setContentText(title) // required
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setTicker(aMessage)
                    .setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400})
                    .setPriority(Notification.PRIORITY_HIGH);
        }
        Notification notification = builder.build();
        notifManager.notify(notify_id, notification);
    }
}
