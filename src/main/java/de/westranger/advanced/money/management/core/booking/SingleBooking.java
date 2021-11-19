package de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.enums.BookingType;
import de.westranger.advanced.money.management.core.booking.util.DateExclusion;
import de.westranger.advanced.money.management.core.booking.util.DateRange;

import java.util.Date;
import java.util.List;

public final class SingleBooking extends Booking {
    private final long date;
    private final int repetitionEveryXDays;

    public SingleBooking(final int repetitionEveryXDays, final long date, final double value, final BookingType type, final DateRange range, final String description, final DateExclusion dateExclusion) {
        super(value, type, range, description, dateExclusion);

        if (!range.isBetween(date)) {
            throw new IllegalArgumentException("the date " + (new Date(date)) + " is not within the date range" + getDateRange());
        }

        if (repetitionEveryXDays < 1) {
            throw new IllegalArgumentException("repetition out of range: 1 <= " + repetitionEveryXDays);
        }

        this.date = date;
        this.repetitionEveryXDays = repetitionEveryXDays;
    }

    public long getDate() {
        return date;
    }

    public int getRepetitionEveryXDays() {
        return repetitionEveryXDays;
    }

    @Override
    public List<InflatedBooking> inflate() {
        throw new RuntimeException("Not yet Implemented");
    }
}