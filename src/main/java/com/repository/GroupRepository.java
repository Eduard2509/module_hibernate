package com.repository;

import com.model.GroupStudents;
import config.HibernateFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupRepository {

    private static GroupRepository instance;

    public static GroupRepository getInstance() {
        if (instance == null) {
            instance = new GroupRepository();
        }
        return instance;
    }

    public List findGroupByName(String name) {
        SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List resultList = session.createQuery(
                        "from GroupStudents where name like :name")
                .setParameter("name", "%" + name + "%")
                .getResultList();
        session.close();
        return resultList;
    }


    public Map getAverageGradeGroup() {
        SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select s.group.name, avg(g.value) " +
                "from Student as s join Grade as g on g.student.id = s.id " +
                "group by s.group.name");
        List<Object[]> list = query.getResultList();
        Map<String, Double> grouped = new HashMap<>();
        list.forEach(item -> grouped.put((String) item[0], Double.valueOf(item[1].toString())));
        transaction.commit();
        session.close();
        return grouped;
    }

    public boolean save(GroupStudents group) {
        if (group == null) {
            throw new IllegalArgumentException("GroupStudents must not be null");
        }
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(group);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
