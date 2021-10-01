package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.validator.BookingValidator;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import com.paypal.bfs.test.bookingserv.vo.BookingVO;
import exception.BookingAlreadyExistsException;
import exception.BookingNotFoundException;
import exception.InvalidRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class BookingResourceImpl implements BookingResource {

    BookingService bookingService;
    BookingValidator bookingValidator;

    public BookingResourceImpl(BookingService bookingService, BookingValidator bookingValidator){
        this.bookingService = bookingService;
        this.bookingValidator=bookingValidator;
    }

    @Override
    public ResponseEntity<Booking> create(Booking booking) {
        try {
            bookingValidator.validateBookingRequest(booking);
        }catch(InvalidRequestException ire){
            throw ire;
        }

        BookingVO response;
        try {
            response = bookingService.createBooking(booking);
        }catch (BookingAlreadyExistsException e){
            return new ResponseEntity<>(booking, HttpStatus.ALREADY_REPORTED);
        }catch (Exception e){
            return new ResponseEntity<>(booking, HttpStatus.INTERNAL_SERVER_ERROR);
        }
           return new ResponseEntity<>(booking, HttpStatus.CREATED);

    }
    @Override
    public ResponseEntity<Booking> find(Integer bookingId) {
        Booking booking = bookingService.findBooking(bookingId);
        if(booking != null)
            return  new ResponseEntity<>(booking, HttpStatus.OK);
        else
            throw new BookingNotFoundException(bookingId);
           /* throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, bookingId+" Not Found");*/

    }

    @Override
    public ResponseEntity<List<Booking>> findAll() {

        List<Booking> list =new LinkedList<>();
        try {
            list = bookingService.findAllBookings();
        }catch(Exception e){
            return new ResponseEntity<>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(bookingService.findAllBookings(), HttpStatus.OK);
       }
}
