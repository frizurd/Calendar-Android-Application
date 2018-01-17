package com.frizkykramer.customcalendar.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.frizkykramer.customcalendar.R;
import com.frizkykramer.customcalendar.service.CalendarService;
import com.frizkykramer.customcalendar.view.activity.DetailActivity;
import com.frizkykramer.customcalendar.view.activity.MainActivity;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarGridAdapter extends ArrayAdapter {

    private Context context;
    private List<Date> monthDates;
    private Calendar currentDate;
    private LayoutInflater inflater;

    public CalendarGridAdapter(Context context, List<Date> monthDates, Calendar currentDate) {
        super(context, R.layout.day_grid_layout);
        this.context = context;
        this.monthDates = monthDates;
        this.currentDate = currentDate;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        Date mDate = monthDates.get(position);
        final Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(mDate);

        final int dayValue = dateCal.get(Calendar.DAY_OF_MONTH),
                displayMonth = dateCal.get(Calendar.MONTH) + 1,
                displayYear = dateCal.get(Calendar.YEAR),
                currentMonth = currentDate.get(Calendar.MONTH) + 1,
                currentYear = currentDate.get(Calendar.YEAR);

        if(view == null){
            view = inflater.inflate(R.layout.day_grid_layout, parent, false);
        }

        TextView cellNumber = view.findViewById(R.id.calendar_date_id);

        if(displayMonth == currentMonth && displayYear == currentYear) {
            cellNumber.setTextColor(Color.parseColor("#000000"));
        } else{
            cellNumber.setTextColor(Color.parseColor("#b0b0b0"));
        }
        if(DateUtils.isToday(dateCal.getTimeInMillis())) {
            view.setBackgroundResource(R.drawable.red_circle);
            cellNumber.setTextColor(Color.parseColor("#FFFFFF"));
        }
        cellNumber.setText(String.valueOf(dayValue));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent serviceIntent= new Intent(context, CalendarService.class);
                serviceIntent.putExtra("chosenDay",     dayValue);
                serviceIntent.putExtra("chosenMonth",   displayMonth);
                serviceIntent.putExtra("chosenYear",    displayYear);

                context.startService(serviceIntent);
            }
        });

        return view;
    }

    @Override
    public int getCount() {
        return monthDates.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return monthDates.get(position);
    }

    @Override
    public int getPosition(@Nullable Object item) {
        return monthDates.indexOf(item);
    }
}
