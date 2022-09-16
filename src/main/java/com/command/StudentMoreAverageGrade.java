package com.command;

import com.service.StudentService;

import java.util.Scanner;

public class StudentMoreAverageGrade implements Command {
    private static StudentService studentService = StudentService.getInstance();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Please enter average grade:");
        double averageGrade = Double.parseDouble(scanner.nextLine());
        studentService.getStudentMoreAverageGrade(averageGrade);
    }
}
