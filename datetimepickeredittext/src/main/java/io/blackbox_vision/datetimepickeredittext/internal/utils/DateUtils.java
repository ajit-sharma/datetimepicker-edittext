package io.blackbox_vision.datetimepickeredittext.internal.utils;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public final class DateUtils {
    private static final String LOG_TAG = DateUtils.class.getSimpleName();

    private static final String DATE_TEMPLATE = "dd/MM/yyyy";
    private static final String TIME_TEMPLATE = "HH:mm";

    private DateUtils() { }

    private static String format(@NonNull final Date date, @NonNull final String template) {
        return new SimpleDateFormat(template, Locale.getDefault()).format(date);
    }

    public static String toDate(@NonNull final Date date, @Nullable final String template) {
        return format(date, null != template ? template : DATE_TEMPLATE);
    }

    public static String toTime(@NonNull final Date date, @Nullable final String template) {
        return format(date, null != template ? template : TIME_TEMPLATE);
    }

    public static Date parse(@Nullable final String dateString, @Nullable final String template) {
        final SimpleDateFormat sdf = new SimpleDateFormat(null != template ? template : DATE_TEMPLATE, Locale.getDefault());
        Date date = null;

        try {
            date = sdf.parse(dateString);
        } catch (ParseException ex) {
            Log.e(LOG_TAG, ex.getMessage(), ex.getCause());
        }

        return date;
    }
}
