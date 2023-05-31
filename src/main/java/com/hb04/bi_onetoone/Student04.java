package com.hb04.bi_onetoone;
import javax.persistence.*;

@Entity//bu class a karşılık DB de bir tablo oluşturulsun-->student01
@Table(name="t_student04")//opsiyonel
public class Student04 {

    @Id//primary key oluşmasını sağlıyoruz
    private int id;

    @Column(name="std_name",length = 100,nullable = false,unique = false)//opsiyonel
    private String name;

    private int grade;

    @OneToOne(mappedBy = "student")//mappedBy kullanmazsak FK olusur
    private Diary04 diary04;

    public Diary04 getDiary04() {
        return diary04;
    }

    public void setDiary04(Diary04 diary04) {
        this.diary04 = diary04;
    }
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

    //toString

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}