package com.example.dubbosimulate.framework.strategy;

import com.example.dubbosimulate.framework.URL;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 加权轮询负载
 */
public class RoundRobinWeightStrategy implements LoadBalanceStrategy {

    private final AtomicInteger index = new AtomicInteger(0);

    @Override
    public URL load(List<URL> list) {
        return list.get(index.incrementAndGet() % list.size());
    }

    public URL load(List<URL> list, List<Integer> weights) {
        List<URL> weightUrls = RandomWeightStrategy.getWeightUrls(list, weights);
        return weightUrls.get(index.incrementAndGet() % weightUrls.size());
    }

}
