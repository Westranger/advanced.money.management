package de.westranger.advanced.money.management.core.booking;

public class MonthlyBooking extends Booking {

    private final int dayOfMonth;
    private final int repetition;

    public MonthlyBooking(final int repetition, final int dayOfMonth, final double value, final BookingType type, final DateRange range, final String description, final DateExclusion dateExclusion) {
        super(repetition, value, type, range, description, dateExclusion);

        if (repetition < 1) {
            throw new IllegalArgumentException("repetition out of range: 1 <= " + repetition);
        }

        if (dayOfMonth < 1 || dayOfMonth > 28) {
            throw new IllegalArgumentException("day of month out of range 1 <= x <= 28 but was " + dayOfMonth);
        }

        this.dayOfMonth = dayOfMonth;
        this.repetition = repetition;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getRepetition() {
        return repetition;
    }
}
