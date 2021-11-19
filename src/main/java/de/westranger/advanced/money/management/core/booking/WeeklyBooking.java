package de.westranger.advanced.money.management.core.booking;


import de.westranger.advanced.money.management.core.booking.enums.BookingType;
import de.westranger.advanced.money.management.core.booking.util.DateExclusion;
import de.westranger.advanced.money.management.core.booking.util.DateRange;

import java.util.List;

public final class WeeklyBooking extends Booking {

    private final int dayOfWeek;

    public WeeklyBooking(final int dayOfWeek, final double value, final BookingType type, final DateRange range, final String description, final DateExclusion dateExclusion) {
        super(value, type, range, description, dateExclusion);

        if (dayOfWeek < 1 || dayOfWeek > 7) {
            throw new IllegalArgumentException("day of week is out of range 1 <= x <= 7 but was " + dayOfWeek);
        }

        this.dayOfWeek = dayOfWeek;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public List<InflatedBooking> inflate() {
        throw new RuntimeException("Not yet Implemented");
    }
}
