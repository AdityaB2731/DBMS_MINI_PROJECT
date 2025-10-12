package com.railwaybooking.railwaybookingsystem.service;

import com.railwaybooking.railwaybookingsystem.model.Booking;
import com.railwaybooking.railwaybookingsystem.repository.BookingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking addBooking(Booking booking) {
        return repository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return repository.findAll();
    }
}

