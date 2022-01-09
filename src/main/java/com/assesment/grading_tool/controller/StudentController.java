package com.assesment.grading_tool.controller;

import com.assesment.grading_tool.model.Student;
import com.assesment.grading_tool.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) { this.studentService = studentService; }

    @GetMapping("allStudents")
    public ResponseEntity<List<Student>> getAll(){

        List<Student> allStudents = studentService.getAllStudents();

        if(allStudents.isEmpty())
        {
            return new ResponseEntity<>(allStudents,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }
}
