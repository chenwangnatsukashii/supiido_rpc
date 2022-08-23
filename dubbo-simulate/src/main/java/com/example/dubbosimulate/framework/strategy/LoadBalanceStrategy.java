package com.example.dubbosimulate.framework.strategy;

import com.example.dubbosimulate.framework.URL;

import java.util.List;

public interface LoadBalanceStrategy {
    URL load(List<URL> list);
}
