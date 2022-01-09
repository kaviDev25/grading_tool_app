package com.assesment.grading_tool.repository;

import com.assesment.grading_tool.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepo extends JpaRepository<Assignment,Long> {
}
