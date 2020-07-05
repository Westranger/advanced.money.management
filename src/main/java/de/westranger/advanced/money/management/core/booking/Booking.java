package de.westranger.advanced.money.management.core.booking;

public abstract class Booking {
    protected final int repetition;
    protected final double value;
    protected final BookingType type;
    protected final DateRange dateRange;
    protected final String description;

    public Booking(final int repetition, final double value, final BookingType type, final DateRange range, final String description, final DateExclusion dateExclusion) {
        if (repetition < 1) {
            throw new IllegalArgumentException("repetition out of range: 1 <= " + repetition);
        }

        if (type == null) {
            throw new IllegalArgumentException("booking type is null");
        }

        if (range == null) {
            throw new IllegalArgumentException("DateRange for booking is is null");
        }

        if (description == null) {
            throw new IllegalArgumentException("booking description is null");
        }

        if (!Double.isFinite(value) || Double.isNaN(value)) {
            throw new IllegalArgumentException("Booking value is " + value);
        }

        if (dateExclusion == null) {
            throw new IllegalArgumentException("Booking DateExclusion is null");
        }

        this.repetition = repetition;
        this.value = value;
        this.type = type;
        this.dateRange = range;
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public BookingType getType() {
        return type;
    }

    public DateRange getDateRange() {
        return dateRange;
    }

    public String getDescription() {
        return description;
    }

    public DateExclusion getDateExclusion() {
        return dateExclusion;
    }

    public int getRepetition() {
        return repetition;
    }
}
