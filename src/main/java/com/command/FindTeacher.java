package com.command;

import com.service.GroupService;
import com.service.TeacherService;
import com.util.UserInputUtil;

import java.util.Scanner;

public class FindTeacher implements Command{
    private static TeacherService groupService = TeacherService.getInstance();
    private static UserInputUtil userInputUtil = new UserInputUtil();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Please enter name or surname Teacher");
//        String nameTeacher = userInputUtil.UserInputUtil();
        String s = scanner.nextLine();
        groupService.getTeacher(s);
    }
}
