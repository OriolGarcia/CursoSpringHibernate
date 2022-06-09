package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

;

public class CreateIInstructorDemo {
    public static void main(String[] args) {
        //session factrory
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        //crate session

        Session session = factory.getCurrentSession();

        try {
            Instructor tempInstructor= new Instructor("Susan","Public","darby@luv2Code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www,youtube.com","Video Game");
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            session.beginTransaction();
            System.out.println("Saving the insturctor..."+tempInstructor );
                session.save(tempInstructor);
            session.getTransaction().commit();
            System.out.println("Done!");

        }finally {


            session.close();;
            factory.close();
        }

    }
}
