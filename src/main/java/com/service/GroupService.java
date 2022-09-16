package com.service;

import com.model.GroupStudents;
import com.repository.GroupRepository;

import java.util.List;
import java.util.Random;
import java.util.UUID;

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


    public GroupStudents create() {
        GroupStudents group = new GroupStudents(
                UUID.randomUUID().toString(), "group-" + random.nextInt(1, 10));
        repository.save(group);
        return group;
    }


    public void findGroupByName(String name) {
        List groupByName = repository.findGroupByName(name);
        for (int i = 0; i < groupByName.size(); i++) {
            System.out.println(groupByName.get(i));
        }
    }

    public void getAverageGradeGroup() {
        System.out.println(repository.getAverageGradeGroup());
    }
}
