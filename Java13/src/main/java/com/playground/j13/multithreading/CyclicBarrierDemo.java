package com.playground.j13.multithreading;

import java.util.concurrent.*;

public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Runnable runnable = () -> {
            for (int i = 0; i < 4; i++) {
                System.out.println(Thread.currentThread().getId() + " : " + i);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }

        };

        ExecutorService es = Executors.newFixedThreadPool(3);

        es.submit(runnable);
        es.submit(runnable);
        es.submit(runnable);


        System.out.println("Done");
    }
}
