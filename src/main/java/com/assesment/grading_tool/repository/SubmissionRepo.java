package com.assesment.grading_tool.repository;

import com.assesment.grading_tool.model.Submissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepo extends JpaRepository<Submissions,Long> {
}
