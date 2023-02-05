package com.powerjun.demos.corejava.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MemMapDemo {
    public static void main(String[] args) throws IOException {
        FileChannel fileChannel = FileChannel.open(Paths.get("text.txt"));
        MappedByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
        byteBuffer1.put("Hello".getBytes());
        byteBuffer1.flip();
        while (byteBuffer1.hasRemaining()){
            System.out.println(byteBuffer1.get());
        }

        byteBuffer1.rewind();
        byteBuffer1.put("12345".getBytes());


    }
}
