package com.assesment.grading_tool.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignmentId", nullable = false)
    private Long assignmentId;
    @Column(nullable = false)
    private String topic;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(
            mappedBy = "assignment",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

    public Assignment(String topic, Course course) {
        this.topic = topic;
        this.course = course;
    }

    public Assignment() {
    }

    public Long getId() {return assignmentId;}

    public void setId(Long assignmentId) {this.assignmentId = assignmentId;}

    public String getTopic() {return topic;}

    public void setTopic(String topic) {this.topic = topic;}

    public Course getCourse() {return course;}

    public void setCourse(Course course) {this.course = course;}
}
