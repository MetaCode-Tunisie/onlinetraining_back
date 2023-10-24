package com.example.exam_microservice.Services;

import com.example.exam_microservice.Entities.Exam;

import java.util.List;

public interface IServiceExam {
    Exam addExam(Exam examDto);
    Exam updateExam(Long id, Exam examDto);

    Boolean deleteExam(Long idExam);
    List<Exam> getAll();
}
