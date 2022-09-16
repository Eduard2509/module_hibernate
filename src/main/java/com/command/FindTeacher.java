package com.command;

import com.service.TeacherService;

import java.util.Scanner;

public class FindTeacher implements Command {
    private static TeacherService groupService = TeacherService.getInstance();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Please enter name or surname Teacher");
        String s = scanner.nextLine();
        groupService.getTeacher(s);
    }
}
