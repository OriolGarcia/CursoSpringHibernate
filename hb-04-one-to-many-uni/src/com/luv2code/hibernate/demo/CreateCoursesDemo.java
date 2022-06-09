package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

;

public class CreateCoursesDemo {
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
            Course theCourse1=new Course("air Guitar");
            Course theCourse2=new Course("Pintball");
            tempInstructor.add(theCourse1);
            tempInstructor.add(theCourse2);
             session.save(theCourse2);
            session.save(theCourse1);



            session.getTransaction().commit();
            System.out.println("Done!");

        }finally {


            session.close();;
            factory.close();
        }

    }
}
