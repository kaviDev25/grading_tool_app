package com.assesment.grading_tool.service;

import com.assesment.grading_tool.model.Student;
import com.assesment.grading_tool.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class StudentService {

    StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) { this.studentRepo = studentRepo;}

    public Student addStudent(Student student)
    {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents()
    {
        return studentRepo.findAll();
    }
}
