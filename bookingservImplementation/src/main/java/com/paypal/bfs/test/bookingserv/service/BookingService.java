package com.paypal.bfs.test.bookingserv.service;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.vo.BookingVO;

import java.util.List;

public interface BookingService {

    public BookingVO createBooking(Booking booking);
    public Booking findBooking(Integer id);
    public List<Booking> findAllBookings();
}
