package com.command;

import com.service.GroupService;
import com.util.UserInputUtil;

import java.util.Scanner;

public class FindGroupByName implements Command {
    private static GroupService groupService = GroupService.getInstance();
    private static UserInputUtil userInputUtil = new UserInputUtil();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Please enter name group");
        String s = scanner.nextLine();
        groupService.findGroupByName(s);
    }
}
