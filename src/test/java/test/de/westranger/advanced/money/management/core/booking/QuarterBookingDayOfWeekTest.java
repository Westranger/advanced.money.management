package test.de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.*;
import de.westranger.advanced.money.management.core.booking.enums.DayOfWeek;
import de.westranger.advanced.money.management.core.booking.enums.Numerator;
import de.westranger.advanced.money.management.core.booking.enums.BookingType;
import de.westranger.advanced.money.management.core.booking.util.DateExclusion;
import de.westranger.advanced.money.management.core.booking.util.DateExclusionImpl;
import de.westranger.advanced.money.management.core.booking.util.DateRange;
import de.westranger.advanced.money.management.core.util.DateUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class QuarterBookingDayOfWeekTest {
    private String description;
    private DateRange dateRange;
    private BookingType type;
    private double value;
    private Numerator num;
    private DayOfWeek dow;
    private DateExclusion de;

    @Before
    public void setUp() throws Exception {
        value = 10.00;
        type = BookingType.Expense;
        Date dateStart = DateUtil.createDate(1, Calendar.JANUARY, 2019);
        Date dateEnd = DateUtil.createDate(1, Calendar.JANUARY, 2021);
        dateRange = new DateRange(dateStart.getTime(), dateEnd.getTime());
        description = "JUnit Booking";
        num = Numerator.First;
        dow = DayOfWeek.Monday;
        de = new DateExclusionImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNumeratorNull() {
        Booking booking = new MonthlyBookingDayOfWeek(null, this.dow, this.value, this.type, this.dateRange, this.description, this.de);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorDayOfWeekNull() {
        Booking booking = new MonthlyBookingDayOfWeek(this.num, null, this.value, this.type, this.dateRange, this.description, this.de);
    }

    @Test
    public void testConstructorDayOfMonth() {
        MonthlyBookingDayOfWeek booking = new MonthlyBookingDayOfWeek(this.num, this.dow, this.value, this.type, this.dateRange, this.description, this.de);
        assertEquals(Numerator.First, booking.getNumerator());
        assertEquals(DayOfWeek.Monday, booking.getDayOfWeek());
    }
}
