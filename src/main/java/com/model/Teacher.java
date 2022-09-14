package com.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private String surname;
    private int age;
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Subject subject;

    public Teacher(String id, String name, String surname, int age, Subject subject) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.subject = subject;
    }

    public Teacher(){}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Teacher{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", age=").append(age);
        sb.append(", subject=").append(subject);
        sb.append('}');
        return sb.toString();
    }
}
