package test.de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.Booking;
import de.westranger.advanced.money.management.core.booking.WeeklyBooking;
import de.westranger.advanced.money.management.core.booking.YearlyBooking;
import de.westranger.advanced.money.management.core.booking.enums.BookingType;
import de.westranger.advanced.money.management.core.booking.enums.MonthOfYear;
import de.westranger.advanced.money.management.core.booking.util.DateExclusion;
import de.westranger.advanced.money.management.core.booking.util.DateExclusionImpl;
import de.westranger.advanced.money.management.core.booking.util.DateRange;
import de.westranger.advanced.money.management.core.util.DateUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class YearlyBookingTest {

    private String description;
    private DateRange dateRange;
    private BookingType type;
    private double value;
    private DateExclusion de;

    @Before
    public void setUp() {
        value = 10.00;
        type = BookingType.Expense;
        Date dateStart = DateUtil.createDate(1, Calendar.JANUARY, 2019);
        Date dateEnd = DateUtil.createDate(1, Calendar.JANUARY, 2021);
        dateRange = new DateRange(dateStart.getTime(), dateEnd.getTime());
        description = "JUnit Booking";
        de = new DateExclusionImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeDayOfMonth() {
        Booking booking = new YearlyBooking(MonthOfYear.December, -5, this.value, this.type, this.dateRange, this.description, this.de);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorTooLargeDayOfWeek() {
        Booking booking = new YearlyBooking(MonthOfYear.December, 100, this.value, this.type, this.dateRange, this.description, this.de);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullDateExclusion() {
        Booking booking = new YearlyBooking(MonthOfYear.December, 5, this.value, this.type, this.dateRange, this.description, null);
    }

    @Test
    public void testConstructorDayOfWeek() {
        YearlyBooking booking = new YearlyBooking(MonthOfYear.January, 13, this.value, this.type, this.dateRange, this.description, this.de);
        assertEquals(MonthOfYear.January, booking.getMonthOfYear());
        assertEquals(6, booking.getDayOfMonth());
    }
}