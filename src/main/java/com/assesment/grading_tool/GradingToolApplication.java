package com.assesment.grading_tool;

import com.assesment.grading_tool.model.*;
import com.assesment.grading_tool.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
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

		AssignmentRepo assignmentRepo =
				configurableApplicationContext.getBean(AssignmentRepo.class);

		QuestionsRepo questionsRepo =
				configurableApplicationContext.getBean(QuestionsRepo.class);

		SubmissionRepo submissionRepo =
				configurableApplicationContext.getBean(SubmissionRepo.class);

		Course course = new Course("Software Engineering","IT2030");
		Course course1 = new Course("DBMS","IT2050");
		List<Course> courses =Arrays.asList(course,course1);

		Student student = new Student("Merry John");
		Student student1 = new Student("Amal Perera");
		List<Student> students = Arrays.asList(student,student1);

		courseRepo.saveAll(courses);

		student.addCourse(course);
		student.addCourse(course1);
		student1.addCourse(course1);

		studentRepo.saveAll(students);

		Assignment assignment_SE = new Assignment("Physical Diagrams",course);
		Assignment assignment1_SE = new Assignment("Class Diagrams",course);
		Assignment assignment_DB = new Assignment("Functions & Procedures",course1);
		Assignment assignment1_DB = new Assignment("Design a Database",course1);
		List<Assignment> assignments = Arrays.asList(assignment_SE,assignment1_SE);
		List<Assignment> assignments1 = Arrays.asList(assignment_DB,assignment1_DB);

		course.setAssignments(assignments);
		course1.setAssignments(assignments1);

		assignmentRepo.saveAll(assignments);
		assignmentRepo.saveAll(assignments1);

		Question question = new Question(15.25,17,9,3,5,assignment_SE);
		Question question1 = new Question(20.37,21,10,8,3,assignment_DB);
		List<Question> questions = Arrays.asList(question,question1);

		questionsRepo.saveAll(questions);

		Submissions submission = new Submissions(1,2,1,1,
				"A database management system (DBMS) is system software for creating and managing databases. " +
						"A DBMS makes it possible for end users to create, protect, read, update and delete data in a database.",
				"correct");

		Submissions submission1 = new Submissions(2,2,1,1,
				"A database management system (DBMS) is system software for creating and managing databases. " ,
				"partial");

		List<Submissions> submissions = Arrays.asList(submission,submission1);
		submissionRepo.saveAll(submissions);

	}
}

