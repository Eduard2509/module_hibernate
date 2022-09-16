package com.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    String id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "subject_id")
    private Subject subject;
    private int value;

    public Grade(String id, Student student, Subject subject, int value) {
        this.id = id;
        this.student = student;
        this.subject = subject;
        this.value = value;
    }

    public Grade(String id, int value) {
        this.id = id;
        this.value = value;
    }

    public Grade() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Grade{");
        sb.append("id='").append(id).append('\'');
        sb.append(", students=").append(student);
        sb.append(", subject=").append(subject);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
