package com.hb08.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course08 {
    @Id
    private int id;

    private String name;

    @ManyToMany(mappedBy = "courseList")//mappedBy kullanilmazsa 2 tane join table olusur.
    private List<Student08> studentList = new ArrayList<>();

    //const


    public Course08() {
    }

    public Course08(int id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Student08> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student08> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Course08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
