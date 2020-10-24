package com.jgurgul.j13.reactive.reactorCore;


import reactor.core.publisher.Mono;

public class MonoExample {
    public static void main(String[] args) {
        Mono.fromRunnable(() -> System.out.println("x")).subscribe();
    }
}
