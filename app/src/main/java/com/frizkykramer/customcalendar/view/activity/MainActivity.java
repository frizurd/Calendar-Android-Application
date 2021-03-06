package com.frizkykramer.customcalendar.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.frizkykramer.customcalendar.R;
import com.frizkykramer.customcalendar.lib.customview.CalendarView;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_calendar)
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
