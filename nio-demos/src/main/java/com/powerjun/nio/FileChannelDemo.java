package com.powerjun.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

/**
 * Created by Administrator on 2019/10/22.
 */
public class FileChannelDemo {
    public static void main(String[] args) throws IOException {
        FileChannel open = FileChannel.open(Paths.get("F:/test/R004.log"));
        System.out.println(open);
        open.close();

        File file = new File("");
        RandomAccessFile randomAccessFile = new RandomAccessFile("","");
        randomAccessFile.read();
        System.out.println();
    }

}
