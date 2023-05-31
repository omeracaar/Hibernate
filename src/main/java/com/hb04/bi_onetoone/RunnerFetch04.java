package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sessionFactory =config.buildSessionFactory();//session başlatılmasını sağlar
        Session session=sessionFactory.openSession();
        //sesssion DB ile iletişime geçip bazı işlemler yapmamızı sağlayan metodlara sahip
        Transaction tx =session.beginTransaction();

        //id:1001 student
        Student04 student=session.get(Student04.class,1001);
        System.out.println(student);

        //id: 12 Diary

        Diary04 diary=session.get(Diary04.class,12);
        System.out.println(diary);


        //bi-direction
        System.out.println("***************************");
        System.out.println(diary.getStudent());
        System.out.println("***************************");
        System.out.println(student.getDiary04());

        //uni/bi directional iliskide DB acisindan fark olmaz, sadece tek bir tabloda FK olur
        //ancak uygulama tarafinda uni_direcitonal iliskide sadece iliski sahibi olan classtan diger objeye
        //ulasilir ancak bi_direcitonal iliskide her bir objeden digerine ulasabiliriz.
        //Sadece iliski sahibi class tarafindan set etmek yeterli olur

        // !!! Task 1: Diary ve Student tablolarında ortak kayıtlardan
        //student name ve diary name fieldlarını getirelim.

        String hqlQuery="SELECT s.name,d.name FROM Student04 s INNER JOIN Diary04 d ON s.id=d.student.id";
        List<Object[]> resultList =session.createQuery(hqlQuery).getResultList();
        for (Object[] objects:resultList){
            System.out.println(Arrays.toString(objects));
        }

        // !!! Task 2:Student tablosundaki tüm kayıtları Diary de ortak kayıtlardan
        //student name ve diary name fieldlarını getirelim.

        String hqlQuery2="SELECT s.name,d.name FROM Student04 s LEFT JOIN Diary04 d ON s.id=d.student.id";
        List<Object[]> resultList2 =session.createQuery(hqlQuery2).getResultList();
        for (Object[] objects:resultList2){
            System.out.println(Arrays.toString(objects));
        }

        // !!! Task 3:Diary tablosundaki tüm kayıtları Student de ortak kayıtlardan
        //student name ve diary name fieldlarını getirelim.
        String hqlQuery3="SELECT s.name,d.name FROM Student04 s RIGHT JOIN Diary04 d ON s.id=d.student";// s.id=d.student.id";
        List<Object[]> resulList3=session.createQuery(hqlQuery3).getResultList();//list()
        for(Object[] objects:resulList3){
            System.out.println(Arrays.toString(objects));
        }

        // !!! Task 4:Diary ve Student de tüm kayıtlardan
        //student name ve diary name fieldlarını getirelim.
        String hqlQuery4="SELECT s.name,d.name FROM Student04 s FULL JOIN Diary04 d ON s.id=d.student";// s.id=d.student.id";
        List<Object[]> resulList4=session.createQuery(hqlQuery4).getResultList();//list()
        resulList4.forEach(t-> System.out.println(Arrays.toString(t)));


        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
