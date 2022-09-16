package com.service;

import com.model.Grade;
import com.repository.GradeRepository;

import java.util.Random;
import java.util.UUID;

public class GradeService {

    private static GradeService instance;
    private final GradeRepository repository;

    public GradeService(GradeRepository repository) {
        this.repository = repository;
    }

    public static GradeService getInstance() {
        if (instance == null) {
            instance = new GradeService(GradeRepository.getInstance());
        }
        return instance;
    }

    GradeRepository gradeRepository = new GradeRepository();
    Random random = new Random();

    public Grade create() {
        Grade grade = new Grade(UUID.randomUUID().toString(), random.nextInt(1, 12));
        gradeRepository.save(grade);
        return grade;
    }
}
