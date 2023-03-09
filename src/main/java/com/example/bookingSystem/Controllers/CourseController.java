package com.example.bookingSystem.Controllers;

import com.example.bookingSystem.Models.Booking;
import com.example.bookingSystem.Models.Course;
import com.example.bookingSystem.Models.Course;
import com.example.bookingSystem.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/courses/{id}")
    public ResponseEntity getCoursesById(@PathVariable Long id){
        Optional<Course> foundCourse = courseRepository.findById(id);
        return new ResponseEntity<>(foundCourse, HttpStatus.OK);
    }

    @PostMapping(value="/courses")
    public ResponseEntity<Course> postCourse(@RequestBody Course course){
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping(value="/courses/ratings")
    public ResponseEntity<List<Course>> getAllCoursesByStarRating(
            @RequestParam(name="starRating", required = false) Integer starRating
    ){
        return new ResponseEntity<>(courseRepository.findByStarRating(starRating), HttpStatus.OK);
    }
}
