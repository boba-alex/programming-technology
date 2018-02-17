package shapes.ellipses;

import shapes.abstract_shapes.Shape2D;


public class Ellipse extends Shape2D {

    private int cornerPoint;

    public Ellipse() {

    }


    public void draw() {

    }

    public int getCornerPoint() {
        return cornerPoint;
    }


    public void setCornerPoint(int newVal) {
        cornerPoint = newVal;
    }

}