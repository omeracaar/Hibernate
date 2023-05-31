package com.hb02.embeddable;

import javax.persistence.*;

@Entity
@Table(name = "t_student02")
public class Student02 {

    @Id//primary key olsumasini sagliyoruz
    private int id;

    @Column(name="std_name",length = 100, nullable = false,unique = true)//opsiyonel
    private String name;
    //@Transient//DB de tabloda grade sutunu olusmasin
    private int grade;

    //street
    //city
    //country
    //zipCode
    //Address classinin degiskenleri t_student02 tablosuna sutun olarak eklenir.
    @Embedded//opsiyonel
    private Address address;


//    @Lob//large object ile buyuk datalari tablomuza kaydedebiliriz.
//    private byte[] image;

    //GETTER-SETTER


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

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
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", address=" + address +
                '}';
    }
}
