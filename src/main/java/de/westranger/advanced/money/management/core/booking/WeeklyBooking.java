package de.westranger.advanced.money.management.core.booking;

public final class WeeklyBooking extends Booking {

    private final int repetition;
    private final int dayOfWeek;

    public WeeklyBooking(final int repetition, final int dayOfWeek, final double value, final BookingType type, final DateRange range, final String description) {
        super(value, type, range, description);

        if (repetition < 1) {
            throw new IllegalArgumentException("repetition out of range: 1 <= " + repetition);
        }

        if (dayOfWeek < 1 || dayOfWeek > 7) {
            throw new IllegalArgumentException("day of week is out of range 1 <= x <= 7 but was " + dayOfWeek);
        }

        this.repetition = repetition;
        this.dayOfWeek = dayOfWeek;
    }

    public int getRepetition() {
        return repetition;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }
}
