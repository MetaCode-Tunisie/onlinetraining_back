package com.example.examservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExamDto {
    Long idExam;
    int note;
    String description;
    String title;
    int duration;
    String link;
}
