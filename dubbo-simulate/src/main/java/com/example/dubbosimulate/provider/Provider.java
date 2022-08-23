package com.example.dubbosimulate.provider;

import com.example.dubbosimulate.framework.Protocol;
import com.example.dubbosimulate.framework.URL;
import com.example.dubbosimulate.framework.protocol.http.HttpProtocol;
import com.example.dubbosimulate.framework.protocol.http.HttpServer;
import com.example.dubbosimulate.framework.register.LocalRegister;
import com.example.dubbosimulate.framework.register.RemoteMapRegister;
import com.example.dubbosimulate.provider.api.HelloService;
import com.example.dubbosimulate.provider.impl.HelloServiceImpl;

public class Provider {

    public static void main(String[] args) {

        LocalRegister.register(HelloService.class.getName(), HelloServiceImpl.class);

        URL url = new URL("localhost", 8080);
        RemoteMapRegister.register(HelloService.class.getName(), url);

        Protocol protocol = new HttpProtocol();
        protocol.start(url);
    }
}
