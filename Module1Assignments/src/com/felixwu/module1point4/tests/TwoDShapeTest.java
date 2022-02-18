package com.felixwu.module1point4.tests;
import com.felixwu.module1point4.Circle;
import com.felixwu.module1point4.Colour;
import com.felixwu.module1point4.Triangle;
import com.felixwu.module1point4.TwoDShape;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TwoDShapeTest {

    private final double PI = 3.141_592_653_58;
    //partitions
    /*
    getArea of Circle
    getArea of Triangle (base & height)
    getArea of Triangle (three sides)
    heronsHeight of Triangle
     */


    @org.junit.jupiter.api.Test
    void testGetAreaCircle() {
        //unit circle
        TwoDShape c1 = new Circle(1, Colour.NONE);
        assertEquals(PI * (Math.pow(1, 2)), c1.getArea());

        //circle with radius 3.1415926
        TwoDShape c2 = new Circle(3.1415926, Colour.NONE);
        assertEquals(PI * (Math.pow(3.1415926, 2)), c2.getArea());

        //circle with radius 9999
        TwoDShape c3 = new Circle(9999, Colour.NONE);
        assertEquals(PI * (Math.pow(9999, 2)), c3.getArea());

    }

    @org.junit.jupiter.api.Test
    void testGetAreaTriangleBaseTimesHeight() {
        //triangle with base 10 and height 10
        TwoDShape t1 = new Triangle(10, 10, Colour.NONE);
        assertEquals((10*10)/2, t1.getArea());

        //triangle with base 10000 and height 250000
        TwoDShape t2 = new Triangle(1000, 25000, Colour.BLUE);
        assertEquals((1000*25000)/2, t2.getArea());

        //triangle with base 3.1415926 and height 1234567
        TwoDShape t3 = new Triangle(3.1415926, 1234567, Colour.GREEN);
        assertEquals((3.1415926*1234567)/2, t3.getArea());

    }

    @org.junit.jupiter.api.Test
    void testGetAreaHeronsFormula() {
        //triangle with side lengths 1, 1, 1
        TwoDShape t1 = new Triangle(1, 1, 1, Colour.NONE);
        assertEquals(0.4330127018922193, t1.getArea());

        //triangle with side lengths 1, 2, 3
        TwoDShape t2 = new Triangle(1, 2, 3, Colour.NONE);
        //this triangle is actually just a line because a + b = c, which means it has an area of 0
        assertEquals(0.0, t2.getArea());

        //triangle with side lengths 99, 100, 200 (impossible triangle since a + b < c)
        TwoDShape t3 = new Triangle(99, 100, 200, Colour.NONE);
        assertEquals(Double.NaN, t3.getArea());


    }


    @org.junit.jupiter.api.Test
    void heronsHeight() {
        //method is only used when three sides are known
        //triangle with side lengths 1, 1, 1
        TwoDShape t1 = new Triangle(1, 1, 1, Colour.NONE);
        assertEquals(0.8660254037844386, ((Triangle) t1).heronsHeight());

        //triangle with side lengths 1, 2, 3
        TwoDShape t2 = new Triangle(1, 2, 3, Colour.NONE);
        //this triangle is actually just a line because a + b = c, which means it has a height of 0 because it's flat
        assertEquals(0.0, (((Triangle) t2).heronsHeight()));


        //triangle with side lengths 99, 100, 200 (impossible triangle since a + b < c)
        TwoDShape t3 = new Triangle(99, 100, 200, Colour.NONE);
        assertEquals(Double.NaN, ((Triangle) t3).heronsHeight());

    }
}