package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

;

public class EagerLazyDemo {
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
            //get insturctor
            session.beginTransaction();
            int theId=1;
            Instructor tempInstructor = session.get(Instructor.class, theId);
            System.out.println("Instructor:"+ tempInstructor);
            System.out.println("Courses:"+tempInstructor.getCourses());
            session.getTransaction().commit();

            session.close();;
            System.out.println("The session is now closed!");
            System.out.println("Courses:"+tempInstructor.getCourses());
            System.out.println("luv2code:Done!");

        }finally {


            session.close();;
            factory.close();
        }

    }
}
