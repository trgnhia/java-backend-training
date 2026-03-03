package org.example.service;

public class Factorial {
    public long factorialCount (int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
