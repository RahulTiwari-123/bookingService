package com.paypal.bfs.test.bookingserv.dao;


import com.paypal.bfs.test.bookingserv.vo.BookingVO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingDao extends CrudRepository<BookingVO,Integer> {

    BookingVO findByBookingId(Integer id);










}
