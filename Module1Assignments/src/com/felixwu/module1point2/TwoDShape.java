package com.felixwu.module1point2;

public abstract class TwoDShape {

    private double width;
    private double height;

    public TwoDShape(double width, double height){
        this.width = width;
        this.height = height;
    }

    public TwoDShape(){
        width = 0;
        height = 0;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }


    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getArea(){
        return(width * height);
    }

    @Override
    public String toString() {
        return "TwoDShape{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
