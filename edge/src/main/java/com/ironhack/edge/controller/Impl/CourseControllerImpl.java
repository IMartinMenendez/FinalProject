package com.ironhack.edge.controller.Impl;

import com.ironhack.common.dto.course.CourseRequest;
import com.ironhack.common.dto.course.CourseResponse;
import com.ironhack.edge.clients.UserClient;
import com.ironhack.edge.service.Impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseControllerImpl {

    @Autowired
    CourseServiceImpl courseService;

    @Autowired
    UserClient authorSessionClient;

    @GetMapping("/Courses")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseResponse> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/Courses/{id}")
    @CrossOrigin(value = "http://localhost:4200")
    CourseResponse getCourseById(@PathVariable Long id) throws Exception{
        return courseService.getCourseById(id);
    }

    @GetMapping("/Course/{userId}")
    @CrossOrigin(value = "http://localhost:4200")
    List<CourseResponse> getCourseByUserId(@PathVariable Long userId, @RequestHeader("X-Auth-Token") String token) throws Exception {
        return courseService.getCourseByUserId(userId, token);
    }

    @DeleteMapping("/Course/{id}")
    @CrossOrigin(value = "http://localhost:4200")
    public void deleteCourseId(@PathVariable Long id) throws Exception{
        courseService.deleteCourseId(id);
    }

    @PutMapping("/Course/{id}")
    @CrossOrigin(value = "http://localhost:4200")
    public void updateCourse(@PathVariable Long id,  @RequestBody CourseRequest courseRequest) throws Exception{
        courseService.updateCourse(id, courseRequest);
    }

    @PostMapping("/Courses")
    @CrossOrigin(value = "http://localhost:4200")
    public void createNewCourse(@RequestBody CourseRequest courseRequest){
        courseService.createNewCourse(courseRequest);
    }

}
