package com.assesment.grading_tool.controller;

import com.assesment.grading_tool.model.Question;
import com.assesment.grading_tool.model.Submissions;
import com.assesment.grading_tool.service.CourseService;
import com.assesment.grading_tool.service.QuestionService;
import com.assesment.grading_tool.service.SubmissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherViewController {

    private final CourseService courseService;
    private final SubmissionService submissionService;
    private final QuestionService questionService;

    public TeacherViewController(CourseService courseService, SubmissionService submissionService, QuestionService questionService) {
        this.courseService = courseService;
        this.submissionService = submissionService;
        this.questionService = questionService;
    }



    /**
     * Techer View
     * Overall Grade of assignment per course API
     */

    @GetMapping("/overallGrade/{courseId}")
    public ResponseEntity<List<Submissions>> ViewGradesOfCourse(@PathVariable("courseId") int courseId)
    {
        List<Submissions> s = submissionService.getSubmissionsOfStudents();
        List<Submissions> sortedAssignments = new ArrayList<>();
        Submissions allSubmissions = new Submissions();

        try {

            for (int i = 0; i < s.size(); i++) {
                Submissions sb = s.get(i);

                if (sb.getCourseId() == courseId) {
                    allSubmissions = new Submissions(sb.getStudentId(), sb.getAssignmentId(), sb.getTopic(), sb.getQuestionId(), sb.getResult());
                }

                sortedAssignments.add(allSubmissions);
            }
        }
        catch (Exception e)
        {
            System.out.println(e + " " + "occurred");
        }

        return new ResponseEntity<>(sortedAssignments, HttpStatus.OK);
    }


    /**
     * Teacher View
     * Statistics for each question
     */

    @GetMapping("/statistics")
    public ResponseEntity<List<Question>> ViewStatisticsPerQuestion()
    {
        List<Question> questions = questionService.getAllQuestions();
        double averageTime = 0;
        int averageCorrect,averageIncorrect = 0;
        List<Question> statistics = new ArrayList<>();
        int qid;
        String qName;
        Question stat;

        try {

            for (int i = 0; i < questions.size(); i++) {
                qid = questions.get(i).getQuestionId();
                qName = questions.get(i).getQuestion();
                averageTime = questions.get(i).getTotalTimeSpentInHrs() / questions.get(i).getTotalSubmissions();
                averageCorrect = questions.get(i).getTotalCorrectAnswers() / questions.get(i).getTotalSubmissions();
                averageIncorrect = questions.get(i).getTotalIncorrectAnswers() / questions.get(i).getTotalSubmissions();

                stat = new Question(qid, qName, averageTime, averageCorrect, averageIncorrect);
                statistics.add(stat);

            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }
}
