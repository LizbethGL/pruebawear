package com.example.pruebawear;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.pruebawear.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    private Button wBotton = null;
    private Button wBoton;

    private TextView mTextView;
    private ActivityMainBinding binding;
    private Intent intent;
    private PendingIntent pendingIntent;

    private NotificationCompat.Builder notofication;
    private NotificationManagerCompat nm;
    private NotificationCompat.WearableExtender wearableExtender;

    String idChanel = "Mi_Canal";
    String idChannel = "Mi_Canal";
    int idNotification = 001;

    private NotificationCompat.BigTextStyle bigTextStyle;



    String longText = "with BigStyle, only a single line of text would be visible" +
            "Any additional text would not appear directly in the notification";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        wBoton = findViewById(R.id.wButton);
        wBotton = findViewById(R.id.wButton);

        intent = new Intent(MainActivity.this, MainActivity.class);

        nm = NotificationManagerCompat.from(MainActivity.this);

        wearableExtender = new NotificationCompat.WearableExtender();
        bigTextStyle = new NotificationCompat.BigTextStyle();


        wBotton.setOnClickListener(new View.OnClickListener() {

                public void start(View view){
                Timer t = new Timer();
                TimerTask tt = new TimerTask() {
                    @Override
                    public void run() {
                        int importance = NotificationManager.IMPORTANCE_HIGH;
                        String name = "Notification 2";
                        NotificationChannel notificationChannel = new NotificationChannel(idChannel, name, importance);

                        nm.createNotificationChannel(notificationChannel);

                        pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

                        notofication = new NotificationCompat.Builder(MainActivity.this, idChannel)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle("Mi notification")
                                .setContentText("Mi segunda notificacion wear")
                                .extend(wearableExtender);
                        nm.notify(idNotification, notofication.build());
                    }
                };

                t.schedule(tt, 5000);

            }

                @Override
                public void onClick (View view){
                start(view);
                int importance = NotificationManager.IMPORTANCE_HIGH;
                String name = "Notificacion";

                NotificationChannel notificationChannel =
                        new NotificationChannel(idChanel, name, importance);
                String name1 = "Notification";
                NotificationChannel notificationChannel1 = new NotificationChannel(idChannel, name, importance);

                nm.createNotificationChannel(notificationChannel);

                pendingIntent = pendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

                /*notification = new NotificationCompat.Builder(MainActivity.this, idChanel)
                notification = new NotificationCompat.Builder(MainActivity.this, idChannel)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Notificacion Wear")
                        .setContentText(longText)
                        .setContentIntent(pendingIntent)
                        .extend(wearableExtender)
                        .setVibrate(new long[]{100,200,300,400,500,300,200,400})
                        .setStyle(bigTextStyle);
                nm.notify(idNotification, notification.build());*/

                notofication = new NotificationCompat.Builder(MainActivity.this, idChanel)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Mi notificacion")
                        .setContentTitle("Mi notification")
                        .setContentText("Mi primera notificacion wear")
                        .extend(wearableExtender);
                nm.notify(idNotification, notofication.build());
            }
            });

        }
    }

