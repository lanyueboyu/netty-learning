package com.example.netty.learning.time;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientHandler extends ChannelInboundHandlerAdapter{

	private ByteBuf buf;
	
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
//		super.handlerAdded(ctx);
		buf = ctx.alloc().buffer(4);
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
//		super.handlerRemoved(ctx);
		buf.release();
		buf = null;
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		// TODO Auto-generated method stub
//		super.channelRead(ctx, msg);
		
		UnixTime m = (UnixTime) msg;
		System.out.println(m);
		ctx.close();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
//		super.exceptionCaught(ctx, cause);
		cause.printStackTrace();
		ctx.close();
	}

	
}
