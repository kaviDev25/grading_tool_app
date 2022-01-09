package com.assesment.grading_tool.repository;

import com.assesment.grading_tool.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepo extends JpaRepository<Question,Long> {
}
