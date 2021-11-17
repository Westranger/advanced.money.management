package de.westranger.advanced.money.management.core.booking.util;

public final class Triple<T, U, V> {

    private final T first;
    private final U second;
    private final V third;

    public Triple(final T first, final U second, final V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public V getThird() {
        return third;
    }
}
