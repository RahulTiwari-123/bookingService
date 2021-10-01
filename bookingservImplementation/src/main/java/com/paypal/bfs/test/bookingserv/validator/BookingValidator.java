package com.paypal.bfs.test.bookingserv.validator;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import exception.InvalidRequestException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BookingValidator {

    public boolean validateBookingRequest(Booking booking) throws InvalidRequestException{

        if(booking.getId() == null)
            throw new InvalidRequestException("booking id is null");
        if(booking.getFirstName() == null || booking.getFirstName().isEmpty())
            throw new InvalidRequestException("First name is null");
        if(booking.getLastName() == null || booking.getLastName().isEmpty())
            throw new InvalidRequestException("last name is null");
        if(booking.getDateOfBirth() == null || booking.getDateOfBirth().after(new Date()))
            throw new InvalidRequestException("dob is null or invalid ");
        if(booking.getCheckinDatetime() == null || booking.getCheckoutDatetime()==null || booking.getCheckoutDatetime().before(booking.getCheckinDatetime()))
            throw new InvalidRequestException("checkin/out date is null/invalid");
        if(booking.getTotalPrice() == null || booking.getTotalPrice()<=0)
            throw new InvalidRequestException("total price is null or less than 0");
        if(booking.getDeposit() == null || booking.getDeposit()<=0)
            throw new InvalidRequestException("In correct deposit value");
        if(booking.getAddress() == null || booking.getAddress().getCity() == null || booking.getAddress().getLine1()==null || booking.getAddress().getZipcode() == null)
            throw new InvalidRequestException("In correct or empty address");

        return true;
    }

}
