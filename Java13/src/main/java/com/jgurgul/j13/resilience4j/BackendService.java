package com.jgurgul.j13.resilience4j;

import java.util.Random;

public class BackendService {
    public String doSmth(String input) {
        Random r = new Random();
        int i = r.nextInt(3);
        if (i!=1) {
            throw new IllegalStateException("Illegal state");
        }
        return input.toUpperCase() + "_" + input.hashCode();
    }
}
