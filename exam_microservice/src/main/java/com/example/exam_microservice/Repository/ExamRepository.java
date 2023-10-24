package com.example.exam_microservice.Repository;

import com.example.exam_microservice.Entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam,Long> {
}
