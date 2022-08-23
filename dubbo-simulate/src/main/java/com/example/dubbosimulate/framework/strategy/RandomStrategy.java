package com.example.dubbosimulate.framework.strategy;

import com.example.dubbosimulate.framework.URL;

import java.util.List;
import java.util.Random;

/**
 * 随机负载
 */
public class RandomStrategy implements LoadBalanceStrategy {

    @Override
    public URL load(List<URL> list) {
        Random random = new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }
}
