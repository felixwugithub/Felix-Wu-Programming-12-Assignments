package com.felixwu.module1point3;

public class Circle extends TwoDShape {
    public final double PI = 3.141_592_653_58;
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return (PI * (Math.pow(radius, 2)));
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

}
