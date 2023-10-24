package com.example.exam_microservice.Services;

import com.example.exam_microservice.Entities.Course;

import java.util.List;

public interface IServiceCourse {
    Course addCours(Long idExam,Course course);
    Course updateCours(Course course);

    Boolean deleteCours(Long idCourse);
    List<Course> getAll();

    List<Course> getAllByExam(Long idExam);

    Course coursebyid(Long idCourse);

}
