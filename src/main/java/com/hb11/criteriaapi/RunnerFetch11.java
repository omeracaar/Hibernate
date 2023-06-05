package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.Queue;
import java.util.Random;

public class RunnerFetch11 {

    public static void main(String[] args) {
        Configuration config=new Configuration().configure().addAnnotatedClass(Student11.class);

        SessionFactory sf=config.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx=session.beginTransaction();

        /*
        session methodlari
            C:save
            R:get
            U:update
            D:delete
         */

        //UPDATE ISLEMI
        Student11 student=session.get(Student11.class,1L);
        student.setMathGrade(100);
        session.update(student);

        //TASK: MathGrade puani 30 dan kucuk olan ogrencilerin puanlarini 80 yapalim
        int deafultgrade=30;
        int updatetgrade=30;
        //String hqlQuery="UPDATE Student11 SET mathGrade=80 WHERE mathGrade<30";
        String hqlQuery="UPDATE Student11 SET mathGrade=:sMath WHERE mathGrade<:lMath";
        Query query=session.createQuery(hqlQuery);
        query.setParameter("sMath",updatetgrade);
        query.setParameter("lMath",deafultgrade);

        int updatedrecord=query.executeUpdate();
        System.out.println("Guncellenen kayit sayisi: "+updatedrecord);

        tx.commit();

        session.close();
        sf.close();
    }
}
