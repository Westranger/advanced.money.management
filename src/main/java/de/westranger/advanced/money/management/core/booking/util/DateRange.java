package de.westranger.advanced.money.management.core.booking.util;

import java.util.Date;

public final class DateRange {
    private final long startDate;
    private final long endDate;

    public DateRange(final long startDate, final long endDate) {
        if (startDate > endDate) {
            throw new IllegalArgumentException("startDate > endDate");
        }

        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getStartDate() {
        return startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public boolean isBetween(final long date) {
        return date >= this.startDate && date <= this.endDate;
    }

    @Override
    public String toString() {
        return "DateRange(from:" + (new Date(this.startDate)) + " to:" + (new Date(this.startDate)) + ")";
    }
}
