package com.ironhack.courseservice.services.Interfaces;


import com.ironhack.courseservice.controller.dto.CourseResponse;
import com.ironhack.courseservice.model.Course;
import com.ironhack.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<CourseResponse> getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course : courses) {
            new CourseResponse(course.getCreatorId(), course.getTitle(), course.getDescription(), course.getLink(), course.getPicture());
        }
        return courseResponses;
    }

    public CourseResponse getCourseById(Long id) throws Exception {
        Optional<Course> maybeCourse = courseRepository.findById(id);
        if(maybeCourse.isEmpty()){
            throw new Exception("No Event found");
        }
        return new CourseResponse(maybeCourse.get().getCreatorId(), maybeCourse.get().getTitle(), maybeCourse.get().getDescription(), maybeCourse.get().getLink(), maybeCourse.get().getPicture());

    }
}
