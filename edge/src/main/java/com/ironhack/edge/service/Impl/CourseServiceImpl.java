package com.ironhack.edge.service.Impl;

import com.ironhack.common.dto.course.CourseRequest;
import com.ironhack.common.dto.course.CourseResponse;
import com.ironhack.edge.clients.CourseClient;
import com.ironhack.edge.clients.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl {

    @Autowired
    private CourseClient courseClient;

    @Autowired
    UserClient authorSessionClient;

    public List<CourseResponse> getAllCourses(){
       return courseClient.getAllCourses();
    }

    public CourseResponse getCourseById(Long id) throws Exception{
        return courseClient.getCourseById(id);
    }

    public List<CourseResponse> getCourseByUserId(Long userId, String token) throws Exception {
        Long maybeUser = authorSessionClient.getUserIdByToken(token);
        if( maybeUser.equals(userId)){
            return courseClient.getCourseByUserId(userId);
        }else{
            throw new Exception("User not authenticated");
        }
    }

    public void deleteCourseId(Long id) throws Exception{
        courseClient.deleteCourseId(id);
    }

    public void updateCourse(Long id, CourseRequest courseRequest) throws Exception{
        courseClient.updateCourse(id, courseRequest);
    }

    public void createNewCourse( CourseRequest courseRequest){
        courseClient.createNewCourse(courseRequest);
    }

}
