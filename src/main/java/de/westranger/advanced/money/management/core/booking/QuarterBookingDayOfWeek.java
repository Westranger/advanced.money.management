package de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.enums.DayOfWeek;
import de.westranger.advanced.money.management.core.booking.enums.MonthOfQuarter;
import de.westranger.advanced.money.management.core.booking.enums.Numerator;
import de.westranger.advanced.money.management.core.booking.enums.BookingType;
import de.westranger.advanced.money.management.core.booking.util.DateExclusion;
import de.westranger.advanced.money.management.core.booking.util.DateRange;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class QuarterBookingDayOfWeek extends MonthlyBookingDayOfWeek {

    private final MonthOfQuarter moq;

    public QuarterBookingDayOfWeek(final MonthOfQuarter moq, final Numerator num, final DayOfWeek dow, final double value, final BookingType type, final DateRange range, final String description, final DateExclusion dateExclusion) {
        super(num, dow, value, type, range, description, dateExclusion);

        if (moq == null) {
            throw new IllegalArgumentException("Booking MonthOfQuarter is null");
        }

        final Set<MonthOfQuarter> acceptedMonths = new HashSet<>(Arrays.asList(MonthOfQuarter.First, MonthOfQuarter.Second, MonthOfQuarter.Third, MonthOfQuarter.Fourth));
        if (!acceptedMonths.contains(moq)) {
            throw new IllegalArgumentException("unknown month of quarter " + moq);
        }

        this.moq = moq;
    }

    public MonthOfQuarter getMonthOfQuarter() {
        return moq;
    }

    @Override
    public List<InflatedBooking> inflate() {
        throw new RuntimeException("Not yet Implemented");
    }
}
