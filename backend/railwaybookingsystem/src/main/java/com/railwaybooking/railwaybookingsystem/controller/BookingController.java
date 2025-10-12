package com.railwaybooking.railwaybookingsystem.controller;

import com.railwaybooking.railwaybookingsystem.model.Booking;
import com.railwaybooking.railwaybookingsystem.service.BookingService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")  // allow requests from frontend
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Booking addBooking(@RequestBody Booking booking) {
        return service.addBooking(booking);
    }

    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return service.getAllBookings();
    }
}

