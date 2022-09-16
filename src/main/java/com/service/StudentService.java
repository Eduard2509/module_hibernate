package com.service;

import com.model.GroupStudents;
import com.model.Student;
import com.repository.StudentRepository;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

public class StudentService {

    private static StudentService instance;
    private final StudentRepository repository;
    Random random = new Random();

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public static StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService(StudentRepository.getInstance());
        }
        return instance;
    }


    public Student create() {
        GroupStudents group = GroupService.getInstance().create();
        Student student = new Student(UUID.randomUUID().toString(), "Petro", "Herasimov",
                random.nextInt(16, 22), LocalDate.now());
        student.setGroup(group);
        repository.save(student);
        return student;
    }

    public void getCountStudentsInGroup() {
        System.out.println(
                "Count students in group: " + repository.getCountStudentsInGroup());
    }

    public void getStudentMoreAverageGrade(double averageGrade) {
        System.out.println(repository.getStudentMoreAverageGrade(averageGrade));
    }
}
