package com.example.examservice.Services;

import com.example.examservice.Entities.Exam;

import java.util.List;

public interface IServiceExam {
    Exam addExam(Exam examDto);
    Exam updateExam(Long id, Exam examDto);

    Boolean deleteExam(Long idExam);
    List<Exam> getAll();
}
