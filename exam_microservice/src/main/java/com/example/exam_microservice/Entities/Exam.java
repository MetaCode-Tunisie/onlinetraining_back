package com.example.exam_microservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Exam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idExam;
    int note;
    String description;
    String title;
    int duration;
    String link;


    @JsonIgnore
    @OneToMany(mappedBy ="exam")
    Set<Course> courses = new HashSet<>();
}
