package com.hb10.idgeneration;

import javax.persistence.*;

@Entity
@Table(name = "t_student10")
public class Student10 {

    /*
    AUTO:Default auto-increment öz. kullanir
        Oracle DB -PostreSQL ---> Sequance ( kontrolu developera birakir, Id uretilirken
               baslangic degeri veya kac tane id cachelenecek bu gibi bilgileri developer setleyebilir)
        MySQL - MicrosoftSQL ---> IDENTITY ( kontrol DB de , kendi yaspisina gore id olusturur,
                iclerindeki en bastidir)
    IDENTITY:Kontrol DB de olur, 1 den baslayarak uretir.
    TABLE:id generate etmek icin tablo olusturulur. performansi dusuk, tercih edilmez
    SEQUANCE:id set olusturulur, baslangic sayisini belirleyebiliriz. Performans yuksektir
     */

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "sequencegen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequencegen",//generatorun ismini GeneratedValue annotasyonunda kullaniriz.
                        sequenceName = "student_seq",//DB de bu isimde seq olusur
                         initialValue = 1000,//id nin baslama degeri
                         allocationSize = 5)//id setinde 10 set bulunsun
    @Id
    private int id;

    private String name;

    private int grade;

    public int getId() {
        return id;
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

}
