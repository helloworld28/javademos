package com.powerjun.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by Administrator on 2019/10/21.
 */
public class ChannelCopy {
    public static void main(String[] args) throws IOException {
        ReadableByteChannel readableByteChannel = Channels.newChannel(System.in);
        WritableByteChannel writableByteChannel = Channels.newChannel(System.out);

//        channelCopy1(readableByteChannel, writableByteChannel);
        channelCopy2(readableByteChannel,writableByteChannel);
        readableByteChannel.close();
        writableByteChannel.close();
    }

    public static void channelCopy1(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(12 * 1024);

        while (src.read(byteBuffer) != -1) {

            byteBuffer.flip();
            dest.write(byteBuffer);
            byteBuffer.compact();
        }

        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            dest.write(byteBuffer);
        }
    }

    public static void channelCopy2(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(12 * 1024);
        while (src.read(byteBuffer) != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                dest.write(byteBuffer);
            }
            byteBuffer.clear();
        }
    }
}
