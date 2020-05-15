package de.westranger.advanced.money.management.core.util;

public final class CurrencyUtil {

    public static boolean equals(final double valueA, final double valueB) {
        return Math.abs(valueA - valueB) < 0.01;
    }

    public static int compareTo(final double valueA, final double valueB) {
        return (int) Math.round((valueA - valueB) * 100);
    }

}
