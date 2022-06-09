package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
;

public class CreateStudentDemo {
    public static void main(String[] args) {
        //session factrory
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //crate session

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creatin new student object");
            Student tempStudent = new Student("Oriol","Garcia","ogs1017@gmail.com");
            session.beginTransaction();
            System.out.println("Saving the student..." );
            session.save(tempStudent);
            session.getTransaction().commit();
            System.out.println("Done!");

        }finally {
            factory.close();
        }

    }
}
