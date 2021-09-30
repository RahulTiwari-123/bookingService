package com.paypal.bfs.test.bookingserv.service.impl;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.BookingDao;
import com.paypal.bfs.test.bookingserv.vo.BookingVO;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import exception.BookingAlreadyExistsException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    BookingDao dao;

    public BookingServiceImpl(BookingDao bookingDao){
        this.dao = bookingDao;
    }

    @PostConstruct
    private void intialize(){

    }

    @Override
    public List<Booking> findAllBookings() {
        List<Booking> list = new LinkedList<>();
        Iterator<BookingVO> itr = dao.findAll().iterator();
        BookingVO bookingVO;
        while (itr.hasNext()){
            bookingVO =  itr.next();
            list.add(convertToVO(bookingVO));
        }

        return list;

    }

    private Booking convertToVO(BookingVO bookingVO){
        if(bookingVO==null)
            return null;

        Booking booking = new Booking();
        booking.setId(bookingVO.getBookingId());
        booking.setCheckinDatetime(bookingVO.getCheckin_datetime());
        booking.setCheckoutDatetime(bookingVO.getCheckout_datetime());
        booking.setDateOfBirth(bookingVO.getDate_of_birth());
        booking.setFirstName(bookingVO.getFirst_name());
        booking.setLastName(bookingVO.getFirst_name());
        booking.setTotalPrice(bookingVO.getTotal_price());

        return booking;
    }

    @Override
    public BookingVO createBooking(Booking booking){

        BookingVO response ;
            try {
                response=dao.save(new BookingVO(booking));
            }catch(DataIntegrityViolationException e){
               throw new BookingAlreadyExistsException(booking.getId());
            }
        return response;
    }

    @Override
    public Booking findBooking(Integer id){
         BookingVO bookingVO = dao.findByBookingId(id);
        Booking booking=null;
        if(bookingVO!=null) {
           booking= convertToVO(bookingVO);
        };

        return booking;
    }


}
