package com.paypal.bfs.test.bookingserv.dao;


import com.paypal.bfs.test.bookingserv.vo.BookingVO;
import org.springframework.data.repository.CrudRepository;

public interface BookingDao extends CrudRepository<BookingVO,Integer> {

    BookingVO findByBookingId(Integer id);








}
