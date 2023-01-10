package com.powerjun.demos.corejava.exersise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Grep {
    public static void main(String[] args) throws IOException {

        if (args.length < 2) {
            System.out.println("Usage: Grep <regEx> <file>");
            return;
        }


        Files.lines(Paths.get(args[1]))
                .filter(input -> Pattern.matches(args[0], input))
                .forEach(System.out::println);
    }
}
