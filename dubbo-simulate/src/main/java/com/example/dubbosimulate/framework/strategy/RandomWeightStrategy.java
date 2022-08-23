package com.example.dubbosimulate.framework.strategy;

import com.example.dubbosimulate.framework.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 加权随机负载
 */
public class RandomWeightStrategy implements LoadBalanceStrategy {
    @Override
    public URL load(List<URL> list) {
        return new RandomStrategy().load(list);
    }

    public URL load(List<URL> list, List<Integer> weights) {
        // 0~bound（不包含）之间的随机数
        int randomNumber = new Random().nextInt(getWeightUrls(list, weights).size());
        return list.get(randomNumber);
    }

    public static List<URL> getWeightUrls(List<URL> list, List<Integer> weights) {
        if (list.size() != weights.size()) {
            throw new RuntimeException("the size of URLList is not equals to the size of weightsList");
        }

        // 构建加权list
        List<URL> weightUrls = new ArrayList<>(128);

        AtomicInteger index = new AtomicInteger(-1);
        weights.forEach(weight -> {
            int i = index.incrementAndGet();
            weightUrls.addAll(Stream.generate(() -> list.get(i)).limit(weight).collect(Collectors.toList()));
        });

        return weightUrls;
    }
}
