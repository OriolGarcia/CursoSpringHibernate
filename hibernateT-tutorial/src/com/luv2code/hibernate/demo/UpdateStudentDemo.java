package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 7;

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("student id="  +studentId);
            Student myStudent = session.get(Student.class,studentId);
            System.out.println(myStudent);
            System.out.println("Updaating student ...");
                myStudent.setFirstName("victor");

            // commit transaction
            session.getTransaction().commit();
            session = factory.getCurrentSession();
            session.beginTransaction();
             myStudent = session.get(Student.class,studentId);


             session.createSQLQuery("update Student set email='hacked@gmail.com'").executeUpdate();
            session.getTransaction().commit();
            System.out.println(myStudent);

            // MY NEW CODE


            // retrieve student based on the id: primary key


            // commit the transaction


            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

}
