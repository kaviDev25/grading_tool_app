package com.assesment.grading_tool.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String keyName;
    @Column(nullable = false)
    private String courseName;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();


    public Course(Long id, String keyName, String courseName) {
        this.id = id;
        this.keyName = keyName;
        this.courseName = courseName;
        //this.noOfStudents = noOfStudents;
    }

    public Course(String courseName, String keyName) {
        this.keyName = keyName;
        this.courseName = courseName;
    }

    public Course() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

//    //public Set<Student> getNoOfStudents() {
//        return noOfStudents;
//    }

//    public void setNoOfStudents(Set<Student> noOfStudents) {
//        this.noOfStudents = noOfStudents;
//    }

    public String getKeyName() {return keyName;}

    public void setKeyName(String keyName) {this.keyName = keyName;}

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", keyName='" + keyName + '\'' +
                ", courseName='" + courseName + '\'' +
                //", noOfStudents=" + noOfStudents +
                '}';
    }
}
