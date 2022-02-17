package com.felixwu.module1point4;

public abstract class TwoDShape {

    //fields
    private double width;
    private double height;
    private Colour colour;


    //constructors
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

    //setters
    public void setHeight(double height){
        this.height = height;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    //getters
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



    @Override
    public String toString() {
        return "TwoDShape{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

}
