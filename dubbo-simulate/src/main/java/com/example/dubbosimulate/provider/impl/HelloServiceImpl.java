package com.example.dubbosimulate.provider.impl;

import com.example.dubbosimulate.provider.api.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String userName) {
        return "Hello" + userName;
    }
}
