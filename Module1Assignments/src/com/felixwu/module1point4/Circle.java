package com.felixwu.module1point4;


public class Circle extends TwoDShape {

    /**
     * A TwoDShape that represents a circle with radius == double radius
     *
     * for more info: https://en.wikipedia.org/wiki/Circle
     */

    public final double PI = 3.141_592_653_58;
    private double radius;

    public Circle(double radius, Colour colour){

        if(radius > 0){
        this.radius = radius;
        super.setColour(colour);
        } else{
            throw new IllegalArgumentException(" Radius of circle MUST be greater than 0");
        }
    }

    @Override
    public double getArea() {
        return (PI * (Math.pow(radius, 2)));
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", colour=" + super.getColour() +
                '}';
    }

}
