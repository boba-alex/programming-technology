package shapes.lines;

import shapes.abstract_shapes.Shape1D;

import java.awt.*;

public class Segment extends Shape1D {

    private Point secondPoint;

    public Segment() {

    }


    public void draw() {

    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point newVal) {
        secondPoint = newVal;
    }

}