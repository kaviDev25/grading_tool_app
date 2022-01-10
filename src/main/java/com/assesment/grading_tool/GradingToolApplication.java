package com.assesment.grading_tool;

import com.assesment.grading_tool.model.*;
import com.assesment.grading_tool.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import java.util.Arrays;
import java.util.List;

/**
 * Kavinsa Uthpali
 *
 * Assumptions made :-
 *
 * Students Questions, answers,no of attempts, time spent and etc. those informations are sent by a external tool to grading tool
 * There is a table called Submissions which send daily submissions to the grading tool of all students and all courses
 * There is a table called question. It has unique ID for a question with it's assignment ID, it's Course ID.
 * For the Question table : assumption is once a course is over that table is going to update after releasing the results to students.
 * When a course start to another batch teachers update question table
 * Below is a dummy data inserted to Assignment, Student, Question,Course,Submissions table to get the output of API's
 * Reason - Data come to grading tool from an external tool
 */


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


		//...Data to Course Table
		Course course = new Course("Software Engineering","IT2030");
		Course course1 = new Course("DBMS","IT2050");
		List<Course> courses =Arrays.asList(course,course1);

		//...Data to Student table
		Student student = new Student("Merry John");
		Student student1 = new Student("Amal Perera");
		List<Student> students = Arrays.asList(student,student1);

		courseRepo.saveAll(courses);

		//...add courses to students which the follow: because of the many to many relationship
		student.addCourse(course);
		student.addCourse(course1);
		student1.addCourse(course1);

		studentRepo.saveAll(students);

		//...Data to assignment table
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

		//...Data to Question table
		Question question = new Question("What is DBMS?",15.25,17,9,3,5,assignment_SE,1);
		Question question1 = new Question("What is a class diagram?",20.37,21,10,8,3,assignment_DB,2);
		List<Question> questions = Arrays.asList(question,question1);
		questionsRepo.saveAll(questions);


		//...Data to Submissions table
		Submissions submission = new Submissions(1,2,1,1,
				"A database management system (DBMS) is system software for creating and managing databases. " +
						"A DBMS makes it possible for end users to create, protect, read, update and delete data in a database.",
				"correct",45);

		Submissions submission1 = new Submissions(2,2,1,1,
				"A database management system (DBMS) is system software for creating and managing databases. " ,
				"partial",57);

		Submissions submission2 = new Submissions(2,1,1,1,
				"In software engineering, a class diagram in the Unified Modeling Language is a type of static structure diagram that describes the structure of a system by showing the system's classes, their attributes, operations, and the relationships among objects" ,
				"correct",60);

		List<Submissions> submissions = Arrays.asList(submission,submission1,submission2);
		submissionRepo.saveAll(submissions);

	}
}






