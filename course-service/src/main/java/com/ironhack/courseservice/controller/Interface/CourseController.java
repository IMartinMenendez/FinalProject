package com.ironhack.courseservice.controller.Interface;

import com.ironhack.common.dto.course.CourseRequest;
import com.ironhack.common.dto.course.CourseResponse;
import java.util.List;

public interface CourseController {

    List<CourseResponse> getAllCourses();

    CourseResponse getCourseById( Long id) throws Exception;

    List<CourseResponse> getCourseByUserId( Long userId);

    void deleteCourseId( Long id) throws Exception;

    void updateCourse( Long id,   CourseRequest courseRequest) throws Exception;

    void createNewCourse( CourseRequest courseRequest);
}
