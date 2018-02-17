package shapes.ellipses;

import shapes.abstract_shapes.Shape2D;

import java.awt.*;


public class Ellipse extends Shape2D {

    private int cornerPoint;

    public Ellipse() {

    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public boolean contains(Point p) {
        return false;
    }

    public int getCornerPoint() {
        return cornerPoint;
    }


    public void setCornerPoint(int newVal) {
        cornerPoint = newVal;
    }

}