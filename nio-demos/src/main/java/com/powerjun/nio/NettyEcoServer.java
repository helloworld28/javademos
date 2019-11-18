package com.powerjun.nio;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by Administrator on 2019/11/14.
 */
public class NettyEcoServer {
    public static void main(String[] args) throws InterruptedException {
        new NettyEcoServer().go();
    }

    private void go() throws InterruptedException {
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(eventExecutors)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new EcoServerHandler());
                    }
                }).channel(NioServerSocketChannel.class)
                .localAddress(11000);


        ChannelFuture channelFuture = serverBootstrap.bind().sync();
        System.out.println("start server success");

        channelFuture.channel().closeFuture().sync();

    }
}
