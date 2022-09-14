package com.repository;

import com.model.Grade;
import com.model.Student;
import com.model.Subject;
import config.HibernateFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.*;

public class SubjectRepository {

    private static SubjectRepository instance;

    public static SubjectRepository getInstance() {
        if (instance == null) {
            instance = new SubjectRepository();
        }
        return instance;
    }

    public boolean save(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject must not be null");
        }
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(subject);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public boolean update(Subject subject) {
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(subject);
        session.getTransaction().commit();
        session.close();
        return true;
    }
    public Map getSubjectWithLargestGrade() {
        SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("SELECT Subject.name , MAX(Grade.value)" +
                " FROM Grade , Subject group by subject.name");
        List<Object[]> list = query.getResultList();
        Map<String, Double> grouped = new HashMap<>();
        list.forEach(item -> grouped.put((String) item[0], Double.valueOf(item[1].toString())));
        transaction.commit();
        session.close();
        return grouped;
    }

    public Map getSubjectWithLowestGrade() {
        SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("SELECT Subject.name , MIN (Grade.value)" +
                " FROM Grade, Subject group by subject.name");
        List<Object[]> list = query.getResultList();
        Map<String, Double> grouped = new HashMap<>();
        list.forEach(item -> grouped.put((String) item[0], Double.valueOf(item[1].toString())));
        transaction.commit();
        session.close();
        return grouped;
    }
}
