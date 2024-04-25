package com.ramadan.tut.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramadan.tut.springboot.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName", Student.class);
        
        return query.getResultList();
    }

    @Override
    public List<Student> findByEmailDomain(String emailDomain) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE email LIKE :emailDomain ORDER BY lastName", Student.class);

        query.setParameter("emailDomain", "%" + emailDomain);
        
        return query.getResultList();
    }
}
