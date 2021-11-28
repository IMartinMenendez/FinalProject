package com.ironhack.courseservice.controller;

import com.ironhack.common.dto.course.CourseRequest;
import com.ironhack.common.dto.course.CourseResponse;
import com.ironhack.courseservice.model.Course;
import com.ironhack.courseservice.services.Impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseServiceImpl courseService;

    @GetMapping("/Courses")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseResponse> getAllCourses(){
        List<Course> courses = courseService.getAllCourses();
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course : courses) {
            courseResponses.add(new CourseResponse(course.getCreatorId(), course.getTitle(), course.getDescription(), course.getLink(), course.getPicture()));
        }
        return courseResponses;
    }

    @GetMapping("/Course/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseResponse getCourseById(@PathVariable Long id) throws Exception {
        Optional<Course> maybeCourse = courseService.getCourseById(id);
        if(maybeCourse.isEmpty()){
            throw new Exception("No Event found");
        }
        return new CourseResponse(maybeCourse.get().getCreatorId(), maybeCourse.get().getTitle(), maybeCourse.get().getDescription(), maybeCourse.get().getLink(), maybeCourse.get().getPicture());
    }

    @GetMapping("/Course/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseResponse> getCourseByUserId(@PathVariable Long userId) {
        List<Course> courses = courseService.getCourseByUserId(userId);
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course : courses) {
            new CourseResponse(course.getCreatorId(), course.getTitle(), course.getDescription(), course.getLink(), course.getPicture());
        }
        return courseResponses;
    }

    @DeleteMapping("/Course/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCourseId(@PathVariable Long id) throws Exception {
        courseService.deleteCourse(id);
    }

    @PutMapping("/Course/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCourse(@PathVariable Long id,  @RequestBody CourseRequest courseRequest) throws Exception {
        Course course = new Course(courseRequest.getCreatorId(), courseRequest.getTitle(), courseRequest.getDescription(), courseRequest.getLink(), courseRequest.getPicture());
        courseService.updateCourse(id, course);
    }

    @PostMapping("/Courses")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewCourse(@RequestBody CourseRequest courseRequest){
        Course course = new Course(courseRequest.getCreatorId(), courseRequest.getTitle(), courseRequest.getDescription(), courseRequest.getLink(), courseRequest.getPicture());
        courseService.createNewCourse(course);
    }

}
