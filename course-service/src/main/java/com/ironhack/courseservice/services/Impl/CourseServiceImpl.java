package com.ironhack.courseservice.services.Impl;


import com.ironhack.courseservice.controller.dto.CourseRequest;
import com.ironhack.courseservice.controller.dto.CourseResponse;
import com.ironhack.courseservice.model.Course;
import com.ironhack.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl {

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

    public List<CourseResponse> getCourseByUserId(Long id){
        List<Course> courses = courseRepository.getCourseByUserId(id);
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course : courses) {
            new CourseResponse(course.getCreatorId(), course.getTitle(), course.getDescription(), course.getLink(), course.getPicture());
        }
        return courseResponses;
    }

    public void deleteCourse(Long id) throws Exception {
        Optional<Course> maybeCourse = courseRepository.findById(id);
        if(maybeCourse.isEmpty()){
            throw new Exception("No Event found");
        }
        courseRepository.delete(maybeCourse.get());
    }

    public void updateCourse(Long id, CourseRequest courseRequest) throws Exception {
        Optional<Course> maybeCourse = courseRepository.findById(id);
        if(maybeCourse.isEmpty()){
            throw new Exception("No Course found");
        }
        maybeCourse.get().setCreatorId(courseRequest.getCreatorId());
        maybeCourse.get().setLink(courseRequest.getLink());
        maybeCourse.get().setPicture(courseRequest.getPicture());
        maybeCourse.get().setTitle(courseRequest.getTitle());
        maybeCourse.get().setDescription(courseRequest.getDescription());
        courseRepository.save(maybeCourse.get());
    }

    public void createNewCourse(CourseRequest courseRequest){
        Course course = new Course(courseRequest.getCreatorId(), courseRequest.getTitle(), courseRequest.getDescription(), courseRequest.getLink(), courseRequest.getPicture());
        courseRepository.save(course);
    }
}
