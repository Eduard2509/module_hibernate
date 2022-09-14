package com.command;

import com.service.SubjectService;

public class SubjectWithLowestGrade implements Command{
    private static SubjectService subjectService = SubjectService.getInstance();

    @Override
    public void execute() {
        subjectService.getSubjectWithLowestGrade();
    }
}
