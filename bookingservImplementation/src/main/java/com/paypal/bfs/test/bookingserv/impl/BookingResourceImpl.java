package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.vo.BookingVO;
import com.paypal.bfs.test.bookingserv.service.imp.BookingServiceImp;
import exception.BookingAlreadyExistsException;
import exception.BookingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingResourceImpl implements BookingResource {

    BookingServiceImp bookingServiceImp;

    public BookingResourceImpl(BookingServiceImp bookingServiceImp){
        this.bookingServiceImp = bookingServiceImp;

    }

    @Override
    public ResponseEntity<Booking> create(Booking booking) {
        BookingVO response;
        try {
            response = bookingServiceImp.creatingBooking(booking);
        }catch (BookingAlreadyExistsException e){
            return new ResponseEntity<>(booking, HttpStatus.ALREADY_REPORTED);
        }catch (Exception e){
            return new ResponseEntity<>(booking, HttpStatus.INTERNAL_SERVER_ERROR);
        }
           return new ResponseEntity<>(booking, HttpStatus.CREATED);

    }
    @Override
    public ResponseEntity<Booking> find(Integer bookingId) {
        Booking booking = bookingServiceImp.findBooking(bookingId);
        if(booking != null)
            return  new ResponseEntity<>(booking, HttpStatus.OK);
        else
            throw new BookingNotFoundException(bookingId);
           /* throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, bookingId+" Not Found");*/

    }
}
