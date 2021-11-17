package de.westranger.advanced.money.management.core.util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public final class DateComparator implements Comparator<Date>, Serializable {

    @Override
    public int compare(final Date arg0, final Date arg1) {
        return normalize(arg0).compareTo(normalize(arg1));
    }

    private Date normalize(final Date date) {
        if (date == null) {
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
