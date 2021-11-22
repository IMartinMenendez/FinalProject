package com.ironhack.edge.clients;

import com.ironhack.common.dto.course.CourseRequest;
import com.ironhack.common.dto.course.CourseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("course-service")
public interface CourseClient {

    @GetMapping("/Courses")
    List<CourseResponse> getAllCourses();

    @GetMapping("/Course/{id}")
    CourseResponse getCourseById(@PathVariable Long id) throws Exception;

    @GetMapping("/Course/{userId}")
    List<CourseResponse> getCourseByUserId(@PathVariable Long userId);

    @DeleteMapping("/Course/{id}")
    void deleteCourseId(@PathVariable Long id) throws Exception;

    @PutMapping("/Course/{id}")
    void updateCourse(@PathVariable Long id,  @RequestBody CourseRequest courseRequest) throws Exception;

    @PostMapping("/Courses")
    void createNewCourse(@RequestBody CourseRequest courseRequest);
}
