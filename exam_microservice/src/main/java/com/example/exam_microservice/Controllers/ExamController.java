package com.example.exam_microservice.Controllers;

import com.example.exam_microservice.Entities.Course;
import com.example.exam_microservice.Entities.Exam;
import com.example.exam_microservice.Services.IServiceCourse;
import com.example.exam_microservice.Services.IServiceExam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Exam") @AllArgsConstructor
public class ExamController {
    IServiceCourse iServiceCourse;
    IServiceExam iServiceExam;

    // **************************  Course ********************************

    @GetMapping("/listCourses/{id}")
    public List<Course> ListCours (@PathVariable Long id){
        return iServiceCourse.getAllByExam(id);
    }

    @PostMapping("/addCourse/{id}")
    public Course addCourse(@PathVariable Long id,@RequestBody Course courseDto){
        return iServiceCourse.addCours(id,courseDto);
    }

    @PutMapping("/updateCourse/{id}")
    public Course updateCourse(@PathVariable Long id , @RequestBody Course courseDto){
        return iServiceCourse.updateCours(courseDto);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public Boolean deleteCourse(@PathVariable Long id)
    {
        return iServiceCourse.deleteCours(id);
    }


    @GetMapping("/coursebyid/{id}")
    public Course coursebyid(@PathVariable Long id){
        return iServiceCourse.coursebyid(id);
    }

    // **************************  Exam ********************************

    @PostMapping("/addExam")
    public Exam addExam(@RequestBody Exam examDto){return  iServiceExam.addExam(examDto); }

    @PutMapping("/updateExam/{id}")
    public Exam updateExam(@PathVariable Long id,@RequestBody Exam examDto){return iServiceExam.updateExam(id,examDto);}
    @DeleteMapping("/deleteExam/{id}")
    public Boolean deleteExam(@PathVariable Long id){return iServiceExam.deleteExam(id);}

    @GetMapping("/listExams")
    public List<Exam> listExams(){return iServiceExam.getAll();}


}
