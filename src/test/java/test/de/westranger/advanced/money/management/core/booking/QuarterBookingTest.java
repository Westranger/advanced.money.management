package test.de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.*;
import de.westranger.advanced.money.management.core.booking.enums.MonthOfQuarter;
import de.westranger.advanced.money.management.core.util.DateUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class QuarterBookingTest {
    private String description;
    private DateRange dateRange;
    private BookingType type;
    private double value;
    private MonthOfQuarter moq;

    @Before
    public void setUp() throws Exception {
        value = 10.00;
        type = BookingType.Expense;
        Date dateStart = DateUtil.createDate(1, Calendar.JANUARY, 2019);
        Date dateEnd = DateUtil.createDate(1, Calendar.JANUARY, 2021);
        dateRange = new DateRange(dateStart.getTime(), dateEnd.getTime());
        description = "JUnit Booking";
        moq = MonthOfQuarter.First;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorMonthOfQuarterNull() {
        Booking booking = new QuarterBooking(null, 5, this.value, this.type, this.dateRange, this.description);
    }

    @Test
    public void testConstructorMonthOfQuarter() {
        QuarterBooking booking = new QuarterBooking(this.moq, 5, this.value, this.type, this.dateRange, this.description);
        assertEquals(MonthOfQuarter.First, booking.getMonthOfQuarter());
    }
}
