package com.hb14.entity_life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch14 {
    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure().addAnnotatedClass(Student14.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx=session.beginTransaction();

        System.out.println("get methodu ile id si 2 olan student load ediliyor...");
        Student14 student=session.get(Student14.class,2L);

        System.out.println("sessionun delete methodu ile id=2 olan student silinecek....");
        session.delete(student);




        tx.commit();
        session.close();

        sf.close();



    }
}