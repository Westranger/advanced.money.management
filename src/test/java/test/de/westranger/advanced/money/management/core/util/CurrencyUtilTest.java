package test.de.westranger.advanced.money.management.core.util;

import de.westranger.advanced.money.management.core.util.CurrencyUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class CurrencyUtilTest {

    @Test
    public void equals() {
        double valueA = 1.0;
        double valueB = 1.0;
        assertTrue(CurrencyUtil.equals(valueA, valueB));

        valueA = 0.1;
        valueB = 0.1;
        assertTrue(CurrencyUtil.equals(valueA, valueB));

        valueA = 0.01;
        valueB = 0.01;
        assertTrue(CurrencyUtil.equals(valueA, valueB));

        valueA = 0.0099;
        valueB = 0.0000;
        assertTrue(CurrencyUtil.equals(valueA, valueB));

        valueA = 2.0;
        valueB = 1.0;
        assertFalse(CurrencyUtil.equals(valueA, valueB));
        valueA = 1.0;
        valueB = 2.0;
        assertFalse(CurrencyUtil.equals(valueA, valueB));

        valueA = 0.2;
        valueB = 0.1;
        assertFalse(CurrencyUtil.equals(valueA, valueB));

        valueA = 0.1;
        valueB = 0.2;
        assertFalse(CurrencyUtil.equals(valueA, valueB));

        valueA = 0.02;
        valueB = 0.01;
        assertFalse(CurrencyUtil.equals(valueA, valueB));

        valueA = 0.01;
        valueB = 0.02;
        assertFalse(CurrencyUtil.equals(valueA, valueB));

        valueA = 0.0099;
        valueB = 0.01;
        assertTrue(CurrencyUtil.equals(valueA, valueB));
    }

    @Test
    public void compareTo() {
        double valueA = 1.0;
        double valueB = 1.0;
        assertEquals(0, CurrencyUtil.compareTo(valueA, valueB), 1e-6);

        valueA = 0.1;
        valueB = 0.1;
        assertEquals(0, CurrencyUtil.compareTo(valueA, valueB), 1e-6);

        valueA = 0.01;
        valueB = 0.01;
        assertEquals(0, CurrencyUtil.compareTo(valueA, valueB), 1e-6);

        valueA = 0.0099;
        valueB = 0.0000;
        assertEquals(1, CurrencyUtil.compareTo(valueA, valueB), 1e-6);

        valueA = 2.0;
        valueB = 1.0;
        assertEquals(100, CurrencyUtil.compareTo(valueA, valueB), 1e-6);
        valueA = 1.0;
        valueB = 2.0;
        assertFalse(CurrencyUtil.equals(valueA, valueB));

        valueA = 0.2;
        valueB = 0.1;
        assertEquals(10, CurrencyUtil.compareTo(valueA, valueB), 1e-6);


        valueA = 0.02;
        valueB = 0.01;
        assertEquals(1, CurrencyUtil.compareTo(valueA, valueB), 1e-6);

        valueA = 0.0099;
        valueB = 0.01;
        assertEquals(0, CurrencyUtil.compareTo(valueA, valueB), 1e-6);
    }
}