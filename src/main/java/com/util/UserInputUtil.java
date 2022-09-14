package com.util;

import java.util.List;
import java.util.Scanner;

public class UserInputUtil {

    public static final Scanner SCANNER = new Scanner(System.in);

    public String UserInputUtil() {
        System.out.println("Please enter your values: ");
        String s = SCANNER.nextLine();
        return s;
    }

    public static int getUserInput(String line, List<String> names) {
        int userInput;
        do {
            System.out.println(line);
            for (int i = 0; i < names.size(); i++) {
                System.out.printf("%d) %s%n", i, names.get(i));
            }
            userInput = SCANNER.nextInt();
        } while (userInput < 0 || userInput >= names.size());
        return userInput;
    }
}
