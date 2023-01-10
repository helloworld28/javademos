package com.powerjun.demos.corejava.io;

import java.io.*;

public class IODemo {

    public static void main(String[] args) throws IOException {
        byte[] bytes = "Hello world".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte[]  buffer= new byte[1];
        int n = -1;
        do {
            n = inputStream.read(buffer, 0, buffer.length);
            if (n > -1) {
                outputStream.write(buffer, 0, n);
            }
        } while (n > -1);

        System.out.println(new String(outputStream.toByteArray()));


        inputStream.reset();
        outputStream.reset();

        int available = inputStream.available();
        byte[] outByteArray = new byte[available];
        if (available > 0) {
            inputStream.read(outByteArray);
        }

        outputStream.write(outByteArray);

        System.out.println(new String(outputStream.toByteArray()));

        //neclose to flush
        outputStream.close();





    }
}
