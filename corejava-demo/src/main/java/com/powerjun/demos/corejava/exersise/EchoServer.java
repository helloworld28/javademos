package com.powerjun.demos.corejava.exersise;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8090);

        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket accept = serverSocket.accept();
            System.out.println("received connection!"+accept.getRemoteSocketAddress());
            executorService.submit(() -> {
                try {
                    byte[] buffer = new byte[1024];
                    while (!accept.isClosed()) {
                        InputStream inputStream = accept.getInputStream();
                        OutputStream outputStream = accept.getOutputStream();
                        int read = inputStream.read(buffer);

                        if(read == -1 ){
                            break;
                        }
                        System.out.println("Got Msg from client:" + new String(buffer));

                        outputStream.write(Arrays.copyOf(buffer, read));
                        outputStream.flush();
                        Thread.sleep(1000);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


    }
}
