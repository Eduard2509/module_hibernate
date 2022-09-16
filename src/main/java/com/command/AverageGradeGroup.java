package com.command;

import com.service.GroupService;

public class AverageGradeGroup implements Command {
    private static GroupService groupService = GroupService.getInstance();

    @Override
    public void execute() {
        groupService.getAverageGradeGroup();
    }
}
