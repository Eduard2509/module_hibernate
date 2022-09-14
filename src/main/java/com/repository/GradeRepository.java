package com.repository;

import com.model.Grade;
import com.model.GroupStudents;
import config.HibernateFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GradeRepository {

    private static GradeRepository instance;

    public static GradeRepository getInstance() {
        if (instance == null) {
            instance = new GradeRepository();
        }
        return instance;
    }

    public boolean save(Grade grade) {
        if (grade == null) {
            throw new IllegalArgumentException("Grade must not be null");
        }
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(grade);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public boolean update(Grade grade) {
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(grade);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
