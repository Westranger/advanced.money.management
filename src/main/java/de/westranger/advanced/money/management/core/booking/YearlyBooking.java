package de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.enums.MonthOfYear;
import de.westranger.advanced.money.management.core.booking.enums.BookingType;
import de.westranger.advanced.money.management.core.booking.util.DateExclusion;
import de.westranger.advanced.money.management.core.booking.util.DateRange;
import de.westranger.advanced.money.management.core.booking.util.Triple;

import java.util.Date;
import java.util.List;

public final class YearlyBooking extends Booking {

    private final int dayOfMonth;
    private final MonthOfYear moy;

    public YearlyBooking(final MonthOfYear moy, final int dayOfMonth, final double value, final BookingType type, final DateRange range, final String description, final DateExclusion dateExclusion) {
        super(value, type, range, description, dateExclusion);

        if (moy == null) {
            throw new IllegalArgumentException("Booking MonthOfYear is null");
        }

        if (dayOfMonth < 1 || dayOfMonth > 28) {
            throw new IllegalArgumentException("day of month out of range 1 <= x <= 28 but was " + dayOfMonth);
        }

        this.dayOfMonth = dayOfMonth;
        this.moy = moy;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public MonthOfYear getMonthOfYear() {
        return moy;
    }

    @Override
    public List<Triple<Date, BookingType, Double>> inflate() {
        throw new RuntimeException("Not yet Implemented");
    }
}
