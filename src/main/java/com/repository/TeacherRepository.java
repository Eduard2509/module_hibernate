package com.repository;

import com.model.Teacher;
import config.HibernateFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class TeacherRepository {

    private static TeacherRepository instance;

    public static TeacherRepository getInstance() {
        if (instance == null) {
            instance = new TeacherRepository();
        }
        return instance;
    }

    public Teacher getTeacher(String name) {
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Optional<Teacher> teacher = session.createQuery(
                        "from Teacher as p where p.name = :name", Teacher.class)
                .setParameter("name", name)
                .uniqueResultOptional();
        session.close();
        if (teacher.isEmpty()) {
            return getTeacherBySurname(name);
        }
        return teacher.get();
    }

    public Teacher getTeacherBySurname(String name) {
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Optional<Teacher> teacherBySurname = session.createQuery(
                        "from Teacher as p where p.surname = :name", Teacher.class)
                .setParameter("name", name)
                .uniqueResultOptional();
        session.close();
        return teacherBySurname.get();
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

    public boolean update(Teacher teacher) {
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(teacher);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
