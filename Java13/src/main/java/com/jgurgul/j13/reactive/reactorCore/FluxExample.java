package com.jgurgul.j13.reactive.reactorCore;

import reactor.core.publisher.Flux;

public class FluxExample {
    public static void main(String[] args) {
        Flux<Integer> range = Flux.range(1, 5)
                .repeat(2);
        range.subscribe(System.out::println);
        range.onBackpressureDrop(x -> System.out.println("Dropped"));
        range.doOnComplete(() -> System.out.println("Complete"));
        System.out.println("Xxx");
    }
}