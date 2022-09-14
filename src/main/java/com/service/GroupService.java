package com.service;

import com.model.Grade;
import com.model.GroupStudents;
import com.model.Student;
import com.repository.GroupRepository;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class GroupService {
    Random random = new Random();

    private static GroupService instance;
    private final GroupRepository repository;

    public GroupService(GroupRepository repository) {
        this.repository = repository;
    }

    public static GroupService getInstance() {
        if (instance == null) {
            instance = new GroupService(GroupRepository.getInstance());
        }
        return instance;
    }

//    public double getAverageGradeGroup(GroupStudents groupStudents) {
//            double result = 0;
//            int sum = 0;
//            List<Grade> grades = groupStudents.getStudents()
//                    .stream().map(Student::getGrade).toList();
//            List<Integer> values = grades.stream().map(Grade::getValue).toList();
//            for (Integer value : values) {
//                sum += value;
//            }
//            result = (double) sum / values.size();
//            return result;
//    }

    public GroupStudents create() {
        GroupStudents group = new GroupStudents(
                UUID.randomUUID().toString(),"group-" + random.nextInt(1, 10));
        repository.save(group);
        return group;
    }


    public void findGroupByName(String name){
        List groupByName = repository.findGroupByName(name);
        for (int i = 0; i < groupByName.size(); i++) {
            System.out.println(groupByName.get(i));
        }
    }

    public GroupStudents findGroupByFullName(String fullName){
        return repository.findGroupByFullName(fullName);
    }

    public void getAverageGradeGroup(){
        System.out.println(repository.getAverageGradeGroup());
    }
}
