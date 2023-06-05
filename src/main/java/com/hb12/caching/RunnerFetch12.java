package com.hb12.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

/*
1)  First Level Cache --->
            * nesneler icin kullanilir
            * defaultta açık geliyor , kapatma durumu yok
            * Aynı session içinde kayıt alır
            * session kapanınca içindekiler silinir

2) Second Level Cache --->
            * Defaultta kapalıdır
            * Session factory seviyesinde cacheleme yapar, yani farklı
                    sessionlar arasında data kullanılabiliyor
            * hibernate.cfg.xml den active edilebilir
            *aynı data aynı sessionda first level cacheden gelir,
             aynı data farklı sessionda second level cacheden gelir.


3) Query Cache
            * Query ler için kullanılıyor
            * hibernate.cfg.xml den active edilebilir
            * First veya Second Level Cache ile kullanilabilir

 */
public class RunnerFetch12 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure().addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("ilk get islemi ile id=1 olan student:");
        Student12 student = session.get(Student12.class, 1L);
        System.out.println(student);

        //---------query cache------------
        Query query=session.createQuery("FROM Student12").setCacheable(true);
        query.getResultList();

        query.getResultList();
        //---------query cache------------



        //session.clear();//sessiondaki cache e alinan datalari temizler.

        //System.out.println("ikinci get islemi ile id=1 olan student:");
        //Student12 student2 = session.get(Student12.class, 1L);
        //System.out.println(student2);


        tx.commit();
        session.close();

        Session session2=sf.openSession();
        Transaction tx2=session2.beginTransaction();

        System.out.println("session close edildikten sonra tekrar get islemi ile id=1 olan student:");
        Student12 student2 = session2.get(Student12.class, 1L);
        System.out.println(student2);


        tx2.commit();
        session2.close();


        sf.close();


        //SONUC:First Level Cache:session seviyesinde
        //DB den bir data cekildiginde cache e alinir.
        //ayni sessionda ayni dataya cekilmek istendiginde DB ye gitmeden cacheden datayi getirir
        //farkli sessionda ayni dataya ulasilmak istendiginde DB ye tekrar sorgu gonderilir
        //session close veya clear edildiginde cache de temizlenir

        //Second Level Cache:session factory seviyesinde
        //farkli sessionda ayni dataya ulasilmak istendiginde DB ye tekrar sorgu gondermez.


    }
}
