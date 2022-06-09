package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

;

public class CreateCoursesAndStudentsDemo {
    public static void main(String[] args) {
        //session factrory
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //crate session

        Session session = factory.getCurrentSession();

        try {
            //get insturctor
            session.beginTransaction();


            // create course
                Course tempCourse = new Course("JAVA/SPRING");
                session.save(tempCourse);
                Student tempStudent1 = new Student("Jonh", "Pallarés","miki@gmail.com");
            Student tempStudent2 = new Student("Mary", "gallardo","sergi@gmail.com");
            System.out.println("saving...");
            tempCourse.addStudens(tempStudent1);
            tempCourse.addStudens(tempStudent2);
            session.save(tempStudent1);
            session.save(tempStudent2);
                System.out.println("Saved students" + tempCourse.getStudents());

            session.getTransaction().commit();
            System.out.println("Done!");

        }finally {


            session.close();;
            factory.close();
        }

    }
}
