package de.westranger.advanced.money.management.core.util;

import java.util.Calendar;
import java.util.Date;

public final class DateUtil {

    /**
     * @param dayOfMonth
     * @param month      use java.util.Calendar static variables to set the month
     * @param year
     * @return
     */
    public static Date createDate(final int dayOfMonth, final int month, final int year) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(0l));
        if (year <= 1900) {
            throw new IllegalArgumentException("the year " + year + " was before 1900, this is not accepted!");
        } else {
            cal.set(Calendar.YEAR, year);
        }

        if (month < 0 || month > cal.getActualMaximum(Calendar.MONTH)) {
            throw new IllegalArgumentException(
                    "the month is out of range 0 <= " + month + " <= " + cal.getActualMaximum(Calendar.MONTH));
        } else {
            cal.set(Calendar.MONTH, month);
        }

        if (dayOfMonth < 1 || dayOfMonth > cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            throw new IllegalArgumentException(
                    "the day is out of range 0 <= " + month + " <= " + cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        } else {
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        }

        return cal.getTime();
    }

    public static boolean equals(final Date dateA, final Date dateB) {
        if (dateA == null) {
            throw new IllegalArgumentException("first method parameter is null");
        }
        if (dateB == null) {
            throw new IllegalArgumentException("second method parameter is null");
        }
        if (dateA == dateB) {
            return true;
        }

        final Calendar cal = Calendar.getInstance();
        cal.setTime(dateA);
        final int dayA = cal.get(Calendar.DAY_OF_MONTH);
        final int monthA = cal.get(Calendar.MONTH);
        final int yearA = cal.get(Calendar.YEAR);

        cal.setTime(dateB);
        final int dayB = cal.get(Calendar.DAY_OF_MONTH);
        final int monthB = cal.get(Calendar.MONTH);
        final int yearB = cal.get(Calendar.YEAR);

        if (dayA != dayB) {
            return false;
        } else if (monthA != monthB) {
            return false;
        } else return yearA == yearB;
    }

    public static int compare(final Date arg0, final Date arg1) {
        return normalize(arg0).compareTo(normalize(arg1));
    }

    public static Date normalize(final Date date) {
        if(date == null){
            throw new IllegalArgumentException("parameter is null");
        }

        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return new Date(cal.getTimeInMillis());
    }
}
