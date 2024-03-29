package com.felixwu.module1point1;


public class Triangle extends TwoDShape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double width, double height){
        super(width, height);
        side1 = width;
    }

    public Triangle(double side1, double side2, double side3){

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        super.setHeight(this.heronsHeight());
        super.width = side1;

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
            return (super.getArea() / 2);
        }
    }
    private double heronsHeight(){
        return (this.getArea() * 2 /side1);
    }



}
