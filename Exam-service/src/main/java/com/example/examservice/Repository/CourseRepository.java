package com.example.examservice.Repository;

import com.example.examservice.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findCourseByExamIdExam(Long idExam);
}
