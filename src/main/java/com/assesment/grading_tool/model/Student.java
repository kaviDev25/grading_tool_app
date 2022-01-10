package com.assesment.grading_tool.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    //...Student follow 1..* Courses and Course is followed by many students. So, Many to Many relationship
    @ManyToMany
    @JoinTable(name = "student_courses" , joinColumns = @JoinColumn(name = "sid"), inverseJoinColumns = @JoinColumn(name = "cid"))
    private List<Course> courses = new ArrayList<>();


    public Student(String name) {
        this.name = name;
    }

    public Student(int id, String name, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public Student() {

    }

    public void addCourse(Course c)
    {
        courses.add(c);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getStudent() {
        return courses;
    }

    public void setStudent(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
