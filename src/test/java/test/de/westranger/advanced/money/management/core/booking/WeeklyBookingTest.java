package test.de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.*;
import de.westranger.advanced.money.management.core.util.DateUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public final class WeeklyBookingTest {

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
    public void testConstructorNegativeRepetition() {
        Booking booking = new WeeklyBooking(-1, 10, this.value, this.type, this.dateRange, this.description);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeDayOfWeek() {
        Booking booking = new WeeklyBooking(1, -5, this.value, this.type, this.dateRange, this.description);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorTooLargeDayOfWeek() {
        Booking booking = new WeeklyBooking(1, 100, this.value, this.type, this.dateRange, this.description);
    }

    @Test
    public void testConstructorDayOfWeek() {
        WeeklyBooking booking = new WeeklyBooking(1, 6, this.value, this.type, this.dateRange, this.description);
        assertEquals(1, booking.getRepetition());
        assertEquals(6, booking.getDayOfWeek());
    }
}