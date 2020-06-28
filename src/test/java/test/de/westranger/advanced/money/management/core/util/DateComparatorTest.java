package test.de.westranger.advanced.money.management.core.util;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import de.westranger.advanced.money.management.core.util.DateComparator;
import de.westranger.advanced.money.management.core.util.DateUtil;

public class DateComparatorTest {

    @Test
    public void testCompare() {
        final Date dateA = DateUtil.createDate(1, Calendar.JANUARY, 2011);
        final Date dateB = DateUtil.createDate(1, Calendar.MARCH, 2011);
        final Date dateC = DateUtil.createDate(1, Calendar.FEBRUARY, 2011);
        final Date dateD = DateUtil.createDate(1, Calendar.APRIL, 2011);
        final Date dateE = DateUtil.createDate(1, Calendar.JANUARY, 2011);

        final List<Date> lst = new LinkedList<Date>();
        lst.add(dateA);
        lst.add(dateB);
        lst.add(dateC);
        lst.add(dateD);
        lst.add(dateE);

        Collections.sort(lst, new DateComparator());

        assertEquals(dateA, lst.get(0));
        assertEquals(dateE, lst.get(1));
        assertEquals(dateC, lst.get(2));
        assertEquals(dateB, lst.get(3));
        assertEquals(dateD, lst.get(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullParameterA() {
        final Date dateA = DateUtil.createDate(1, Calendar.JANUARY, 2011);
        DateComparator cmp = new DateComparator();
        cmp.compare(null, dateA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullParameterB() {
        final Date dateA = DateUtil.createDate(1, Calendar.JANUARY, 2011);
        DateComparator cmp = new DateComparator();
        cmp.compare(dateA, null);
    }

}
