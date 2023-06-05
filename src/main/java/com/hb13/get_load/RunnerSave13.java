package com.hb13.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerSave13 {
    public static void main(String[] args) {

        Student13 student1=new Student13();
        student1.setName("Ali Can");
        student1.setGrade(100);

        Student13 student2=new Student13();
        student2.setName("Veli Han");
        student2.setGrade(10);

        Student13 student3=new Student13();
        student3.setName("Ayse Tan");
        student3.setGrade(89);


        Configuration con=new Configuration().configure().addAnnotatedClass(Student13.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();

        session.close();
        sf.close();





    }
}