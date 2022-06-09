package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //session factrory
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //crate session

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creatin new student object");
            Student tempStudent1 = new Student("Gerard","Garcia","gg@gmail.com");
            Student tempStudent2 = new Student("Oriol","Garcia","af@gmail.com");
            Student tempStudent3 = new Student("Ana","Martinez","am@gmail.com");


            session.beginTransaction();
            System.out.println("Saving the student..." );
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            session.getTransaction().commit();

            System.out.println("Done!");
             Student myStudent2 = session.get(Student.class, tempStudent1.getId());
        }finally {

        }
    }
}
