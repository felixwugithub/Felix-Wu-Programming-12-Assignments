package com.felixwu.module1point4;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        TwoDShape t1 = new Triangle(1,1,1, Colour.BLUE);
        ((Triangle) t1).rotate90();
        ((Triangle) t1).rotate180();
        ((Triangle) t1).rotate(145);
        System.out.println(((Triangle) t1).getOrientation());


        //ArrayList of shapes as required


        /*
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

         */
        }


}
