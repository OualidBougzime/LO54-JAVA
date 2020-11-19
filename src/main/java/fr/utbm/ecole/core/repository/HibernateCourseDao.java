package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.Course;
import fr.utbm.ecole.core.tools.HibernateUtil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HibernateCourseDao {

    Transaction transaction = null;

    public void save(Course f) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(f);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public ArrayList<Course> listCourse() {
        ArrayList<Course> courses = new ArrayList<Course>();
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("from Course");
        courses = (ArrayList<Course>) q.list();
        return courses;
    }

    public Course getCourseById(Integer movieId) {
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("video");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Course.class, 1L);
        
    }

    public void update(Course f) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(f);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}