package com.example.bookingSystem.Controllers;

import com.example.bookingSystem.Models.Booking;
import com.example.bookingSystem.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value="/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/bookings/{id}")
    public ResponseEntity getBookingById(@PathVariable Long id){
        Optional<Booking> foundBooking = bookingRepository.findById(id);
        return new ResponseEntity<>(foundBooking, HttpStatus.OK);
    }

    @PostMapping(value="/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }


}
