package com.command;

import lombok.Getter;

@Getter
public enum Action {
    AVERAGE_GRADE_GROUP("Average grade group", new AverageGradeGroup()),
    COUNT_STUDENTS_IN_GROUP("Count students in group", new CountStudentsInGroup()),
    FIND_GROUP_BY_NAME("Find group by name", new FindGroupByName()),
    FIND_TEACHER("Find a teacher", new FindTeacher()),
    STUDENT_MORE_AVERAGE_GRADE("Student more average grade", new StudentMoreAverageGrade()),
    SUBJECT_WITH_LARGEST_GRADE("Subject with largest grade", new SubjectWithLargestGrade()),
    SUBJECT_WITH_LOWEST_GRADE("Subject with lowest grade", new SubjectWithLowestGrade()),
    EXIT("Exit", null);

    private String name;
    private Command command;

    Action(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public Command execute() {
        if (command != null) {
            command.execute();
        }
        return command;
    }
}
