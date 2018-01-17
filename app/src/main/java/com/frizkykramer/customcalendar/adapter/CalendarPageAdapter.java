package com.frizkykramer.customcalendar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class CalendarPageAdapter extends FragmentStatePagerAdapter {

    public static int LOOPS_COUNT = 1000;
    private ArrayList<String> mProducts;


    public CalendarPageAdapter(FragmentManager manager, ArrayList<String> products)
    {
        super(manager);
        mProducts = products;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    //    @Override
//    public Fragment getItem(int position)
//    {
//        if (mProducts != null && mProducts.size() > 0)
//        {
//            position = position % mProducts.size(); // use modulo for infinite cycling
//            return MyFragment.newInstance(mProducts.get(position));
//        }
//        else
//        {
//            return MyFragment.newInstance(null);
//        }
//    }


    @Override
    public int getCount()
    {
        if (mProducts != null && mProducts.size() > 0)
        {
            return mProducts.size()*LOOPS_COUNT; // simulate infinite by big number of products
        }
        else
        {
            return 1;
        }
    }
}