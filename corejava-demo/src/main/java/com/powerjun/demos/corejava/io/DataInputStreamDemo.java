package com.powerjun.demos.corejava.io;

import java.io.*;

public class DataInputStreamDemo {
    public static void main(String[] args) throws IOException {
        //combine IO

        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("test1.dat"));
        dataOutputStream.writeLong(100L);

        System.out.println(System.getProperty("user.dir"));
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("test1.dat")));

        System.out.println(dataInputStream.readLong());

    }
}
