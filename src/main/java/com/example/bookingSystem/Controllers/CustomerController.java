package com.example.bookingSystem.Controllers;

import com.example.bookingSystem.Models.Booking;
import com.example.bookingSystem.Models.Course;
import com.example.bookingSystem.Models.Customer;
import com.example.bookingSystem.Repositories.BookingRepository;
import com.example.bookingSystem.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/customers/{id}")
    public ResponseEntity getCustomerById(@PathVariable Long id){
        Optional<Customer> foundCustomer = customerRepository.findById(id);
        return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
    }

    @PostMapping(value="/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


}
