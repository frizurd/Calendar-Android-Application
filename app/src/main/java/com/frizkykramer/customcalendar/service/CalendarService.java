package com.frizkykramer.customcalendar.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.frizkykramer.customcalendar.view.activity.DetailActivity;

import java.util.Calendar;

public class CalendarService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtras(intent);
        detailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(detailIntent);

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
