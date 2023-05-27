package com.hb01.annotation;

import javax.persistence.*;

@Entity//bu classa karsilik DB de bir tablo olusturulsun--> student01
@Table(name = "t_student01")//opsiyonel
//Student101 classina karsilik gelen tablounun  ismini t_student01 olarak degistirdik
//java kodlari ile bu classa ulasmak istersek Stundent01
//SQL komutu ile ulasmak istersek t_stundets01 ile yazmamiz lazim.
public class Student01 {

    @Id//primary key olsumasini sagliyoruz
    private int id;

    @Column(name="std_name",length = 100, nullable = false,unique = true)//opsiyonel
    private String name;

    //@Transient//DB de tabloda grade sutunu olusmasin
    private int grade;

//    @Lob//large object ile buyuk datalari tablomuza kaydedebiliriz.
//    private byte[] image;

    //GETTER-SETTER


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
