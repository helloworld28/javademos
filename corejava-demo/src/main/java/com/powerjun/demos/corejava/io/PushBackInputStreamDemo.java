package com.powerjun.demos.corejava.io;

import java.io.*;

public class PushBackInputStreamDemo {
    public static void main(String[] args) throws IOException {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(new BufferedInputStream(new FileInputStream("test1.dat")));
        int read = pushbackInputStream.read();
        pushbackInputStream.unread(read);


    }
}
