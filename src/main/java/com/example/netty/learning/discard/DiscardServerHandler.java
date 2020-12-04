package com.example.netty.learning.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Handles a server-side channel
 * @author simon
 *
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter{

	// Usually, channelRead() handler method is implemented like the following
//	@Override
//	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		try {
//			// Do something with msg
//		} finally {
//			ReferenceCountUtil.release(msg);
//		}
//	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		super.channelRead(ctx, msg);
		ByteBuf in = (ByteBuf) msg;
		
		try {
			while (in.isReadable()) {
				System.out.print((char)in.readByte());
				System.out.flush();
			}
		} finally{
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//		super.exceptionCaught(ctx, cause);
		// Close the connection when an exception is raised.
		cause.printStackTrace();
		ctx.close();
	}

}
