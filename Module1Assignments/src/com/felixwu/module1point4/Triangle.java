package com.felixwu.module1point4;


public class Triangle extends TwoDShape implements Rotate {

    /**
     * Triangle shape:
     *
     *      "A triangle is a polygon with three edges and three vertices. It is one of the basic shapes in geometry.
     *       A triangle with vertices A, B, and C is denoted triangle ABC."
     *
     *       For more info: https://en.wikipedia.org/wiki/Triangle
     *
     * In this program there are two ways to create a triangle:
     * one is to create a triangle by specifying its base and height,
     * the other way is to specify the lengths of the three sides.
     * Additionally, you can rotate the triangle to fulfill other uses.
     *
     * NOTE: YOU MUST PROVIDE THE COLOR OF THE TRIANGLE BECAUSE I LOVE COLORS!!!
     *
     *
     */


    private double side1;
    private double side2;
    private double side3;

    //double containing a value that represents the direction the top of the triangle is pointing at. (out of 360 degrees)
    //default is at 0 degrees
    private double orientation;


    public Triangle(double width, double height, Colour colour){
        super(width, height, colour);
        side1 = width;
        orientation = 0;
    }
    public Triangle(double side1, double side2, double side3, Colour colour){
        if(side1 >= 0 && side2 >= 0 && side3 >= 0) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
            super.setHeight(this.heronsHeight());
            super.setWidth(side1);
            super.setColour(colour);
            orientation = 0;
        }

    }


    /*
    @return the area of the triangle depending on which datasets are available.
        example: if width and height are known, it will use b*h/2; otherwise it will use herons formula. How does herons formula work? read the code because I don't know either.
        for math lovers: https://en.wikipedia.org/wiki/Heron%27s_formula
     */
    public double getArea() {
        if (!(side2 == 0 || side3 == 0)) {
            double semiPerimeter = (side1 + side2 + side3) / 2;
            double area = Math.sqrt(
                    semiPerimeter *
                            (semiPerimeter - side1) *
                            (semiPerimeter - side2) *
                            (semiPerimeter - side3)
            );
            return (area);
        } else {
            return (super.getWidth() * super.getHeight() / 2);
        }
    }

    //@return the height of the triangle perpendicular to side1
    private double heronsHeight(){
        return (this.getArea() * 2 /side1);
    }

    @Override
    public String toString() {
        return

                "Triangle{" +
                "base=" + super.getWidth() +
                        ", height=" + super.getHeight()
                + ", orientation=" + orientation +
                        ", colour=" + super.getColour() +
                        "}";
    }


    //methods related to adjusting the orientation of the shape, very straightforward. Once reached/exceeded 360 degrees it will be reset correctly.
    @Override
    public void rotate90() {orientation = (orientation + 90) % 360;}
    @Override
    public void rotate180() {orientation = (orientation + 180) % 360;}
    @Override
    public void rotate(double degrees) {
        orientation = (orientation + degrees) % 360;
    }
    public double getOrientation(){
        return orientation;
    }
}
