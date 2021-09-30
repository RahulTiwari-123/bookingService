package com.paypal.bfs.test.bookingserv.api;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface BookingResource {
    /**
     * Create {@link Booking} resource
     *
     * @param booking the booking object
     * @return the created booking
     */
    @RequestMapping(value = "/v1/bfs/booking", method = RequestMethod.POST)
    ResponseEntity<Booking> create(@RequestBody Booking booking);

    // ----------------------------------------------------------
    // TODO - add a new operation for Get All the bookings resource.
    // ----------------------------------------------------------

    @RequestMapping(value = "/v1/bfs/booking/{bookingId}", method = RequestMethod.GET)
    ResponseEntity<Booking> find(@PathVariable Integer bookingId);

   // @RequestMapping(value = "/v1/bfs/booking/", method = RequestMethod.GET)
    //ResponseEntity<Booking> findAll(@RequestParam String fromPage, @RequestParam Integer pageSize);

}
