package com.example.dubbosimulate.framework.register;

import com.example.dubbosimulate.framework.URL;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RemoteMapRegister {
    private static final Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void register(String interfaceName, URL url) {
        List<URL> list = REGISTER.getOrDefault(interfaceName, new LinkedList<>());
        list.add(url);
        REGISTER.put(interfaceName, list);
    }

    public static List<URL> get(String interfaceName){
        return REGISTER.get(interfaceName);
    }
}
