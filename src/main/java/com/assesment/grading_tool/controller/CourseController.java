package com.assesment.grading_tool.controller;

import com.assesment.grading_tool.model.Course;
import com.assesment.grading_tool.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {this.courseService = courseService;}


    @GetMapping("allCourses")
    public ResponseEntity<List<Course>> getAll(){

        List<Course> allCourses = courseService.getAllCourses();

        if(allCourses.isEmpty())
        {
            return new ResponseEntity<>(allCourses,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allCourses, HttpStatus.OK);
    }
}
