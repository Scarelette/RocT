package com.happy.Handler;

import com.happy.relyOn.RocTMessage;
import com.happy.relyOn.RocTMessageType;
import io.netty.channel.ChannelHandlerContext;

public class ServerProxyHandler extends CommonHandler{
	private RocTServerHandler proxyHandler;
	private int port;
	
    public ServerProxyHandler(RocTServerHandler proxyHandler,int port) {
        this.proxyHandler = proxyHandler;
        this.port = port;
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    	this.ctx = ctx;
        RocTMessage message = new RocTMessage();
        message.setType(RocTMessageType.CONNECTED);
        message.setPort(port);
        message.setChannelId(ctx.channel().id().asLongText());
        proxyHandler.getCtx().writeAndFlush(message);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    	RocTMessage message = new RocTMessage();
    	message.setType(RocTMessageType.DISCONNECTED);
        message.setChannelId(ctx.channel().id().asLongText());
        proxyHandler.getCtx().writeAndFlush(message);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        byte[] data = (byte[]) msg;
        RocTMessage message = new RocTMessage();
        message.setType(RocTMessageType.DATA);
        message.setChannelId(ctx.channel().id().asLongText());
        message.setData(data);
        proxyHandler.getCtx().writeAndFlush(message);
    }
    
}
