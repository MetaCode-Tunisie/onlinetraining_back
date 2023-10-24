package com.example.exam_microservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CourseDto {
    Long idCourse;
    String lesson;
    int nbrChapter;
    int nbrHours;


}
