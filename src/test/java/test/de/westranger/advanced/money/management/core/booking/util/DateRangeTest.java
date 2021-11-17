package test.de.westranger.advanced.money.management.core.booking.util;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import de.westranger.advanced.money.management.core.booking.util.DateRange;
import de.westranger.advanced.money.management.core.util.DateUtil;
import org.junit.Test;

public class DateRangeTest {

    @Test
    public void testGetter() {
        final Date dateStart = DateUtil.createDate(1, Calendar.JANUARY, 2020);
        final Date dateEnd = DateUtil.createDate(31, Calendar.JANUARY, 2020);
        final DateRange dr = new DateRange(dateStart.getTime(), dateEnd.getTime());

        assertEquals(dateStart.getTime(), dr.getStartDate());
        assertEquals(dateEnd.getTime(), dr.getEndDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartDateLargerEndeDate() {
        final Date dateStart = DateUtil.createDate(1, Calendar.JANUARY, 2020);
        final Date dateEnd = DateUtil.createDate(31, Calendar.JANUARY, 2020);
        final DateRange dr = new DateRange(dateEnd.getTime(), dateStart.getTime());
    }

    @Test
    public void testBetween() {
        final Date dateStart = DateUtil.createDate(1, Calendar.JANUARY, 2020);
        final Date dateEnd = DateUtil.createDate(31, Calendar.JANUARY, 2020);
        final DateRange dr = new DateRange(dateStart.getTime(), dateEnd.getTime());

        Date dateTooEarly = DateUtil.createDate(1, Calendar.JANUARY, 2019);
        Date dateBetween = DateUtil.createDate(10, Calendar.JANUARY, 2020);
        Date dateTooLate = DateUtil.createDate(1, Calendar.JANUARY, 2021);

        assertFalse(dr.isBetween(dateTooEarly.getTime()));
        assertTrue(dr.isBetween(dateBetween.getTime()));
        assertFalse(dr.isBetween(dateTooLate.getTime()));
    }
}



