package com.repository;

import com.model.Subject;
import config.HibernateFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

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

    public Map getSubjectWithLargestGrade() {
        SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select s, avg(g.value) as agv from Grade g " +
                "join g.subject s group by s order by agv desc");
        Object[] singleResult = (Object[]) query.setMaxResults(1).getSingleResult();
        Map<Subject, Double> grouped = new HashMap<>();
        grouped.put((Subject) singleResult[0], Double.valueOf(singleResult[1].toString()));
        transaction.commit();
        session.close();
        return grouped;
    }

    public Map getSubjectWithLowestGrade() {
        SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select s, avg(g.value) as agv from Grade g " +
                "join g.subject s group by s order by agv asc");
        Object[] singleResult = (Object[]) query.setMaxResults(1).getSingleResult();
        Map<Subject, Double> grouped = new HashMap<>();
        grouped.put((Subject) singleResult[0], Double.valueOf(singleResult[1].toString()));
        transaction.commit();
        session.close();
        return grouped;
    }
}
