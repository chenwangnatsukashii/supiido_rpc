package com.example.dubbosimulate.framework.protocol.netty;

import com.example.dubbosimulate.framework.Invocation;
import com.example.dubbosimulate.framework.Protocol;
import com.example.dubbosimulate.framework.URL;

public class DubboProtocol implements Protocol {
    @Override
    public void start(URL url) {
        new NettyServer().start(url.getHostName(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return new NettyClient().send(url.getHostName(), url.getPort(), invocation);
    }
}
