package com;

import com.command.Action;
import com.command.Command;
import com.util.UserInputUtil;
import config.HibernateFactoryUtil;
import org.flywaydb.core.Flyway;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HibernateFactoryUtil.getSessionFactory().openSession();
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://ec2-44-209-158-64.compute-1.amazonaws.com/d8el0m9a1811og",
                        "xttvocuwhrudtg",
                        "616e96cc7f69e63cc65b1182befd22fa980ab722a6b3d19a4b6e293ac8920381")
                .baselineOnMigrate(true)
                .locations("db/migration")
                .load();
        flyway.migrate();

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
