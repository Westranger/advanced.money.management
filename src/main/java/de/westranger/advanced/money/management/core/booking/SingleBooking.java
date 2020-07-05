package de.westranger.advanced.money.management.core.booking;

import java.util.Date;

public final class SingleBooking extends Booking {
    private final long date;

    public SingleBooking(final int repetitionEveryXDays, final long date, final double value, final BookingType type, final DateRange range, final String description, final DateExclusion dateExclusion) {
        super(repetitionEveryXDays, value, type, range, description, dateExclusion);

        if (!range.isBetween(date)) {
            throw new IllegalArgumentException("the date " + (new Date(date)) + " is not within the date range" + getDateRange());
        }

        this.date = date;
    }

    public long getDate() {
        return date;
    }
}