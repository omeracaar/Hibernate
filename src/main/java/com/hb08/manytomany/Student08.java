package com.hb08.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student08")
public class Student08 {

    @Id
    private int id;

    private String name;

    private int grade;

    @ManyToMany
    @JoinTable(name = "student_08_course08",
            joinColumns = {@JoinColumn(name = "std_id")},
            inverseJoinColumns ={@JoinColumn(name = "course_id")})
    private List<Course08> courseList = new ArrayList<>();

    public Student08() {
    }

    public Student08(int id, String name, int grade, List<Course08> courseList) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", courseList=" + courseList +
                '}';
    }
}
