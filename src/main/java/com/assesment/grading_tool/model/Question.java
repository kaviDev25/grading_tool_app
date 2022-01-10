package com.assesment.grading_tool.model;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", nullable = false)
    private int questionId;
    @Column(nullable = false)
    private String question;
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
    double averageTime;
    int averageCorrect, averageIncorrect;
    //... 1..* questions in an assignment. So, in question entity side it should be Many to One
    @ManyToOne
    @JoinColumns(
            {@JoinColumn(name = "assignment_id", referencedColumnName = "assignmentId")})
    private Assignment assignment;



    public Question(String question ,double totalTimeSpentInHrs, int totalSubmissions, int totalCorrectAnswers, int totalIncorrectAnswers, int totalPartialAnswers, Assignment assignment,int courseId) {
        this.question = question;
        this.totalTimeSpentInHrs = totalTimeSpentInHrs;
        this.totalSubmissions = totalSubmissions;
        this.totalCorrectAnswers = totalCorrectAnswers;
        this.totalIncorrectAnswers = totalIncorrectAnswers;
        this.totalPartialAnswers = totalPartialAnswers;
        this.assignment = assignment;
        this.courseId = courseId;
    }

    public Question(int questionId, String question, double averageTime, int averageCorrect, int averageIncorrect) {
        this.questionId = questionId;
        this.question = question;
        this.averageTime = averageTime;
        this.averageCorrect = averageCorrect;
        this.averageIncorrect = averageIncorrect;
    }

    public Question() {

    }

    public int getCourseId() {return courseId;}

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getQuestionId() {return questionId;}

    public void setQuestionId(int questionId) {this.questionId = questionId;}

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

    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", averageTime=" + averageTime +
                ", averageCorrect=" + averageCorrect +
                ", averageIncorrect=" + averageIncorrect +
                '}';
    }
}
