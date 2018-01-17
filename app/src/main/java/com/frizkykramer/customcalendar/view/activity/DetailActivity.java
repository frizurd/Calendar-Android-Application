package com.frizkykramer.customcalendar.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.frizkykramer.customcalendar.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.detailAct_year)      TextView yearTV;
    @BindView(R.id.detailAct_dayMonth)  TextView dayMonthTV;
    @BindView(R.id.detailAct_dayFull)   TextView dayFullTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            yearTV.setText(extras.get("chosenYear").toString());
            try {
                dayMonthTV.setText(formatMonth(extras.get("chosenMonth").toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            dayFullTV.setText(extras.get("chosenDay").toString());
        }
    }

    public String formatMonth(String month) throws ParseException {
        SimpleDateFormat monthParse = new SimpleDateFormat("MM");
        SimpleDateFormat monthDisplay = new SimpleDateFormat("MMMM");
        return monthDisplay.format(monthParse.parse(month));
    }
}
