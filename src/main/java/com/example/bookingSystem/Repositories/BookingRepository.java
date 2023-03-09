package com.example.bookingSystem.Repositories;

import com.example.bookingSystem.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository  extends JpaRepository<Booking, Long> {


}

