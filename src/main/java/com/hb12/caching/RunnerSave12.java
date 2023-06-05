package com.hb12.caching;

import com.hb11.criteriaapi.Student11;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave12 {

    public static void main(String[] args) {

        Student12 student1=new Student12();
        student1.setName("Ali Can");
        student1.setGrade(100);

        Student12 student2=new Student12();
        student2.setName("Veli Han");
        student2.setGrade(10);

        Student12 student3=new Student12();
        student3.setName("Ayse Tan");
        student3.setGrade(89);


        Configuration con=new Configuration().configure().addAnnotatedClass(Student12.class);

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
