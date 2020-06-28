package test.de.westranger.advanced.money.management.core.util;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import de.westranger.advanced.money.management.core.util.DateUtil;

public class DateUtilTest {

    @Test(expected = IllegalArgumentException.class)
    public void testWrongYear() {
        DateUtil.createDate(1, Calendar.JANUARY, 1899);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongMonthA() {
        DateUtil.createDate(1, -1, 2018);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongMonthB() {
        DateUtil.createDate(1, 13, 2018);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongDayOfMonthA() {
        DateUtil.createDate(0, Calendar.JANUARY, 2018);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongDayOfMonthB() {
        DateUtil.createDate(32, Calendar.JANUARY, 2018);
    }

    @Test
    public void testCreateDate() {
        final Date date = DateUtil.createDate(22, Calendar.JANUARY, 2011);
        assertEquals(1295654400000l, date.getTime());
        assertEquals("22 Jan 2011 00:00:00 GMT", date.toGMTString());
    }

	@Test
	public void testLeapYear() {
		final Date date = DateUtil.createDate(29, Calendar.FEBRUARY, 2020);
		assertEquals(1582934400000l, date.getTime());
		assertEquals("29 Feb 2020 00:00:00 GMT", date.toGMTString());
	}

	@Test
	public void testLeapYear() {
		final Date date = DateUtil.createDate(29, Calendar.FEBRUARY, 2020);
		assertEquals(1582934400000l, date.getTime());
		assertEquals("29 Feb 2020 00:00:00 GMT", date.toGMTString());
	}

	@Test
	public void testEquals() {
		final Date dateA = DateUtil.createDate(22, Calendar.JANUARY, 2011);
		final Date dateB = DateUtil.createDate(22, Calendar.JANUARY, 2011);
		final Date dateC = DateUtil.createDate(23, Calendar.JULY, 2019);
		final Date dateD = DateUtil.createDate(22, Calendar.JULY, 2019);
		final Date dateE = DateUtil.createDate(22, Calendar.JANUARY, 2012);

        assertTrue(DateUtil.equals(dateA, dateA));
        assertTrue(DateUtil.equals(dateA, dateB));
        assertFalse(DateUtil.equals(dateA, dateC));
        assertFalse(DateUtil.equals(dateA, dateD));
        assertFalse(DateUtil.equals(dateA, dateE));
    }

    @Test
    public void testCompare() {
        final Date dateA = DateUtil.createDate(1, Calendar.JANUARY, 2020);
        final Date dateB = DateUtil.createDate(1, Calendar.FEBRUARY, 2020);

        assertEquals(0, DateUtil.compare(dateA, dateA));
        assertEquals(-1, DateUtil.compare(dateA, dateB));
        assertEquals(1, DateUtil.compare(dateB, dateA));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEqualsWrongArgumentA() {
        final Date dateA = DateUtil.createDate(22, Calendar.JANUARY, 2011);

        assertTrue(DateUtil.equals(null, dateA));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEqualsWrongArgumentB() {
        final Date dateA = DateUtil.createDate(22, Calendar.JANUARY, 2011);

        assertTrue(DateUtil.equals(dateA, null));
    }

    @Test
    public void testNormalize() {
        final Date date = new Date(System.currentTimeMillis());
        final Date normalized = DateUtil.normalize(date);

        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final Calendar calNorm = Calendar.getInstance();
        calNorm.setTime(normalized);

        assertEquals(0, calNorm.get(Calendar.MILLISECOND));
        assertEquals(0, calNorm.get(Calendar.SECOND));
        assertEquals(0, calNorm.get(Calendar.MINUTE));
        assertEquals(0, calNorm.get(Calendar.HOUR));

        assertEquals(cal.get(Calendar.DAY_OF_MONTH), calNorm.get(Calendar.DAY_OF_MONTH));
        assertEquals(cal.get(Calendar.MONTH), calNorm.get(Calendar.MONTH));
        assertEquals(cal.get(Calendar.YEAR), calNorm.get(Calendar.YEAR));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullParameter() {
        DateUtil.normalize(null);
    }

}
