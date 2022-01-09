package com.assesment.grading_tool.model;

import javax.persistence.*;

@Entity
public class Submissions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "submission_id", nullable = false)
    private long submissionId;
    @Column(nullable = false)
    private long studentId;
    @Column(nullable = false)
    private long courseId;
    @Column(nullable = false)
    private long assignmentId;
    @Column
    private long questionId;
    @Column
    private String questionAns;
    @Column
    private String result;


    public Submissions(long studentId, long courseId, long assignmentId, long questionId, String questionAns, String result) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.assignmentId = assignmentId;
        this.questionId = questionId;
        this.questionAns = questionAns;
        this.result = result;
    }

    public Submissions() {

    }

    public long getSubmissionId() {return submissionId;}

    public void setSubmissionId(long submissionId) {this.submissionId = submissionId;}

    public long getStudentId() {return studentId;}

    public void setStudentId(long studentId) {this.studentId = studentId;}

    public long getCourseId() {return courseId;}

    public void setCourseId(long courseId) {this.courseId = courseId;}

    public long getAssignmentId() {return assignmentId;}

    public void setAssignmentId(long assignmentId) {this.assignmentId = assignmentId;}

    public long getQuestionId() {return questionId;}

    public void setQuestionId(long questionId) {this.questionId = questionId;}

    public String getQuestionAns() {return questionAns;}

    public void setQuestionAns(String questionAns) {this.questionAns = questionAns;}

    public String getResult() {return result;}

    public void setResult(String result) {this.result = result;}
}
