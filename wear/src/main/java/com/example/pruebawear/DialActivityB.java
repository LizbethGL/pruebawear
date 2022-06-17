package com.example.pruebawear;

import static com.example.pruebawear.MainActivity.idNotification;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pruebawear.databinding.ActivityDialBBinding;
import com.example.pruebawear.databinding.ActivityMainBinding;


public class DialActivityB extends Activity {

    private TextView mTextView;
    private ActivityDialBBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDialBBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;

        NotificationManager notifMan = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notifMan.cancel(idNotification);
    }
}