package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        //session factrory
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //crate session

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
             List<Student> theStudents = session.createQuery("from Student").list();
           displayStudents(theStudents);
            System.out.println("------------------------------");
            theStudents = session.createQuery("from Student s where s.firstName='Oriol'").list();
           displayStudents(theStudents);
            System.out.println("------------------------------");
            theStudents = session.createQuery("from Student s where s.lastName='Garcia' OR s.firstName='Ana'").list();
            displayStudents(theStudents);
            System.out.println("------------------------------");
            theStudents = session.createQuery("from Student s where s.email LIKE '%luv%'").list();
            displayStudents(theStudents);
            session.getTransaction().commit();
            System.out.println("Done!");

        }finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }
}
