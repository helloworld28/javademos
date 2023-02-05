package com.powerjun.demos.corejava.exersise;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket localhost = new Socket(InetAddress.getLocalHost(), 8090);

        System.out.println(localhost.isConnected());

        Scanner scanner = new Scanner(System.in);

        AtomicBoolean shouldStop = new AtomicBoolean(false);

        new Thread(() -> {
            try {
                InputStream inputStream = localhost.getInputStream();
                byte[] buffer = new byte[1024];
                int readNum = -1;

                while (true && (readNum = inputStream.read(buffer)) != -1) {
                    System.out.println("received: " + new String(Arrays.copyOf(buffer, readNum)));

                }
                System.out.println("Connection has been broken");
                shouldStop.set(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        OutputStream outputStream = localhost.getOutputStream();
        new Thread(() -> {
            while (scanner.hasNext() && !shouldStop.get()) {
                String next = scanner.next();
                System.out.println("send:" + next);
                try {
                    outputStream.write(next.getBytes());
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
