package com.paypal.bfs.test.bookingserv.vo;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class BookingVO implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private Integer bookingId;

    private String first_name;
    private String  last_name;
    private Date date_of_birth;
    private Date    checkin_datetime;
    private Date    checkout_datetime;
    private Integer   total_price;

    public BookingVO(){

    }

    public BookingVO (Booking booking){
        this.bookingId = booking.getId();

        this.checkin_datetime = booking.getCheckinDatetime();
        this.checkout_datetime = booking.getCheckoutDatetime();
        this.date_of_birth = booking.getDateOfBirth();
        this.first_name= booking.getFirstName();
        this.last_name = booking.getLastName();
        this.total_price = booking.getTotalPrice();
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Date getCheckin_datetime() {
        return checkin_datetime;
    }

    public void setCheckin_datetime(Date checkin_datetime) {
        this.checkin_datetime = checkin_datetime;
    }

    public Date getCheckout_datetime() {
        return checkout_datetime;
    }

    public void setCheckout_datetime(Date checkout_datetime) {
        this.checkout_datetime = checkout_datetime;
    }

    public Integer getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }
}
