package com.journaldev.hibernate.main.saving;

import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by dima on 19.02.15.
 */
public class HibernateUpdateExample {
    public static void main(String[] args) {

        // Prep Work
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Employee emp = (Employee) session.load(Employee.class, new Long(11));
        System.out.println("Employee object loaded. " + emp);
        tx.commit();

        // update example
        emp.setName("Updated name");
        emp.getAddress().setCity("Bangalore");
        Transaction tx7 = session.beginTransaction();
        session.update(emp);
        emp.setName("Final updated name");
        System.out.println("13. Before committing update transaction");
        tx7.commit();
        System.out.println("14. After committing update transaction");

        // Close resources
        sessionFactory.close();

    }
}
