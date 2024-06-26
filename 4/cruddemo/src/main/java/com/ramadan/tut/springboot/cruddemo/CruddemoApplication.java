package com.ramadan.tut.springboot.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ramadan.tut.springboot.cruddemo.dao.StudentDAO;
import com.ramadan.tut.springboot.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByEmailDomain(studentDAO, "gmail.com");

			// updateStudent(studentDAO, 1L, "Ahmad", "Tyson", "aaaa@gmail.com");
			// readStudent(studentDAO, 1L);

			// deleteStudent(studentDAO, 2L);

			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int deletedCount = studentDAO.deleteAll();
		System.out.println("All students were deleted(" + deletedCount + ")!");
	}

	private void deleteStudent(StudentDAO studentDAO, Long id) {
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO, Long id, String firstName, String lastName, String email) {
		Student student = studentDAO.findById(id);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);

		studentDAO.update(student);
	}

	private void queryForStudentsByEmailDomain(StudentDAO studentDAO, String emailDomain) {
		List<Student> students = studentDAO.findByEmailDomain(emailDomain);

		students.forEach(student -> System.out.println(student));
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		students.forEach(student -> System.out.println(student));
	}

	private void readStudent(StudentDAO studentDAO, Long id) {
		Student student = studentDAO.findById(id);

		System.out.println("Retreived Student: " + student);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating multiple student objects...");
		List<Student> students = List.of(
			new Student("Paul", "Doe", "paul@gmail.com"),
			new Student("Crayon", "Tyron", "crayon@gmail.com"),
			new Student("Sam", "Doe", "sam@hotmail.com"));

		System.out.println("Saving student to DB");
		students.forEach(student -> studentDAO.save(student));
		

		students.forEach(student -> System.out.println("Saved student, Generated id: " + student.getId()));
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student object...");
		Student student = new Student("Paul", "Doe", "paul@gmail.com");

		System.out.println("Saving student to DB");
		studentDAO.save(student);

		System.out.println("Saved student, Generated id: " + student.getId());
	}


}
