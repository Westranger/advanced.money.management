package test.de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.*;
import de.westranger.advanced.money.management.core.booking.enums.DayOfWeek;
import de.westranger.advanced.money.management.core.booking.enums.MonthOfQuarter;
import de.westranger.advanced.money.management.core.booking.enums.Numerator;
import de.westranger.advanced.money.management.core.util.DateUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public final class MonthlyBookingDayOfWeekTest {

    private String description;
    private DateRange dateRange;
    private BookingType type;
    private double value;
    private Numerator num;
    private DayOfWeek dow;
    private MonthOfQuarter moq;

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
        moq = MonthOfQuarter.Second;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorMonthOfQuarterNull() {
        Booking booking = new QuarterBookingDayOfWeek(null, this.num, this.dow, this.value, this.type, this.dateRange, this.description);
    }

    @Test
    public void testConstructorDayOfMonth() {
        QuarterBookingDayOfWeek booking = new QuarterBookingDayOfWeek(this.moq, this.num, this.dow, this.value, this.type, this.dateRange, this.description);
        assertEquals(MonthOfQuarter.Second, booking.getMonthOfQuarter());
    }
}