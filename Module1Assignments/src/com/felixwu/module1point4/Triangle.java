package com.felixwu.module1point4;


public class Triangle extends TwoDShape implements Rotate {
    private double side1;
    private double side2;
    private double side3;

    //double containing a value that represents the direction the top of the triangle is pointing at. (out of 360 degrees)
    //default is at 0 degrees
    private double orientation;

    //constructors
    public Triangle(double width, double height, Colour colour){
        super(width, height, colour);
        side1 = width;
        orientation = 0;
    }
    public Triangle(double side1, double side2, double side3, Colour colour){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        super.setHeight(this.heronsHeight());
        super.setWidth(side1);
        super.setColour(colour);
        orientation = 0;

    }


    /*
    returns the area of a triangle, requires that the Triangle object is properly instantiated with
    either width & height OR 3 sides
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
    //math magic
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


    //methods related to adjusting the orientation of the shape
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
