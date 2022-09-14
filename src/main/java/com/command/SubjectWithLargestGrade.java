package com.command;

import com.service.StudentService;
import com.service.SubjectService;

public class SubjectWithLargestGrade implements Command{
    private static SubjectService subjectService = SubjectService.getInstance();

    @Override
    public void execute() {
        subjectService.getSubjectWithLargestGrade();
    }
}
