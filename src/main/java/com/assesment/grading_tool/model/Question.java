package com.assesment.grading_tool.model;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", nullable = false)
    private Long questionId;
    @Column(nullable = false)
    private double totalTimeSpentInHrs;
    @Column(nullable = false)
    private int totalSubmissions;
    @Column(nullable = false)
    private int totalCorrectAnswers;
    @Column(nullable = false)
    private int totalIncorrectAnswers;
    @Column(nullable = false)
    private int totalPartialAnswers;
    @Column(nullable = false)
    private int courseId;

    @ManyToOne
    @JoinColumns(
            {@JoinColumn(name = "assignment_id", referencedColumnName = "assignmentId")})
    private Assignment assignment;


    public Question(double totalTimeSpentInHrs, int totalSubmissions, int totalCorrectAnswers, int totalIncorrectAnswers, int totalPartialAnswers, Assignment assignment,int courseId) {
        this.totalTimeSpentInHrs = totalTimeSpentInHrs;
        this.totalSubmissions = totalSubmissions;
        this.totalCorrectAnswers = totalCorrectAnswers;
        this.totalIncorrectAnswers = totalIncorrectAnswers;
        this.totalPartialAnswers = totalPartialAnswers;
        this.assignment = assignment;
        this.courseId = courseId;
    }

    public Question() {

    }

    public int getCourseId() {return courseId;}

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Long getQuestionId() {return questionId;}

    public void setQuestionId(Long questionId) {this.questionId = questionId;}

    public double getTotalTimeSpentInHrs() {
        return totalTimeSpentInHrs;
    }

    public void setTotalTimeSpentInHrs(double totalTimeSpentInHrs) {
        this.totalTimeSpentInHrs = totalTimeSpentInHrs;
    }

    public int getTotalSubmissions() {return totalSubmissions;}

    public void setTotalSubmissions(int totalSubmissions) {this.totalSubmissions = totalSubmissions;}

    public int getTotalCorrectAnswers() {return totalCorrectAnswers;}

    public void setTotalCorrectAnswers(int totalCorrectAnswers) {this.totalCorrectAnswers = totalCorrectAnswers;}

    public int getTotalIncorrectAnswers() {return totalIncorrectAnswers;}

    public void setTotalIncorrectAnswers(int totalIncorrectAnswers) {this.totalIncorrectAnswers = totalIncorrectAnswers;}

    public int getTotalPartialAnswers() {return totalPartialAnswers;}

    public void setTotalPartialAnswers(int totalPartialAnswers) {this.totalPartialAnswers = totalPartialAnswers;}

    public Assignment getAssignment() {return assignment;}

    public void setAssignment(Assignment assignment) {this.assignment = assignment;}
}
