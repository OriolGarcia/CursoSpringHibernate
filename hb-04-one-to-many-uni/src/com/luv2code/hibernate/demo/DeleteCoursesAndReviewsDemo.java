package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

;

public class DeleteCoursesAndReviewsDemo {
    public static void main(String[] args) {
        //session factrory
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        //crate session

        Session session = factory.getCurrentSession();

        try {
            //get insturctor
            session.beginTransaction();


            // get course

            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.delete(tempCourse);
            session.getTransaction().commit();
            System.out.println("Done!");

        }finally {


            session.close();;
            factory.close();
        }

    }
}
