package com.felixwu.module1point4;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<TwoDShape> shapes = new ArrayList<>();
        shapes.add(new Triangle(1,1,1, Colour.BLUE));
        shapes.add(new Triangle(10,10, Colour.RED));
        shapes.add(new Circle(25, Colour.GREEN));
        shapes.add(new Circle(1000, Colour.NONE));

        for (TwoDShape shape: shapes
             ) {
            System.out.println(shape);
            System.out.println("AREA: ");
            System.out.println(shape.getArea());

        }

    }
}
