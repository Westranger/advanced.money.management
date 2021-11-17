package de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.enums.MonthOfQuarter;
import de.westranger.advanced.money.management.core.booking.enums.BookingType;
import de.westranger.advanced.money.management.core.booking.util.DateExclusion;
import de.westranger.advanced.money.management.core.booking.util.DateRange;
import de.westranger.advanced.money.management.core.booking.util.Triple;

import java.util.*;

public final class QuarterBooking extends MonthlyBooking {

    private final Set<MonthOfQuarter> acceptedMonths = new HashSet<>(Arrays.asList(MonthOfQuarter.First, MonthOfQuarter.Second, MonthOfQuarter.Third, MonthOfQuarter.Fourth));
    private final MonthOfQuarter moq;

    public QuarterBooking(final MonthOfQuarter moq, final int dayOfMonth, final double value, final BookingType type, final DateRange range, final String description, final DateExclusion dateExclusion) {
        super(dayOfMonth, value, type, range, description, dateExclusion);

        if (!this.acceptedMonths.contains(moq)) {
            throw new IllegalArgumentException("unknown  month of quarter " + moq);
        }

        this.moq = moq;
    }

    public MonthOfQuarter getMonthOfQuarter() {
        return moq;
    }

    @Override
    public List<Triple<Date, BookingType, Double>> inflate() {
        throw new RuntimeException("Not yet Implemented");
    }
}
