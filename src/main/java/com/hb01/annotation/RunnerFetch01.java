package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch01 {
    public static void main(String[] args) {

        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        //DB den data cekmek icin 3 yol var

        //1.Yol:sessionin metodunu kullanma
//        Student01 student1=session.get(Student01.class,1001);
//        Student01 student2=session.get(Student01.class,1002);
//        Student01 student3=session.get(Student01.class,1003);
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);

        //2.Yol:SQL kullanarak
//        String sqlQuery="SELECT * FROM t_student01";
//        List<Object[]> resultList=session.createSQLQuery(sqlQuery).getResultList();
//        for (Object[] objects:resultList){
//            System.out.println(Arrays.toString(objects));
//        }

        //3.yol:HQL kullanma
 //       String hqlpQuery="FROM Student01";
 //       List<Student01> resultList2=session.createQuery(hqlpQuery, Student01.class).getResultList();
 //       for (Student01 student:resultList2){
 //           System.out.println(student);
 //       }

        //3 methodu kiyaslayalim
        //1-session methodu, 2-HQL, 3-SQL

        //SQL ile kosul belirterek data cekme
     //   String sqlQuery2="SELECT * FROM t_student01 WHERE std_name='Yusuf Coban'";
     //   Object[] uniqueResult= (Object[]) session.createQuery(sqlQuery2).uniqueResult();
     //   //uniqueResult() gelen kaydin tek satir oldugundan emin oldugumuzda kullanilir.
     //   System.out.println(Arrays.toString(uniqueResult));


   //     //HQL ile kosul belirterek data cekme
   //     String hqlQuery2="From Student01 Where name='Yusuf Çoban'";
   //     //Object student=session.createQuery(hqlQuery2).uniqueResult();
   //     Student01 student=session.createQuery(hqlQuery2, Student01.class).uniqueResult();
   //     System.out.println(student);
//
   //     //yukaridaki sorguda HQL ile alias kullanalim
   //     String hqlQuery3="From Student01 std Where std.name='Yusuf Çoban'";
   //     //Object student=session.createQuery(hqlQuery2).uniqueResult();
   //     Student01 student2=session.createQuery(hqlQuery3, Student01.class).uniqueResult();
   //     System.out.println(student2);

        //HQL ile grade i 98 olan kaydin(ogrencinin) sadece id ve nameini getirelim
        String hqlQuery4="SELECT s.id, s.name From Student01 s Where s.grade='98'";
        Object[] result= (Object[]) session.createQuery(hqlQuery4).uniqueResult();
        System.out.println(Arrays.toString(result));


        tx.commit();
        session.close();
        sessionFactory.close();






    }
}
