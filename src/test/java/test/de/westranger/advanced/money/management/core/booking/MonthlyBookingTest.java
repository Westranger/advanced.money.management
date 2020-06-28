package test.de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.*;
import de.westranger.advanced.money.management.core.util.DateUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public final class MonthlyBookingTest {

    private String description;
    private DateRange dateRange;
    private BookingType type;
    private double value;

    @Before
    public void setUp() throws Exception {
        value = 10.00;
        type = BookingType.Expense;
        Date dateStart = DateUtil.createDate(1, Calendar.JANUARY, 2019);
        Date dateEnd = DateUtil.createDate(1, Calendar.JANUARY, 2021);
        dateRange = new DateRange(dateStart.getTime(), dateEnd.getTime());
        description = "JUnit Booking";
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeDayOfMonth() {
        Booking booking = new MonthlyBooking(-5, this.value, this.type, this.dateRange, this.description);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorTooLargeDayOfMonth() {
        Booking booking = new MonthlyBooking(100, this.value, this.type, this.dateRange, this.description);
    }

    @Test
    public void testConstructorDayOfMonth() {
        MonthlyBooking booking = new MonthlyBooking(5, this.value, this.type, this.dateRange, this.description);
        assertEquals(5, booking.getDayOfMonth());
    }
}