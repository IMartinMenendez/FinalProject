package com.ironhack.courseservice.controller;

import com.ironhack.courseservice.controller.dto.CourseRequest;
import com.ironhack.courseservice.controller.dto.CourseResponse;
import com.ironhack.courseservice.services.Impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseServiceImpl courseService;

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

    @GetMapping("/Course/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseResponse> getCourseByUserId(@PathVariable Long userId) throws Exception {
        return courseService.getCourseByUserId(userId);
    }

    @DeleteMapping("/Course/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCourseId(@PathVariable Long id) throws Exception {
        courseService.deleteCourse(id);
    }

    @PutMapping("/Course/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCourse(@PathVariable Long id,  @RequestBody CourseRequest courseRequest) throws Exception {
        courseService.updateCourse(id, courseRequest);
    }

    @PostMapping("/Courses")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewCourse(@RequestBody CourseRequest courseRequest){
        courseService.createNewCourse(courseRequest);
    }

}
