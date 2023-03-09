package com.example.bookingSystem.Repositories;

import com.example.bookingSystem.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
