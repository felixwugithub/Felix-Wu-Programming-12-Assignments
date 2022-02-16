package com.felixwu.module1point3;


public class Triangle extends TwoDShape implements Rotate {
    private double side1;
    private double side2;
    private double side3;
    private double orientation;

    public Triangle(double width, double height){
        super(width, height);
        side1 = width;
        orientation = 0;
    }

    public Triangle(double side1, double side2, double side3){

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        super.setHeight(this.heronsHeight());
        super.setWidth(side1);
        orientation = 0;

    }


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
                        "}";
    }

    @Override
    public void rotate90() {
        orientation = 90 % 360;
    }

    @Override
    public void rotate180() {
        orientation = 180 % 360;
    }

    @Override
    public void rotate(double degrees) {
        orientation= degrees % 360;
    }

    public double getOrientation(){
        return orientation;
    }
}
