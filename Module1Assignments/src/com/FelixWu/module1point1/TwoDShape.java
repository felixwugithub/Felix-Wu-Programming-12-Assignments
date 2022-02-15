package com.FelixWu.module1point1;

public class TwoDShape {
     double width;
     double height;

    public TwoDShape(double width, double height){
        this.width = width;
        this.height = height;
    }

    public TwoDShape(){
        width = 0;
        height = 0;
    }

    public double getArea(){
        return(width * height);
    }

    public void setHeight(double height) {
        this.height = height;
    }


}
