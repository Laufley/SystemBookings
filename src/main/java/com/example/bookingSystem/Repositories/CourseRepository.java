package com.example.bookingSystem.Repositories;

import com.example.bookingSystem.Models.Course;
import com.example.bookingSystem.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long>{

    List<Course> findByStarRating(Integer starRating);
}

