package com.example.dubbosimulate.consumer;

import com.example.dubbosimulate.framework.ProxyFactory;
import com.example.dubbosimulate.provider.api.HelloService;

public class Consumer {

    public static void main(String[] args) {

        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String xxx = helloService.sayHello("xxx");
        System.out.println(xxx);


    }
}
