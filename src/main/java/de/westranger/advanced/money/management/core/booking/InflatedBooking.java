package de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.enums.BookingType;

public final class InflatedBooking {
    final long date;
    final double value;
    final BookingType type;
    final Booking parent;

    public InflatedBooking(final long date, final double value, final BookingType type, final Booking parent) {
        this.date = date;
        this.value = value;
        this.type = type;
        this.parent = parent;
    }

    public long getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }

    public BookingType getType() {
        return type;
    }

    public Booking getParent() {
        return parent;
    }
}
