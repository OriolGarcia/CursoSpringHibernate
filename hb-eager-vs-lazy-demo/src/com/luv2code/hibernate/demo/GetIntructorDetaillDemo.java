package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

;

public class GetIntructorDetaillDemo {
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

            session.beginTransaction();
          int theId = 2;
                InstructorDetail tempInstuctorDetail=session.get(InstructorDetail.class,theId);
                System.out.println("temp InstructorDetail: "+tempInstuctorDetail);
                System.out.println("associated insttuctor"+tempInstuctorDetail.getInstructor());
            session.getTransaction().commit();
            System.out.println("Done!");

        }catch (Exception exc){
            exc.printStackTrace();
        }finally {
            factory.close();
        }

    }
}
