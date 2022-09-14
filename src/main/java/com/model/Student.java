package com.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private String surname;
    private int age;
    private LocalDate startDate;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupStudents group;

    @OneToMany(mappedBy = "student",
                    cascade = CascadeType.PERSIST,
                    orphanRemoval = true,
                    fetch = FetchType.EAGER)
    private List<Grade> grades;

    public Student(){}
    public Student(String id, String name, String surname, int age, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", age=").append(age);
        sb.append(", startDate=").append(startDate);
        sb.append('}');
        return sb.toString();
    }
}
