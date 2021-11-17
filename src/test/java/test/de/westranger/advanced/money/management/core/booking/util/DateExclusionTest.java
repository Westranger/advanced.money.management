package test.de.westranger.advanced.money.management.core.booking.util;

import de.westranger.advanced.money.management.core.booking.util.DateExclusion;
import de.westranger.advanced.money.management.core.booking.util.DateExclusionImpl;
import de.westranger.advanced.money.management.core.booking.util.DateRangeExclusion;
import de.westranger.advanced.money.management.core.util.DateUtil;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateExclusionTest {
    @Test(expected = IllegalArgumentException.class)
    public void testStartDateLargerEndDate() {
        final Date dateStart = DateUtil.createDate(1, Calendar.JANUARY, 2020);
        final Date dateEnd = DateUtil.createDate(31, Calendar.JANUARY, 2020);
        final DateExclusion dr = new DateRangeExclusion(dateEnd.getTime(), dateStart.getTime());
    }

    @Test
    public void testDateRangeExclusion() {
        final Date dateStart = DateUtil.createDate(1, Calendar.JANUARY, 2020);
        final Date dateEnd = DateUtil.createDate(31, Calendar.JANUARY, 2020);
        final DateExclusion de = new DateRangeExclusion(dateStart.getTime(), dateEnd.getTime());

        Date dateTooEarly = DateUtil.createDate(1, Calendar.JANUARY, 2019);
        Date dateBetween = DateUtil.createDate(10, Calendar.JANUARY, 2020);
        Date dateTooLate = DateUtil.createDate(1, Calendar.JANUARY, 2021);

        assertFalse(de.isExcluded(dateTooEarly.getTime()));
        assertTrue(de.isExcluded(dateBetween.getTime()));
        assertFalse(de.isExcluded(dateTooLate.getTime()));
    }

    @Test
    public void testDateExclusion() {
        final Date dateA = DateUtil.createDate(1, Calendar.JANUARY, 2020);
        final Date dateB = DateUtil.createDate(31, Calendar.JANUARY, 2020);
        final DateExclusionImpl de = new DateExclusionImpl();

        Date dateAExclude = DateUtil.createDate(1, Calendar.JANUARY, 2020);
        Date dateBExclude = DateUtil.createDate(10, Calendar.JANUARY, 2020);

        de.addDateToExclude(dateA.getTime());
        de.addDateToExclude(dateB.getTime());

        assertTrue(de.isExcluded(dateAExclude.getTime()));
        assertFalse(de.isExcluded(dateBExclude.getTime()));
    }
}
