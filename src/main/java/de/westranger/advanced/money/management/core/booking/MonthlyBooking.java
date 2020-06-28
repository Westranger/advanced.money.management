package de.westranger.advanced.money.management.core.booking;

public class MonthlyBooking extends Booking {

    private final int dayOfMonth;

    public MonthlyBooking(final int dayOfMonth, final double value, final BookingType type, final DateRange range, final String description) {
        super(value, type, range, description);

        if (dayOfMonth < 1 || dayOfMonth > 28) {
            throw new IllegalArgumentException("day of month out of range 1 <= x <= 28 but was " + dayOfMonth);
        }

        this.dayOfMonth = dayOfMonth;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }
}
