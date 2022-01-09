package com.assesment.grading_tool.repository;

import com.assesment.grading_tool.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {
}
