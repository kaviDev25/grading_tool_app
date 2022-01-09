package com.assesment.grading_tool.repository;

import com.assesment.grading_tool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
