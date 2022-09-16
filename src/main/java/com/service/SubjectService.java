package com.service;

import com.model.Subject;
import com.repository.SubjectRepository;

import java.util.UUID;

public class SubjectService {

    private static SubjectService instance;
    private final SubjectRepository repository;

    public SubjectService(SubjectRepository repository) {
        this.repository = repository;
    }

    public Subject create() {
        Subject subject = new Subject(UUID.randomUUID().toString(), "Mathematics");
        repository.save(subject);
        return subject;
    }

    public static SubjectService getInstance() {
        if (instance == null) {
            instance = new SubjectService(SubjectRepository.getInstance());
        }
        return instance;
    }

    public void getSubjectWithLargestGrade() {
        System.out.println(repository.getSubjectWithLargestGrade());
    }

    public void getSubjectWithLowestGrade() {
        System.out.println(repository.getSubjectWithLowestGrade());
    }
}
