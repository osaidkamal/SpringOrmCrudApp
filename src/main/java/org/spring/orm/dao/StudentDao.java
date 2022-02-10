package org.spring.orm.dao;

import org.spring.orm.entity.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;

    //Create Data in database;
    @Transactional
    public int insert(Student student) {
        int r = (int) this.hibernateTemplate.save(student);
        return r;
    }

    //Get Single data from database
    public Student getStudent(int studentId) {
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        return student;
    }

    //Get Multiple data from database;
    public List<Student> getAllStudents() {
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

    //Delete data
    @Transactional
    public void deleteStudent(int studentId) {
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        this.hibernateTemplate.delete(student);
//        return student;
    }

    //Update data
    @Transactional
    public void updateStudent(Student student) {
        this.hibernateTemplate.saveOrUpdate(student);


    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
