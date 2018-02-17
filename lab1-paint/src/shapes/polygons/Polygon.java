package shapes.polygons;

import shapes.abstract_shapes.Shape2D;

import java.awt.*;
import java.util.ArrayList;

public class Polygon extends Shape2D {

    private int numberOfPoint;
    private ArrayList<Point> points;

    public Polygon() {

    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public boolean contains(Point p) {
        return false;
    }


    public void draw() {

    }

    public int getNumberOfPoints() {
        return numberOfPoint;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setNumberOfPoints(int newVal) {
        numberOfPoint = newVal;
    }


    public void setPoints(ArrayList<Point> newVal) {
        points = newVal;
    }

}