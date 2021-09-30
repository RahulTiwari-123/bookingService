package com.paypal.bfs.test.bookingserv.service.imp;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.BookingDao;
import com.paypal.bfs.test.bookingserv.vo.BookingVO;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import exception.BookingAlreadyExistsException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BookingServiceImp implements BookingService {

    BookingDao dao;

    public BookingServiceImp(BookingDao bookingDao){
        this.dao = bookingDao;
    }

    @PostConstruct
    private void intialize(){

    }

    @Override
    public List<Booking> findAllBookings() {
        return null;
    }

    @Override
    public BookingVO creatingBooking(Booking booking){

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
             booking = new Booking();
            booking.setCheckinDatetime(bookingVO.getCheckin_datetime());
            booking.setCheckoutDatetime(bookingVO.getCheckout_datetime());
            booking.setDateOfBirth(bookingVO.getDate_of_birth());
            booking.setFirstName(bookingVO.getFirst_name());
            booking.setLastName(bookingVO.getFirst_name());
            booking.setTotalPrice(bookingVO.getTotal_price());
        };

        return booking;
    }


}
