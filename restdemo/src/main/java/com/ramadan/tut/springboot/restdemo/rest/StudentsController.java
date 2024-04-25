package com.ramadan.tut.springboot.restdemo.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramadan.tut.springboot.restdemo.entity.Student;
import com.ramadan.tut.springboot.restdemo.error.StudentErrorResponse;
import com.ramadan.tut.springboot.restdemo.error.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
    private List<Student> students;

    @PostConstruct
    public void initializeData() {
        students = List.of(
            new Student("Kareem", "Salayma"),
            new Student("Ramadan", "Jaafari")
        );
    }

    @GetMapping("/")
    public List<Student> getStudents() {
        return this.students;
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        studentId -= 1;
        if(studentId < 0 || studentId >= this.students.size()) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return this.students.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> HandleException(StudentNotFoundException exc) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus((HttpStatus.NOT_FOUND.value()));
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus((HttpStatus.BAD_REQUEST.value()));
        error.setMessage("Received invalid data type!");
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
