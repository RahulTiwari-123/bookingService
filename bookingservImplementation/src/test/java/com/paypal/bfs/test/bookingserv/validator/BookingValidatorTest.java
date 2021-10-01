package com.paypal.bfs.test.bookingserv.validator;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class BookingValidatorTest {

    Booking booking;

    private void setUp() {
        booking = new Booking();
        booking.setId(123);
        booking.setTotalPrice(456);
        booking.setCheckinDatetime(new Date());
        booking.setCheckoutDatetime(new Date());
        booking.setDateOfBirth(new Date());
        booking.setFirstName("rahul");
        booking.setLastName("tiwari");
        booking.setDeposit(100);

        Address address = new Address();
        address.setCity("test");
        address.setLine1("line1");
        address.setLine2("line2");
        address.setCity("test city");
        address.setState("test state");
        address.setZipcode(123456);
        booking.setAddress(address);
    }


    @Test
    public void testValidRequest(){
        setUp();
        BookingValidator bookingValidator= new BookingValidator();
        Assert.assertFalse(!bookingValidator.validateBookingRequest(booking));
    }
}
