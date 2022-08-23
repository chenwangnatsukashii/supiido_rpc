package com.example.dubbosimulate.framework;

import com.example.dubbosimulate.framework.protocol.http.HttpClient;
import com.example.dubbosimulate.framework.protocol.http.HttpProtocol;
import com.example.dubbosimulate.framework.register.RemoteMapRegister;
import com.example.dubbosimulate.framework.strategy.RandomStrategy;

import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyFactory {

    public static <T> T getProxy(Class<T> interfaceClass) {

        Object proxyInstance = Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{interfaceClass}, (proxy, method, args) -> {
            Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);
            Protocol protocol = new HttpProtocol();

            List<URL> urls = RemoteMapRegister.get(interfaceClass.getName());
            URL url = new RandomStrategy().load(urls);

            return protocol.send(url, invocation);
        });

        return (T) proxyInstance;
    }
}
