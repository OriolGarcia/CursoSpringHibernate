package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
;

public class CreateDemo {
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
            Instructor tempInstructor= new Instructor("MArk","Patel","darby@luv2Code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www,youtube.com","guitar");
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            session.beginTransaction();
            System.out.println("Saving the insturctor..."+tempInstructor );
                session.save(tempInstructor);
            session.getTransaction().commit();
            System.out.println("Done!");

        }finally {
            factory.close();
        }

    }
}
