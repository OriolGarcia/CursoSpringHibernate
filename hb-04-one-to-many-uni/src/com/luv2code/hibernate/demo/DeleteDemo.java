package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

;

public class DeleteDemo {
    public static void main(String[] args) {
        //session factrory
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        //crate session

        Session session = factory.getCurrentSession();

        try {
            int theId = 1;
            session.beginTransaction();
            Instructor tempInstructor = session.get(Instructor.class, theId);
            if ( tempInstructor!=null){
                System.out.println("Detelting" +  tempInstructor);
                session.delete(( tempInstructor));
            }


            session.getTransaction().commit();
            System.out.println("Done!");

        }finally {
            factory.close();
        }

    }
}
