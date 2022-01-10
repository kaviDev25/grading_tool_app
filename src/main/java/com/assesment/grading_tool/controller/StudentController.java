package com.assesment.grading_tool.controller;

import com.assesment.grading_tool.model.Assignment;
import com.assesment.grading_tool.model.Course;
import com.assesment.grading_tool.model.Submissions;
import com.assesment.grading_tool.service.AssignmentService;
import com.assesment.grading_tool.service.CourseService;
import com.assesment.grading_tool.service.StudentService;
import com.assesment.grading_tool.service.SubmissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final SubmissionService service;
    private final StudentService studentService;
    private final CourseService courseService;
    private final AssignmentService assignmentService;

    public StudentController(SubmissionService service, StudentService studentService, CourseService courseService, AssignmentService assignmentService) {
        this.service = service;
        this.studentService = studentService;
        this.courseService = courseService;
        this.assignmentService = assignmentService;
    }



    /**
     * For a student below API Shows his/her all submissions for each assignment with the Course Key Name, Assignment, Submitted answer, result, time spent
     * Assume that studentId is abstract by the tool when they log In
     * @param studentId
     * @return
     */

    @GetMapping("allDetails/{studentId}")
    public ResponseEntity<List<Submissions>> ViewAllDetailsofOneStudent(@PathVariable ("studentId") int studentId){

        List<Submissions> submissions = service.getSubmissionsOfStudents();
        List<Course> courses = courseService.getAllCourses();
        List<Assignment> assignments = assignmentService.getAllAssignemnts();
        List<Submissions> sortedResults = new ArrayList<>();
        String courseKey = " ";
        String topic = " ";
        int k,l;

        try{
            for(int i = 0; i < submissions.size(); i++)
            {
                Submissions s = submissions.get(i);

                if(s.getStudentId() == studentId) {

                    for (k = 0; k < courses.size(); k++) {
                        Course c = courses.get(k);
                        if (s.getCourseId() == c.getId()) {
                            courseKey = c.getKeyName();
                        }
                    }
                    for (l = 0; l < assignments.size(); l++)
                    {
                        Assignment a = assignments.get(l);
                        if(s.getAssignmentId() == a.getId())
                        {
                            topic = a.getTopic();
                        }
                    }
                }

                Submissions sorted = new Submissions(courseKey,topic,s.getQuestionId(),s.getQuestionAns(),s.getResult(),s.getTime());
                sortedResults.add(sorted);
            }

        }
        catch (Exception e)
        {
            System.out.println(e + "issue occured");
        }

        return new ResponseEntity<>(sortedResults, HttpStatus.OK);
    }
}
