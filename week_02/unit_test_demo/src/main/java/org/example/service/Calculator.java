package org.example.service;
public class Calculator {
    public int add(int a, int b){
        return a+b;
    }
    public long multiply(long a,long b){
        return a*b;
    }
    public long subtract(long a,long b){
        return a-b;
    }
    public double divide(double a,double b){
        if(b == 0) throw new ArithmeticException("Divide by zero");
        return a/b;
    }
}
