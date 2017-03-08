package com.orlovskiy.dao;

import com.orlovskiy.model.Students;
import com.orlovskiy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey.
 */
public class StudentDAOImpl implements StudentDAO {

    private SessionFactory factory;
    private Transaction tx=null;

    public StudentDAOImpl() {
        this.factory = HibernateUtil.getSessionFactory();
    }

    public Students addStudent(Students student)  {

        try(Session session=factory.openSession()){
            tx = session.beginTransaction();
            session.save(student);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();}
        return student;
    }

    public Students updateStudent(Students student)  {

        try(Session session=factory.openSession()){
            tx = session.beginTransaction();
            session.update(student);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();}
        return student;
    }


    public Students getStudentById(Long id) {
        Students student = null;
        try(Session session=factory.openSession()){
            student = session.get(Students.class, id);
            System.out.println(student);
        } catch (Exception e) {e.printStackTrace();}
        return student;
    }

    public void deleteStudent(Long id) {
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            Students student = session.load(Students.class, id);
            session.delete(student);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Students> getAllStudents() {
        List<Students> students = new ArrayList<>();
        try(Session session=factory.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Students> criteriaQuery = builder.createQuery(Students.class);
            Root<Students> root = criteriaQuery.from(Students.class);
            criteriaQuery.select(root);
            criteriaQuery.orderBy(builder.asc(root.get("id")));
            students = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {e.printStackTrace();}
        return students;
    }
}

