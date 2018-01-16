package com.frizkykramer.customcalendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twinkle94.monthyearpicker.picker.YearMonthPickerDialog;

import net.danlew.android.joda.JodaTimeAndroid;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalendarView extends LinearLayout {

    @BindView(R.id.mainAct_year)            TextView currentYear;
    @BindView(R.id.mainAct_month)           TextView currentMonth;
    @BindView(R.id.calendar_grid)           GridView calendarGrid;

    private Calendar calendar;
    private CalendarGridAdapter calAdapter;
    private Context context;
    private YearMonthPickerDialog yearMonthPickerDialog;

    public CalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_calendar, this);
        ButterKnife.bind(this, view);

        JodaTimeAndroid.init(context);

        calendar =  Calendar.getInstance(Locale.ENGLISH);
        initiateCalendar();
        createMonthPickerDialog();
    }

    private void initiateCalendar(){
        List<Date> dayValueInCells = new ArrayList<>();
        Calendar mCal = (Calendar)calendar.clone();
        mCal.set(Calendar.DAY_OF_MONTH, 2);
        int firstDayOfTheMonth = mCal.get(Calendar.DAY_OF_WEEK) - 2;
        mCal.add(Calendar.DAY_OF_MONTH, -firstDayOfTheMonth);
        while(dayValueInCells.size() < 42){
            dayValueInCells.add(mCal.getTime());
            mCal.add(Calendar.DAY_OF_MONTH, 1);
        }

        currentYear.setText(String.valueOf(calendar.get(Calendar.YEAR)));
        currentMonth.setText(new SimpleDateFormat("MMMM").format(calendar.getTime()));

        calAdapter = new CalendarGridAdapter(context, dayValueInCells, calendar);
        calendarGrid.setAdapter(calAdapter);
    }

    private void createMonthPickerDialog() {

        yearMonthPickerDialog = new YearMonthPickerDialog(context, new YearMonthPickerDialog.OnDateSetListener() {
            @Override
            public void onYearMonthSet(int year, int month) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);

                initiateCalendar();
            }
        }, R.style.MyDialogTheme, R.color.colorPrimary);
    }

    @OnClick(R.id.mainAct_MonthYear)
    public void callMonthPickerDialog() {
        yearMonthPickerDialog.show();
    }
}
