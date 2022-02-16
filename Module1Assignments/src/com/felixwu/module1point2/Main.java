package com.felixwu.module1point2;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<TwoDShape> shapes = new ArrayList<>();
        shapes.add(new Triangle(1,1,1));
        shapes.add(new Triangle(10,10));
        shapes.add(new Circle(25));
        shapes.add(new Circle(1000));

        for (TwoDShape shape: shapes
             ) {
            System.out.println(shape);
            System.out.println("AREA: ");
            System.out.println(shape.getArea());

        }

    }
}
