package com.ironhack.courseservice.controller;

import com.ironhack.courseservice.controller.dto.CourseResponse;
import com.ironhack.courseservice.services.Interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/Courses")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseResponse> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/Course/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseResponse getCourseById(@PathVariable Long id) throws Exception {
        return courseService.getCourseById(id);
    }

}
