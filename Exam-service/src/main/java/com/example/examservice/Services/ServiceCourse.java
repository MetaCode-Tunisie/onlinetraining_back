package com.example.examservice.Services;

import com.example.examservice.Entities.Course;
import com.example.examservice.Entities.Exam;
import com.example.examservice.Repository.CourseRepository;
import com.example.examservice.Repository.ExamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service @AllArgsConstructor
public class ServiceCourse implements IServiceCourse{

    CourseRepository courseRepository;
    ExamRepository examRepository;
    @Override
    public Course addCours(Long idExam,Course course)
    {
        Exam exam = examRepository.findById(idExam).orElse(null);

        course.setExam(exam);
        return courseRepository.save(course);
    }

    @Override
    public Course updateCours(Course course) {
        return courseRepository.findById(course.getIdCourse())
                .map(course1 -> {
                    course1.setNbrChapter(course.getNbrChapter());
                    course1.setLesson(course.getLesson());
                    course1.setNbrHours(course.getNbrHours());

                    return courseRepository.save(course1);
                }).orElseThrow(() -> new RuntimeException("course not exist !"));
    }

    @Override
    public Boolean deleteCours(Long idCourse) {
        courseRepository.deleteById(idCourse);
        return true;
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public  List<Course> getAllByExam(Long idExam){
        List<Course> courses = new ArrayList<>();
            for (Course course:courseRepository.findCourseByExamIdExam(idExam))
            {
                courses.add(course);
            }
        return courses;
    }

    @Override
    public Course coursebyid(Long idCourse){
        return courseRepository.findById(idCourse).orElse(null);
    }
}
