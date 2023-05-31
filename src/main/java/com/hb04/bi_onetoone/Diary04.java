package com.hb04.bi_onetoone;


import javax.persistence.*;

@Entity//tablo ismi diary04
public class Diary04 {//owner of relation/ilişkiyi yöneten(sahibi) tablo

    @Id
    private int id;

    private String name;

    @OneToOne
    @JoinColumn(name="std_id", unique = true)//opsiyonel, aksi halde defaultta : student_id
    private Student04 student;

        //getter-setter

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

    public Student04 getStudent() {
        return student;
    }

    public void setStudent(Student04 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}