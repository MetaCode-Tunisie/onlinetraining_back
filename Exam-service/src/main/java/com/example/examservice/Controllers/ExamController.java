package com.example.examservice.Controllers;

import com.example.examservice.Entities.Course;
import com.example.examservice.Entities.Exam;
import com.example.examservice.Services.IServiceCourse;
import com.example.examservice.Services.IServiceExam;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ExamController {
    IServiceCourse iServiceCourse;
    IServiceExam iServiceExam;

    // **************************  Course ********************************

    @GetMapping("/user/listCourses/{id}")
    public List<Course> ListCours (@PathVariable Long id){
        return iServiceCourse.getAllByExam(id);
    }

    @PostMapping("/admin/addCourse/{id}")
    public Course addCourse(@PathVariable Long id,@RequestBody Course courseDto){
        return iServiceCourse.addCours(id,courseDto);
    }

    @PutMapping("/admin/updateCourse/{id}")
    public Course updateCourse(@PathVariable Long id , @RequestBody Course courseDto){
        return iServiceCourse.updateCours(courseDto);
    }

    @DeleteMapping("/admin/deleteCourse/{id}")
    public Boolean deleteCourse(@PathVariable Long id)
    {
        return iServiceCourse.deleteCours(id);
    }


    @GetMapping("/user/coursebyid/{id}")
    public Course coursebyid(@PathVariable Long id){
        return iServiceCourse.coursebyid(id);
    }

    // **************************  Exam ********************************

    @PostMapping("/admin/addExam")
    public Exam addExam(@RequestBody Exam examDto){return  iServiceExam.addExam(examDto); }

    @PutMapping("/admin/updateExam/{id}")
    public Exam updateExam(@PathVariable Long id,@RequestBody Exam examDto){return iServiceExam.updateExam(id,examDto);}

    @DeleteMapping("/admin/deleteExam/{id}")
    public Boolean deleteExam(@PathVariable Long id){return iServiceExam.deleteExam(id);}

    @GetMapping("/user/listExams")
    public List<Exam> listExams(){return iServiceExam.getAll();}


}
