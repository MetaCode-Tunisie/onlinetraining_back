package com.example.exam_microservice.Repository;

import com.example.exam_microservice.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findCourseByExamIdExam(Long idExam);
}
