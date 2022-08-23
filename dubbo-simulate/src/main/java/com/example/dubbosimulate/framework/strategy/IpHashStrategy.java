package com.example.dubbosimulate.framework.strategy;

import com.example.dubbosimulate.framework.URL;

import java.util.List;

/**
 * 对IP取hash负载
 */
public class IpHashStrategy implements LoadBalanceStrategy{
    @Override
    public URL load(List<URL> list) {
        return new RandomStrategy().load(list);
    }

    public URL load(List<URL> list, String ip) {
        return list.get(ip.hashCode() % list.size());
    }
}
