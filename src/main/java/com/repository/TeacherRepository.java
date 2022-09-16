package com.repository;

import com.model.Teacher;
import config.HibernateFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

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
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Teacher> teachers = session.createQuery("from Teacher where name = :name or surname = :name")
                    .setParameter("name", name)
                    .list();
            transaction.commit();
            return teachers;
        }
    }

//    public Teacher getTeacher(String name) {
//        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Optional<Teacher> teacher = session.createQuery(
//                        "from Teacher where name = :name", Teacher.class)
//                .setParameter("name", name)
//                .uniqueResultOptional();
////        if (teacher.isEmpty()) {
////            return getTeacherBySurname(name);
////        }
//        session.close();
//        return teacher.get();
//    }

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
