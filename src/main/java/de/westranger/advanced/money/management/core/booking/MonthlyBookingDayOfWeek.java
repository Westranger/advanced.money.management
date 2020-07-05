package de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.enums.DayOfWeek;
import de.westranger.advanced.money.management.core.booking.enums.Numerator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MonthlyBookingDayOfWeek extends Booking {

    private final Set<Numerator> acceptedValues = new HashSet<>(Arrays.asList(Numerator.Every, Numerator.First, Numerator.Second, Numerator.Third, Numerator.Fourth, Numerator.Last, Numerator.SecondLast, Numerator.ThirdLast, Numerator.FourthLast));
    private final Set<DayOfWeek> acceptedWeekdays = new HashSet<>(Arrays.asList(DayOfWeek.Monday, DayOfWeek.Tuesday, DayOfWeek.Wednesday, DayOfWeek.Thursday, DayOfWeek.Friday, DayOfWeek.Saturday, DayOfWeek.Sunday));
    private final Numerator num;
    private final DayOfWeek dow;

    public MonthlyBookingDayOfWeek(final Numerator num, final DayOfWeek dow, final double value, final BookingType type, final DateRange range, final String description, final DateExclusion dateExclusion) {
        super(1, value, type, range, description, dateExclusion);

        if (!this.acceptedValues.contains(num)) {
            throw new IllegalArgumentException("unknown numerator " + num);
        }

        if (!this.acceptedWeekdays.contains(dow)) {
            throw new IllegalArgumentException("unknown  day of week " + dow);
        }

        this.num = num;
        this.dow = dow;
    }

    public Numerator getNumerator() {
        return num;
    }

    public DayOfWeek getDayOfWeek() {
        return dow;
    }
}
