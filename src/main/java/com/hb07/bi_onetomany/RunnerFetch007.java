package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

public class RunnerFetch007 {
    public static void main(String[] args) {
        Configuration con=new Configuration().configure().
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //DELETE islemi:
        //asamali silme yapabiliriz.

        //HQL ile
        //Book07 tablosundaki tum kayitlari silelim.
//        String hql1="DELETE FROM Book07";
//        int numberOfDeletedRecord=session.createQuery(hql1).executeUpdate();
//        System.out.println("Silinen Kayıt Sayısı: "+numberOfDeletedRecord);
//
//        //Student07 tablosundaki tum kayiltari silelim
//        String hql2="DELETE FROM Student07";
//        int numberOfDeletedRecord2=session.createQuery(hql2).executeUpdate();
//        System.out.println("Silinen Kayıt Sayısı: "+numberOfDeletedRecord2);
//
//        //Kitap ismi: "Java Book" olan kitabi silelim
//        String hql3="DELETE FROM Book07 WHERE name='Java Book'";
//        int numberOfDeletedRecord3=session.createQuery(hql3).executeUpdate();
//        System.out.println("Silinen Kayıt Sayısı: "+numberOfDeletedRecord3);

        //kitabi olan bir ogrenciyi silmek istersek
            //1- once Book tablosunda iliskili booklar silinir, daha sonra ogrenci silinir.
            //2-cascadeType.REMOVAL vs orphanRemoval

        //session in metodu ile
        //id:1001 olan studenti silelim.
//        Student07 student=session.get(Student07.class,1001);
//        session.delete(student);

        // !!! 1002 id li studentin kitap listesinden ilkini silelim
        Student07 student2=session.get(Student07.class,1002);
        student2.getBookList().remove(0);//103,104,105->104,105
        //orphanRemoval=true, listeden bir objeyi kaldirirsak ya da
        //null a set edersek bu objeyi tablodan da kaldiriyor.



        tx.commit();
        session.close();
        sf.close();
    }
}
