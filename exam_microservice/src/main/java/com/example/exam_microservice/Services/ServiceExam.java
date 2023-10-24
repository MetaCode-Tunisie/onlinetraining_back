package com.example.exam_microservice.Services;

import com.example.exam_microservice.Entities.Exam;
import com.example.exam_microservice.Repository.ExamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class ServiceExam implements IServiceExam{

    ExamRepository examRepository;
    @Override
    public Exam addExam(Exam examDto) {
        return examRepository.save(examDto);
    }

    @Override
    public Exam updateExam(Long id, Exam examDto) {
        return null;
    }

    @Override
    public Boolean deleteExam(Long idExam) {
         examRepository.deleteById(idExam);
         return true;
    }

    @Override
    public List<Exam> getAll() {
        return examRepository.findAll();
    }
}
