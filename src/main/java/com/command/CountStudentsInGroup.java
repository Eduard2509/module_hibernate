package com.command;

import com.service.StudentService;

public class CountStudentsInGroup implements Command {
    private static StudentService studentService = StudentService.getInstance();

    @Override
    public void execute() {
        studentService.getCountStudentsInGroup();
    }
}
