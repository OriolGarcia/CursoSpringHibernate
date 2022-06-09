package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

;

public class CreateCoursesAndReviewsDemo {
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


            // create course
                Course tempCourse = new Course("Pacman - how score");
                tempCourse.addReview(new Review("Great cousrs i lov it"));

            tempCourse.addReview(new Review("Cool"));
            tempCourse.addReview(new Review("You are idoiot"));
            // add reviews
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());
            //save the course
            System.out.println("Saving");
            session.save(tempCourse);

            session.getTransaction().commit();
            System.out.println("Done!");

        }finally {


            session.close();;
            factory.close();
        }

    }
}
