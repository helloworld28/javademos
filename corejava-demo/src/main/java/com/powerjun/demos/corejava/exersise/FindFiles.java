package com.powerjun.demos.corejava.exersise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FindFiles {
    public static void main(String[] args) throws IOException {
        Files.find(Paths.get("."), Integer.MAX_VALUE, (filePath, atrribute)->{
            return filePath.getFileName().toString().endsWith(".java");
        }).forEach(System.out::println);
    }
}
