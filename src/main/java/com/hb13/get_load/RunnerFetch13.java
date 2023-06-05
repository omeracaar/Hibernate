package com.hb13.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/*
   get() ---> gerçek nesneyi döndürür ,//eager
   			  nesne yoksa null döner
   			  nesnenin olduğundan emin değilseniz get() kullanın
   			  dönen nesneyi hemen kullanacaksam get() kullanılmalı

   load() ---> proxy nesne döndürür, gerçek nesnenin gölgesi ,//lazy
   			  nesne yoksa exception fırlatır-->ObjectNotFound
   			  dönen nesne üzerinde delete yapılacaksa kullanılabilir
 */

public class RunnerFetch13 {
    public static void main(String[] args) {

        Configuration con=new Configuration().configure().addAnnotatedClass(Student13.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();

        //get
        System.out.println("get metodu çağrılıyor....");
        Student13 student=session.get(Student13.class,1L);
        System.out.println("get metodu çağrıldı.");//DB ye sorgu gönderildi

        System.out.println("Student ID:"+student.getId());
        System.out.println("Student Name:"+student.getName());


        //load
        System.out.println("load metodu çağrılıyor....");
        Student13 student2=session.load(Student13.class,2L);///proxy obje,sorgu kullanılmadı
        System.out.println("load metodu çağrıldı.");//DB ye sorgu gönderilmedi

        System.out.println("Student2 ID:"+student2.getId());
        System.out.println("Student2 Name:"+student2.getName());//objeyi kullanırken DB ye sorgu gönderir

        //olmayan id ile get&load
        Student13 student3=session.get(Student13.class,20L);//null
        if(student3!=null){
            System.out.println("Student ID:"+student3.getId());
            System.out.println("Student Name:"+student3.getName());
        }


        Student13 student4=session.load(Student13.class,200L);//ObjectNotFoundException
        if(student4!=null){
            System.out.println("Student ID:"+student4.getId());
            System.out.println("Student Name:"+student4.getName());
        }

        //peki hangi durumda load kullanılabilir? nesnenin kendisine doğrudan ihtiyaç olmadığında
        Student13 student5=session.get(Student13.class,1L);
        System.out.println("get ile alınan student siliniyor....");
        session.createQuery("DELETE FROM Student13 WHERE id="+student5.getId()).executeUpdate();

        Student13 student6=session.load(Student13.class,3L);
        System.out.println("load ile alınan student siliniyor....");
        session.createQuery("DELETE FROM Student13 WHERE id="+student6.getId()).executeUpdate();

        tx.commit();

        session.close();
        sf.close();


    }
}