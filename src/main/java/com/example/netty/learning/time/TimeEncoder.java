package com.example.netty.learning.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class TimeEncoder extends ChannelOutboundHandlerAdapter{

	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
		// TODO Auto-generated method stub
//		super.write(ctx, msg, promise);
		UnixTime m = (UnixTime) msg;
		ByteBuf encoded = ctx.alloc().buffer(4);
		encoded.writeInt((int)m.value());
		ctx.write(encoded, promise);
	}

}
