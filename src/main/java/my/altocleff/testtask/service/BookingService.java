package my.altocleff.testtask.service;

import my.altocleff.testtask.entity.Booking;
import my.altocleff.testtask.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking bookLot(Booking booking) {
        return bookingRepository.save(booking);
    }
}
