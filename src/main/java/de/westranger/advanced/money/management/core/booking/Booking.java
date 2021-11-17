package de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.enums.BookingType;
import de.westranger.advanced.money.management.core.booking.util.DateExclusion;
import de.westranger.advanced.money.management.core.booking.util.DateRange;
import de.westranger.advanced.money.management.core.booking.util.Triple;

import java.util.Date;
import java.util.List;

public abstract class Booking {
    protected final double value;
    protected final BookingType type;
    protected final DateRange dateRange;
    protected final String description;
    protected DateExclusion dateExclusion;

    public Booking(final double value, final BookingType type, final DateRange range, final String description) {
        if (type == null) {
            throw new IllegalArgumentException("Booking type is null");
        }

        if (range == null) {
            throw new IllegalArgumentException("DateRange for Booking is is null");
        }

        if (description == null) {
            throw new IllegalArgumentException("Booking description is null");
        }

        if (!Double.isFinite(value) || Double.isNaN(value)) {
            throw new IllegalArgumentException("Booking value is " + value);
        }

        this.value = value;
        this.type = type;
        this.dateRange = range;
        this.description = description;
    }

    public Booking(final double value, final BookingType type, final DateRange range, final String description, final DateExclusion dateExclusion) {
        this(value,type,range,description);

        if (dateExclusion == null) {
            throw new IllegalArgumentException("Booking DateExclusion is null");
        }

        this.dateExclusion = dateExclusion;
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

    public abstract List<Triple<Date, BookingType, Double>> inflate();
}
