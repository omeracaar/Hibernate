package com.hb10.idgeneration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {

    public static void main(String[] args) {

        Student10 student1=new Student10();
        student1.setName("Ali");
        student1.setGrade(99);

        Student10 student2=new Student10();
        student2.setName("Veli");
        student2.setGrade(99);

        Student10 student3=new Student10();
        student3.setName("Ali");
        student3.setGrade(99);

        Student10 student4=new Student10();
        student4.setName("Veli");
        student4.setGrade(99);



        Configuration config=new Configuration().configure().addAnnotatedClass(Student10.class);

        SessionFactory sf=config.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx= session.beginTransaction();

        //session.save(student1);
        //session.save(student2);
        session.save(student3);
        session.save(student4);






        tx.commit();
        session.close();
        sf.close();
    }
}
