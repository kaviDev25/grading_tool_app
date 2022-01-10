package com.assesment.grading_tool.service;


import com.assesment.grading_tool.model.Submissions;
import com.assesment.grading_tool.repository.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class SubmissionService {

    private SubmissionRepo submissionRepo;

    @Autowired
    public SubmissionService(SubmissionRepo submissionRepo) {
        this.submissionRepo = submissionRepo;
    }

    public List<Submissions> getSubmissionsOfStudents() {
        return submissionRepo.findAll();
    }
}
