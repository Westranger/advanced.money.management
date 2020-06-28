package test.de.westranger.advanced.money.management.core.booking;

import de.westranger.advanced.money.management.core.booking.*;
import de.westranger.advanced.money.management.core.util.DateUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public final class SingleBookingTest {

    private int repetition;
    private String description;
    private DateRange dateRange;
    private BookingType type;
    private double value;
    private Date date;
    private DateExclusion de;

    @Before
    public void setUp() throws Exception {
        repetition = 5;
        date = DateUtil.createDate(1, Calendar.JANUARY, 2020);
        value = 10.00;
        type = BookingType.Expense;
        Date dateStart = DateUtil.createDate(1, Calendar.JANUARY, 2019);
        Date dateEnd = DateUtil.createDate(1, Calendar.JANUARY, 2021);
        dateRange = new DateRange(dateStart.getTime(), dateEnd.getTime());
        description = "JUnit Booking";
        de = new DateExclusionImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeRepetition() {
        Booking booking = new SingleBooking(-6, this.date.getTime(), Double.POSITIVE_INFINITY, this.type, this.dateRange, this.description, this.de);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorInfValue() {
        Booking booking = new SingleBooking(this.repetition, this.date.getTime(), Double.POSITIVE_INFINITY, this.type, this.dateRange, this.description, this.de);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNaNValue() {
        Booking booking = new SingleBooking(this.repetition, this.date.getTime(), Double.NaN, this.type, this.dateRange, this.description, this.de);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullBookingType() {
        Booking booking = new SingleBooking(this.repetition, this.date.getTime(), this.value, null, this.dateRange, this.description, this.de);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullDateRange() {
        Booking booking = new SingleBooking(this.repetition, this.date.getTime(), this.value, this.type, null, this.description, this.de);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullDescription() {
        Booking booking = new SingleBooking(this.repetition, this.date.getTime(), this.value, this.type, this.dateRange, null, this.de);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullDateExclusion() {
        Booking booking = new SingleBooking(this.repetition, this.date.getTime(), this.value, this.type, this.dateRange, this.description, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDateNotInDateRange() {
        Date dateStart = DateUtil.createDate(1, Calendar.JANUARY, 2019);
        Date dateEnd = DateUtil.createDate(1, Calendar.JANUARY, 2021);
        DateRange dr = new DateRange(dateStart.getTime(), dateEnd.getTime());
        Date dt = DateUtil.createDate(1, Calendar.JANUARY, 2200);

        Booking booking = new SingleBooking(this.repetition, dt.getTime(), this.value, this.type, dr, this.description, this.de);
    }

    @Test
    public void testGetter() {
        SingleBooking booking = new SingleBooking(this.repetition, this.date.getTime(), this.value, this.type, this.dateRange, this.description, this.de);

        assertEquals(this.date.getTime(), booking.getDate());
        assertEquals(this.value, booking.getValue(), 1e-6);
        assertEquals(this.type, booking.getType());
        assertEquals(this.dateRange, booking.getDateRange());
        assertEquals(this.description, booking.getDescription());
        assertEquals(this.de, booking.getDateExclusion());
    }
}