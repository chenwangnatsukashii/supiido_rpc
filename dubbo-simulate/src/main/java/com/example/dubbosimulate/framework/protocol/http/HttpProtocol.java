package com.example.dubbosimulate.framework.protocol.http;

import com.example.dubbosimulate.framework.Invocation;
import com.example.dubbosimulate.framework.Protocol;
import com.example.dubbosimulate.framework.URL;

public class HttpProtocol implements Protocol {

    @Override
    public void start(URL url) {
        new HttpServer().start(url.getHostName(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return new HttpClient().send(url.getHostName(), url.getPort(), invocation);
    }
}
