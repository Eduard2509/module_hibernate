package com.command;

import com.service.GroupService;
import com.service.StudentService;
import com.util.UserInputUtil;

public class CountStudentsInGroup implements Command{
    private static StudentService studentService = StudentService.getInstance();

    @Override
    public void execute() {
        studentService.getCountStudentsInGroup();
    }
}
