package com.service;

import com.model.Subject;
import com.model.Teacher;
import com.repository.GroupRepository;
import com.repository.TeacherRepository;

import java.util.UUID;

public class TeacherService {

    private static TeacherService instance;
    private final TeacherRepository repository;

    public Teacher create(){

        Teacher teacher = new Teacher(UUID.randomUUID().toString(),
                "Gennadiy", "Kitchenko", 32, SubjectService.getInstance().create());
        repository.save(teacher);
        return teacher;
    }

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public static TeacherService getInstance() {
        if (instance == null) {
            instance = new TeacherService(TeacherRepository.getInstance());
        }
        return instance;
    }


    public void getTeacher(String name){
        System.out.println(repository.getTeacher(name));
    }
}
