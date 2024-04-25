package com.ramadan.tut.springboot.cruddemo.dao;

import java.util.List;

import com.ramadan.tut.springboot.cruddemo.entity.Student;

public interface StudentDAO {
    public void save(Student student);

    public Student findById(Long id);

    public List<Student> findAll();

    public List<Student> findByEmailDomain(String emailDomain);

    public void update(Student student);

    public void delete(Long id);

    public int deleteAll();
}
