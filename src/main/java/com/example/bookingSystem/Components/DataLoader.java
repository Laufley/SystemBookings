package com.example.bookingSystem.Components;

import com.example.bookingSystem.Models.Booking;
import com.example.bookingSystem.Models.Course;
import com.example.bookingSystem.Models.Customer;


import com.example.bookingSystem.Repositories.BookingRepository;
import com.example.bookingSystem.Repositories.CourseRepository;
import com.example.bookingSystem.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
    public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){};

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Customer gladys = new Customer("Gladys Knight", "Detroit", 38);
        customerRepository.save(gladys);

        Customer jane = new Customer("Jane Janerson", "Little Rock", 25);
        customerRepository.save(jane);

        Customer barbara = new Customer("Barbara Ella", "Charleston", 33);
        customerRepository.save(barbara);

        Course java = new Course("Intro to Java", "Detroit", 5);
        courseRepository.save(java);

        Course marshmallow = new Course("Marshmallow Making", "Atlanta", 4);
        courseRepository.save(marshmallow);

        Course skipping = new Course("Skipping Like a Pro", "Little Rock", 3);
        courseRepository.save(skipping);

        Booking booking1 = new Booking("01/02/23", gladys, java);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("04/03/23", jane, marshmallow);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("23/4/23", barbara, marshmallow);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("03/03/23", barbara, java);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("13/04/23", gladys, skipping);
        bookingRepository.save(booking5);

        Booking booking6 = new Booking("14/03/23", jane, skipping);
        bookingRepository.save(booking6);
    }
}

