package com.frizkykramer.customcalendar.model;

import com.frizkykramer.customcalendar.R;

public enum CustomPageEnum {

    RED(R.string.calendar_view, R.layout.calendar_layout);

    private int mTitleResId;
    private int mLayoutResId;

    CustomPageEnum(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}