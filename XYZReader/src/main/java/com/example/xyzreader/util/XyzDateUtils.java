package com.example.xyzreader.util;

import android.content.Context;
import android.util.Log;

import com.example.xyzreader.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class XyzDateUtils {

    private static final String TAG = XyzDateUtils.class.getSimpleName();

    // Most time functions can only handle 1902 - 2037
    private static final GregorianCalendar START_OF_EPOCH = new GregorianCalendar(2,1,1);

    private static final SimpleDateFormat sourceDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss");

    private static SimpleDateFormat outputFormat;

    private XyzDateUtils(){}

    public static Date parseDate(String dateStr){
        try {
            return sourceDateFormat.parse(dateStr);
        } catch (ParseException ex) {
            Log.e(TAG, ex.getMessage());
            Log.i(TAG, "passing today's date");
            return new Date();
        }
    }

    public static String formatDate(Context context, Date date){
        if(outputFormat == null){
            outputFormat = new SimpleDateFormat(context.getString(R.string.date_format));
        }

        return outputFormat.format(date);
    }

    public static boolean isBeforeStartOfEpoch(Date date){
        return date.before(START_OF_EPOCH.getTime());
    }

}
