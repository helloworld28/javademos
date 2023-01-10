package com.powerjun.demos.corejava.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class FilesDemo {
    public static void main(String[] args) throws IOException {

        if(!Files.exists(Paths.get("test.txt"))){
            Files.createFile(Paths.get("test.txt"));
        }

        Path path = Paths.get("test.txt");
        System.out.println(path.toAbsolutePath());

        String baseDir = System.getProperty("base.dir");
        System.out.println(baseDir);


        byte[] bytes = Files.readAllBytes(Paths.get("test.txt"));
        Files.readAllLines(Paths.get("test.txt"));
        Files.lines(Paths.get("test.txt"));

        Files.write(Paths.get("test.txt"), "Hello".getBytes());
        Files.write(Paths.get("test2.txt"), Arrays.asList("Hello foo"));

        Files.write(Paths.get("test2.txt"), Arrays.asList("Hell bar"), StandardOpenOption.APPEND);

        String contentType = Files.probeContentType(Paths.get("test2.txt"));
        System.out.println(contentType);

        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("test.txt"), Charset.defaultCharset());
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("test.txt"), StandardOpenOption.TRUNCATE_EXISTING);


        if(!Paths.get("a").toFile().exists()){
            Files.createDirectory(Paths.get("a"));
        }
        Files.createDirectories(Paths.get("b/c/d"));

        if (!Paths.get("emptyFile").toFile().exists()) {

            Files.createFile(Paths.get("emptyFile"));
        }

        Path temp = Files.createTempDirectory("temp");
        Path temp1 = Files.createTempFile(temp, "temp", ".txt");
        System.out.println(temp1);

        Files.copy(temp1, Paths.get("a/1.txt"), StandardCopyOption.REPLACE_EXISTING);

//        Files.move(temp1, Paths.get("a/2.txt"), StandardCopyOption.ATOMIC_MOVE);

        Files.deleteIfExists(temp1);

        Files.exists(temp1);

        Files.isDirectory(temp);


        //not enter subdirectory
        try (Stream<Path> entries = Files.list(temp)) {
            entries.forEach(System.out::println);
        }

        try (Stream<Path> pathStream = Files.walk(Paths.get("."))) {
            pathStream.forEach(System.out::println);
        }

        System.out.println("list java files:");
        Files.find(Paths.get("."), Integer.MAX_VALUE, (filePath, atrri) -> {
//            System.out.println(filePath);
            return (filePath.getFileName().toString().endsWith(".java"));
        }).forEach(System.out::println);

        Path source = Paths.get("src");
        Path target = Paths.get("src_copy");
        Files.walk(source).forEach(path1 -> {
            Path q = target.resolve(source.relativize(path1));
            try {
                if (Files.isDirectory(path1)) {

                    Files.createDirectory(q);
                } else {
                    Files.copy(path1, q);
                }
            } catch (IOException e) {

            }
        });


        System.out.println("list java files by directory stream:");
        //just find in the current directory.
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("."), "**.txt")) {
            paths.forEach(System.out::println);
        }



    }
}
