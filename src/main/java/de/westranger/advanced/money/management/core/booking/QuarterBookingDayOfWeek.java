package de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.enums.DayOfWeek;
import de.westranger.advanced.money.management.core.booking.enums.MonthOfQuarter;
import de.westranger.advanced.money.management.core.booking.enums.Numerator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class QuarterBookingDayOfWeek extends MonthlyBookingDayOfWeek {

    private final Set<MonthOfQuarter> acceptedMonths = new HashSet<>(Arrays.asList(MonthOfQuarter.First, MonthOfQuarter.Second, MonthOfQuarter.Third, MonthOfQuarter.Fourth));
    private final MonthOfQuarter moq;

    public QuarterBookingDayOfWeek(final MonthOfQuarter moq, final Numerator num, final DayOfWeek dow, final double value, final BookingType type, final DateRange range, final String description) {
        super(num, dow, value, type, range, description);

        if (!this.acceptedMonths.contains(moq)) {
            throw new IllegalArgumentException("unknown month of quarter " + moq);
        }

        this.moq = moq;
    }

    public MonthOfQuarter getMonthOfQuarter() {
        return moq;
    }
}
