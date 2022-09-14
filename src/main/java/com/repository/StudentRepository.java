package com.repository;

import com.model.GroupStudents;
import com.model.Student;
import config.HibernateFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.*;

public class StudentRepository {

    private static StudentRepository instance;

    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    public Map getCountStudentsInGroup() {
        SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query = session.createSQLQuery(
                "SELECT Groupstudents.name, COUNT (distinct Student.id)" +
                        " FROM groupstudents, Student WHERE Groupstudents.id = Student.group_id" +
                        " GROUP BY Groupstudents.name");
        List<Object[]> list = query.getResultList();
        Map<String, Integer> grouped = new HashMap<>();
        list.forEach(item -> grouped.put((String) item[0], Integer.valueOf(item[1].toString())));
        transaction.commit();
        session.close();
        return grouped;
    }

    public Map getStudentMoreAverageGrade(double averageGrade) {
        SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("SELECT Student.name, AVG(Grade.value) FROM Student, Grade " +
                "WHERE Grade.value > :averageGrade AND Grade.student_id = Student.id GROUP BY Student.name, Grade.value")
                .setParameter("averageGrade", averageGrade);
        List<Object[]> list = query.getResultList();
        Map<String, Double> grouped = new HashMap<>();
        list.forEach(item -> grouped.put((String) item[0], Double.valueOf(item[1].toString())));
        transaction.commit();
        session.close();
        return grouped;
    }

    public boolean save(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student must not be null");
        }
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public boolean update(Student student) {
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
        session.close();
        return true;
    }

}
