package com.assesment.grading_tool.service;

import com.assesment.grading_tool.model.Course;
import com.assesment.grading_tool.model.Question;
import com.assesment.grading_tool.repository.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QuestionService {

    private QuestionsRepo questionsRepo;

    @Autowired
    public QuestionService(QuestionsRepo questionsRepo) {
        this.questionsRepo = questionsRepo;
    }

    public List<Question> getAllQuestions()
    {
        return questionsRepo.findAll();
    }
}
