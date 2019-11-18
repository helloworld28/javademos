package com.powerjun.nio;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by Administrator on 2019/11/14.
 */
public class NettyEcoClient {

    private ChannelFuture channelFuture;

    public static void main(String[] args) throws InterruptedException {


        new NettyEcoClient().go();

    }

    private void go() throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    while (true) {
                        String inputString = bufferedReader.readLine();
                        if (inputString != null && channelFuture != null) {



                            channelFuture.channel().writeAndFlush(Unpooled.copiedBuffer(inputString, Charset.defaultCharset()));
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.remoteAddress(new InetSocketAddress("127.0.0.1", 11000))
                .group(eventExecutors)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new EcoClientHandler());
                    }
                });
        channelFuture = bootstrap.connect().sync();
        System.out.println("client is start");
        channelFuture.channel().closeFuture().sync();
    }
}
