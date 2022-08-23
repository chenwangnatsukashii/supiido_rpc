package com.example.dubbosimulate.framework.strategy;

import com.example.dubbosimulate.framework.URL;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 轮询
 */
public class RoundRobinStrategy implements LoadBalanceStrategy{

    private final AtomicInteger index = new AtomicInteger(0);
    @Override
    public URL load(List<URL> list) {
        return list.get(index.incrementAndGet() % list.size());
    }
}
