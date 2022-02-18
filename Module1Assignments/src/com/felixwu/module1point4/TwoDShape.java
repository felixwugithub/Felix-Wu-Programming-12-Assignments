package com.felixwu.module1point4;

public abstract class TwoDShape {

    /**
     * This is an abstract class for a two-dimensional shape.
     * This class contains the width, length, and color of the shape, if relevant.
     *
     * for more info:
     *   https://en.wikipedia.org/wiki/Shape
     *   https://en.wikipedia.org/wiki/Dimension
     */

    //fields
    private double width;
    private double height;
    private Colour colour;


    //constructors
    public TwoDShape(double width, double height, Colour colour){

        if(width > 0 && height > 0) {
            this.width = width;
            this.height = height;
            this.colour = colour;
        }else{
            throw new IllegalArgumentException("Width and Height must be greater than 0");
        }

    }
    public TwoDShape(){
        width = 0;
        height = 0;
        colour = Colour.NONE;
    }

    //setters
    public void setHeight(double height){

        if(height >= 0) {
            this.height = height;
        }
    }
    public void setWidth(double width) {
        if(width >=0 ) {
            this.width = width;
        }
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
