package de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.enums.BookingType;
import de.westranger.advanced.money.management.core.booking.util.DateExclusion;
import de.westranger.advanced.money.management.core.booking.util.DateRange;

import java.util.List;

public class MonthlyBooking extends Booking {

    private final int dayOfMonth;

    public MonthlyBooking(final int dayOfMonth, final double value, final BookingType type, final DateRange range, final String description, final DateExclusion dateExclusion) {
        super(value, type, range, description, dateExclusion);

        if (dayOfMonth < 1 || dayOfMonth > 28) {
            throw new IllegalArgumentException("day of month out of range 1 <= x <= 28 but was " + dayOfMonth);
        }

        this.dayOfMonth = dayOfMonth;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    @Override
    public List<InflatedBooking> inflate() {
        throw new RuntimeException("Not yet Implemented");
    }
}
