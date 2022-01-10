package com.assesment.grading_tool.service;

import com.assesment.grading_tool.model.Assignment;
import com.assesment.grading_tool.repository.AssignmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AssignmentService {

    private AssignmentRepo repo;

    @Autowired
    public AssignmentService(AssignmentRepo repo) {
        this.repo = repo;
    }

    public List<Assignment> getAllAssignemnts()
    {
        return repo.findAll();
    }
}
