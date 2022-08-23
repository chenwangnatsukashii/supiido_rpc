package com.example.dubbosimulate.framework.protocol.netty;

import com.example.dubbosimulate.framework.Invocation;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private ChannelHandlerContext context;
    private Invocation invocation;
    private String result;

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        this.context = ctx;
    }

    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg){
        result = msg.toString();
        notify();
    }
    @Override
    public Object call() throws Exception {
        return null;
    }
}
