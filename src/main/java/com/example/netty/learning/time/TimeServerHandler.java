package com.example.netty.learning.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeServerHandler extends ChannelInboundHandlerAdapter{

	/**
	 * The channelActive() method will be invoked when a connection is established and ready to generate traffic.
	 * Let's write a 32-bit integer that represents the current time in this method.
	 */
	@Override
	public void channelActive(final ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
//		super.channelActive(ctx);
		// To send a new message, we need to allocate a new buffer which will contain the message. We are going to write a 32-bit integer,
		// and therefore we need a ByteBuf whose capacity is at least 4 bytes. Get the current ByteBufAllocator via ChannelHandlerContext.alloc() 
		// and allocate a new buffer.
//		final ByteBuf time = ctx.alloc().buffer(4);
//		time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
//		
//		final ChannelFuture f = ctx.writeAndFlush(time);
//		f.addListener(new ChannelFutureListener() {
//
//			public void operationComplete(ChannelFuture future) throws Exception {
//				// TODO Auto-generated method stub
//				assert f == future;
//				ctx.close();
//			}
//			
//		});
		
		final ChannelFuture f = ctx.writeAndFlush(new UnixTime());
		f.addListener(ChannelFutureListener.CLOSE);
		
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
//		super.exceptionCaught(ctx, cause);
		cause.printStackTrace();
		ctx.close();
	}

	
}
