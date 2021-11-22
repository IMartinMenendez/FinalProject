package com.ironhack.courseservice.services.Impl;


import com.ironhack.courseservice.model.Course;
import com.ironhack.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);

    }

    public List<Course> getCourseByUserId(Long id){
        return courseRepository.getCourseByUserId(id);
    }

    public void deleteCourse(Long id) throws Exception {
        Optional<Course> maybeCourse = courseRepository.findById(id);
        if(maybeCourse.isEmpty()){
            throw new Exception("No Event found");
        }
        courseRepository.delete(maybeCourse.get());
    }

    public void updateCourse(Long id, Course course) throws Exception {
        Optional<Course> maybeCourse = courseRepository.findById(id);
        if(maybeCourse.isEmpty()){
            throw new Exception("No Course found");
        }
        maybeCourse.get().setCreatorId(course.getCreatorId());
        maybeCourse.get().setLink(course.getLink());
        maybeCourse.get().setPicture(course.getPicture());
        maybeCourse.get().setTitle(course.getTitle());
        maybeCourse.get().setDescription(course.getDescription());
        courseRepository.save(maybeCourse.get());
    }

    public void createNewCourse(Course course){
        courseRepository.save(course);
    }
}
