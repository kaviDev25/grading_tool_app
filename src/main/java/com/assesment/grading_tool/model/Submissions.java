package com.assesment.grading_tool.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Submissions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "submission_id", nullable = false)
    private Long submissionId;
    @Column(nullable = false)
    private Long studentId;
    @Column(nullable = false)
    private Long courseId;
    @Column(nullable = false)
    private Long assignmentId;
    @Column
    private Long questionId;
    @Column
    private String questionAns;
    @Column
    private String result;
    @Column
    private int time;
    private String courseKey,topic;






    public Submissions(long studentId, long courseId, long assignmentId, long questionId, String questionAns, String result,int time) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.assignmentId = assignmentId;
        this.questionId = questionId;
        this.questionAns = questionAns;
        this.result = result;
        this.time = time;
    }

    public Submissions(Long studentId, Long assignmentId, String topic,Long questionId, String result){
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.questionId = questionId;
        this.result = result;
        this.topic = topic;
    }

    public Submissions(String courseKey, String topic, long questionId, String questionAns, String result, int time) {
        this.questionId = questionId;
        this.questionAns = questionAns;
        this.result = result;
        this.time = time;
        this.courseKey = courseKey;
        this.topic = topic;
    }

    public Submissions() {

    }

    public Long getSubmissionId() {return submissionId;}

    public void setSubmissionId(Long submissionId) {this.submissionId = submissionId;}

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

    public int getTime() {return time;}

    public void setTime(int time) {this.time = time;}

    public String getTopic() {
        return topic;
    }

//    @Override
//    public String toString() {
//        return "Student Submissions{" +
//                ", courseKey='" + courseKey + '\'' +
//                ", topic='" + topic + '\'' +
//                "assignmentId=" + assignmentId +
//                ", questionId=" + questionId +
//                ", questionAns='" + questionAns + '\'' +
//                ", result='" + result + '\'' +
//                ", time=" + time +
//                '}';
//    }
}
