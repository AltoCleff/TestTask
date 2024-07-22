package my.altocleff.testtask.controller;

import my.altocleff.testtask.entity.Booking;
import my.altocleff.testtask.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking bookLot(@RequestBody Booking booking) {
        return bookingService.bookLot(booking);
    }
}
