package com.hb14.entity_life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {
    public static void main(String[] args) {


        Student14 student1 = new Student14();
        student1.setName("Ali Can");
        student1.setGrade(100);

        Student14 student2 = new Student14();
        student2.setName("Veli Han");
        student2.setGrade(100);

        Student14 student3 = new Student14();
        student3.setName("Ayse Tan");
        student3.setGrade(100);




        Configuration con = new Configuration().configure().addAnnotatedClass(Student14.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        session.save(student1);//persisted state,DB de karsiligi, Hibernate session tarafindan yonetiliyor.
//        student1.setName("Ahmet");
//
//        session.evict(student1);//detached state
//
//        student1.setName("Mehmet");//bu asamada hala detached modda
//
//        session.update(student1);//persisted state
//        session.merge(student1);//persisted state

        session.save(student2);
        session.save(student3);





        tx.commit();
        session.close();


//        student1.setName("Mehmet");//detached state


        sf.close();
    }


}