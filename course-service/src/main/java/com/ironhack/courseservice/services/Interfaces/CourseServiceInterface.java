package com.ironhack.courseservice.services.Interfaces;

import com.ironhack.courseservice.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseServiceInterface {

    List<Course> getAllCourses();

    Optional<Course> getCourseById(Long id);

    List<Course> getCourseByUserId(Long id);

    void updateCourse(Long id, Course course) throws Exception;

    void createNewCourse(Course course);
}
