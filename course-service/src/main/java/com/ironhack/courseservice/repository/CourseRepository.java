package com.ironhack.courseservice.repository;

import com.ironhack.courseservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT e FROM Course e WHERE e.creatorId = :creatorId")
    List<Course> getCourseByUserId(@Param("creatorId") Long creatorId);
}
