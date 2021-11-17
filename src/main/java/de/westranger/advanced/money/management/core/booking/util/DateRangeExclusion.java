package de.westranger.advanced.money.management.core.booking.util;

public final class DateRangeExclusion extends DateExclusion {

    private final DateRange excludedRange;

    public DateRangeExclusion(final long startDate, final long endDate) {
        this.excludedRange = new DateRange(startDate, endDate);
    }

    @Override
    public boolean isExcluded(final long date) {
        return this.excludedRange.isBetween(date);
    }
}
