package com.powerjun.demos.corejava.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextInputOutput {
    public static void main(String[] args) throws IOException {

        PrintWriter printWriter = new PrintWriter("test.txt", "UTF-8" );
        printWriter.println("你好！世界");
        printWriter.flush();
        printWriter.close();

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("test.txt"), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println(bufferedReader.readLine());


//        Files.readString();
        List<String> strings = Files.readAllLines(Paths.get("/tmp/test.txt"));
        Files.lines(Paths.get("/tmp/test.txt"));


        RandomAccessFile file = new RandomAccessFile("/tmp/test.txt", "rwd");
        file.seek(100);
        file.read();


    }
}
