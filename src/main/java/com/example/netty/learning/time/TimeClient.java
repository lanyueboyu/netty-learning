package com.example.netty.learning.time;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {

	public static void main(String[] args) throws Exception {
		String host ="127.0.0.1";
		int port = 9090;
    	if (args.length > 0) {
    		host = args[0];
    		port = Integer.parseInt(args[1]);
    	} 
		
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
			// Bootstrap is similar to ServerBootstrap except that it's for non-server channels such as a client-side or connectionless channel.
			Bootstrap b = new Bootstrap();
			// If you specify only one EventLoopGroup, it will be used both as a boss group and as a worker group. The boss worker is not 
			// used for the client side though.
			b.group(workerGroup);
			// Instead of NioServerSocketChannel, NioSocketChannel is being used to create a client-side Channel.
			b.channel(NioSocketChannel.class);
			// Note that we do not use childOption() here unlike we did with ServerBootstrap because the client-side SocketChannel does not have a parent.
			b.option(ChannelOption.SO_KEEPALIVE, true);
			b.handler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					// TODO Auto-generated method stub
					ch.pipeline().addLast(new TimeClientHandler());
				}

			});
			// Start the client
			// We should call the connect() method instead of the bind() method.
			ChannelFuture f = b.connect(host, port).sync();
			
			// Wait until the connection is closed
			f.channel().closeFuture().sync();
		} finally {
			// TODO: handle finally clause
			workerGroup.shutdownGracefully();
		}
	}
}
