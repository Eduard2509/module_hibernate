package com.repository;

import com.model.Teacher;
import config.HibernateFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TeacherRepository {

    private static TeacherRepository instance;

    public static TeacherRepository getInstance() {
        if (instance == null) {
            instance = new TeacherRepository();
        }
        return instance;
    }


    public List<Teacher> getTeacher(String name) {
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Teacher> teachers = session.createQuery("from Teacher where name = :name or surname = :name")
                    .setParameter("name", name)
                    .list();
            transaction.commit();
            return teachers;
        }
    }

    public boolean save(Teacher teacher) {
        if (teacher == null) {
            throw new IllegalArgumentException("Teacher must not be null");
        }
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(teacher);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return true;
    }

}
