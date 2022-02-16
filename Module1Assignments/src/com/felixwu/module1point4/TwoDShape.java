package com.felixwu.module1point4;

public abstract class TwoDShape {

    private double width;
    private double height;
    private Colour colour;

    public TwoDShape(double width, double height, Colour colour){
        this.width = width;
        this.height = height;
        this.colour = colour;
    }

    public TwoDShape(){
        width = 0;
        height = 0;
        colour = Colour.NONE;
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

    public Colour getColour(){
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }


    @Override
    public String toString() {
        return "TwoDShape{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
