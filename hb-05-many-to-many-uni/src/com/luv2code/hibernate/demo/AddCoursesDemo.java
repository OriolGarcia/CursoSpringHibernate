package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

;

public class AddCoursesDemo {
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
            int studentId = 2;
            Student tempStudent = session.get(Student.class, studentId);
            System.out.println("Loaded student: "+tempStudent );
            System.out.println("Courses: "+tempStudent.getCourses());

            Course tempCourse1 = new Course(" vpon");
            Course tempCourse2 = new Course(" ajax2");
            //tempStudent.addCourse(tempCourse1);
            //tempStudent.addCourse(tempCourse2);
            tempCourse1.addStudens(tempStudent);
            tempCourse2.addStudens(tempStudent);
            session.save(tempCourse1);
            session.save(tempCourse2);
            session.getTransaction().commit();
            System.out.println("Done!");

        }finally {


            session.close();;
            factory.close();
        }

    }
}
