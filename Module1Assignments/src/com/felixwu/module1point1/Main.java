package com.felixwu.module1point1;

public class Main {
    public static void main(String[] args) {
        TwoDShape t1 = new Triangle(1,1);
        System.out.println(t1.getArea());

        TwoDShape t2 = new Triangle(1,1,1);
        System.out.println(t2.getArea());

    }
}
