package com.assesment.grading_tool.service;

import com.assesment.grading_tool.model.Course;
import com.assesment.grading_tool.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CourseService {

    private CourseRepo courseRepo;

    @Autowired
    public CourseService(CourseRepo courseRepo) { this.courseRepo = courseRepo;}

    public Course addCourse(Course course)
    {
        return courseRepo.save(course);
    }

    public List<Course> getAllCourses()
    {
        return courseRepo.findAll();
    }
}
