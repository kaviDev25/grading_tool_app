package com.assesment.grading_tool;

import com.assesment.grading_tool.model.Course;
import com.assesment.grading_tool.model.Student;
import com.assesment.grading_tool.repository.CourseRepo;
import com.assesment.grading_tool.repository.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class GradingToolApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(GradingToolApplication.class, args);

		StudentRepo studentRepo =
				configurableApplicationContext.getBean(StudentRepo.class);

		CourseRepo courseRepo =
				configurableApplicationContext.getBean(CourseRepo.class);

		Course course = new Course("IT2030","Software Engineering");
		Course course1 = new Course("IT2050","DBMS");
		List<Course> courses =Arrays.asList(course,course1);

		Student student = new Student("Merry John");
		Student student1 = new Student("Amal Perera");
		List<Student> students = Arrays.asList(student,student1);

		courseRepo.saveAll(courses);

		student.addCourse(course);
		student.addCourse(course1);
		student1.addCourse(course1);

		studentRepo.saveAll(students);
	}
	}

