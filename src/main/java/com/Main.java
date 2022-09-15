package com;

import com.command.Action;
import com.command.Command;
import com.model.*;
import com.repository.GradeRepository;
import com.repository.GroupRepository;
import com.repository.StudentRepository;
import com.repository.TeacherRepository;
import com.service.*;
import com.util.UserInputUtil;
import config.HibernateFactoryUtil;
import org.flywaydb.core.Flyway;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HibernateFactoryUtil.getSessionFactory().openSession();
//        StudentService.getInstance().create();
//        TeacherService.getInstance().create();
//        GradeService.getInstance().create();
//        GroupService.getInstance().create();
//        grade.setSubject(subject);
//        grade.setStudent(student);
//        GradeRepository.getInstance().update(grade);
        Flyway flyway = Flyway.configure()
                .dataSource( "jdbc:postgresql://ec2-44-209-158-64.compute-1.amazonaws.com/d8el0m9a1811og" ,
                        "xttvocuwhrudtg" ,
                        "616e96cc7f69e63cc65b1182befd22fa980ab722a6b3d19a4b6e293ac8920381" )
                .baselineOnMigrate(true)
                .locations("db/migration")
                .load();
        flyway.migrate();
//
//        Student student1 = new Student(
//                UUID.randomUUID().toString(), "Igor", "Lachenkov", 22, LocalDate.now());
//        student1.setGroup(student.getGroup());
//        grade.setStudent(student1);
//        StudentRepository.getInstance().save(student1);
//
//        Student student2 = StudentService.getInstance().create();
//        Teacher teacher2 = TeacherService.getInstance().create();
//        Subject subject2 = teacher.getSubject();
//        Grade grade2 = student2.getGrade();
//        grade2.setSubject(subject2);
//        GradeRepository.getInstance().update(grade2);
//        student2.getGrade().setSubject(teacher2.getSubject());
//
//
//        Student student3 = new Student(
//                UUID.randomUUID().toString(), "Victor", "Lavrenko", 21, LocalDate.now());
//        student3.setGroup(student2.getGroup());
//        student3.setGrade(GradeService.getInstance().create());
//        StudentRepository.getInstance().save(student3);
//        Student student1 = StudentService.getInstance().create();
//        Teacher teacher1 = TeacherService.getInstance().create();
//        Subject subject1 = teacher1.getSubject();
//        Grade grade1 = student1.getGrade();
//        grade1.setSubject(subject1);
//        GradeRepository.getInstance().update(grade1);
//        student1.getGrade().setSubject(teacher1.getSubject());
//        GroupRepository.getInstance().getAverageGradeGroupByName(student.getGroup());
//        StudentService.getInstance().getCountStudentsInGroup();


        final Action[] actions = Action.values();
        final List<String> names = getNames(actions);
        Command command;
        do {
            command = executeCommand(actions, names);
        } while (command != null);
    }

    private static Command executeCommand(Action[] actions, List<String> names) {
        int userInput = UserInputUtil.getUserInput("What you want:", names);
        final Action action = actions[userInput];
        return action.execute();
    }

    private static List<String> getNames(Action[] actions) {
        final List<String> names = new ArrayList<>(actions.length);
        for (Action action : actions) {
            names.add(action.getName());
        }
        return names;
    }
}
